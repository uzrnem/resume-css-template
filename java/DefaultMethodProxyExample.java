package labs;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

/**
 * @author Thomas Darimont
 */
public class DefaultMethodProxyExample {

	public static void main(String[] args) throws Throwable {

		MessageHandler staticHandler = createInstanceViaAnonymousInnerClass();
		staticHandler.handle(new Message());

		MessageHandler dynamicProxyHandler = createDynamicInstanceViaDynamicProxy();
		dynamicProxyHandler.handle(new Message());

		MessageHandler dynamicGeneratedHandler = createDynamicInstanceViaGeneratedClass();
		dynamicGeneratedHandler.handle(new Message());
	}

	private static MessageHandler createDynamicInstanceViaDynamicProxy() {

		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Class<?>[] ifaces = new Class[] { MessageHandler.class };

		InvocationHandler ivocationHandler = (Object proxy, Method method, Object[] arguments) -> //
		MethodHandles.lookup() //
				.in(method.getDeclaringClass()) //
				.unreflectSpecial(method, method.getDeclaringClass()) //
				.bindTo(proxy) //
				.invokeWithArguments(arguments);

		return (MessageHandler) Proxy.newProxyInstance(cl, ifaces, ivocationHandler);
	}

	private static MessageHandler createDynamicInstanceViaGeneratedClass() {
		return ProxyFactory.INSTANCE.newProxyInstance(MessageHandler.class);
	}

	private static MessageHandler createInstanceViaAnonymousInnerClass() {
		return new MessageHandler() {};
	}

	static class Message {}

	public static interface MessageHandler {

		default void handle(Message message) {

			System.out.println("Demo: " + this.getClass());
			System.out.printf("Handle: %s%n", message);
			System.out.printf("Callstack: %n%s%n %n", //
					Arrays.asList(Thread.currentThread().getStackTrace()).stream() //
							.map(Object::toString).collect(Collectors.joining("\n")) //
					);
		}
	}

	static enum ProxyFactory {

		INSTANCE;

		public <T> T newProxyInstance(Class<T> iface) {

			Class<T> proxyClass = ProxyClassGenerator.INSTANCE.generateClass(iface);

			try {
				return iface.cast(proxyClass.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}

	static enum ProxyClassGenerator implements Opcodes {

		INSTANCE;

		private static final String PROXY_SUFFIX = "_Proxy";

		private static final ConcurrentMap<Class<?>, Class<?>> PROXY_CLASS_CACHE = new ConcurrentHashMap<>();

		private Class<?> generateProxyClass(Class<?> iface) {

			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

			String ifaceTypeName = Type.getInternalName(iface);
			String proxyClassName = ifaceTypeName + PROXY_SUFFIX;

			// class definition
			cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, proxyClassName, null, "java/lang/Object", new String[] { ifaceTypeName });

			// default constructor
			MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();

			return ByteArrayClassLoader.INSTANCE.loadClass(iface.getName() + PROXY_SUFFIX, cw.toByteArray());
		}

		@SuppressWarnings("unchecked")
		public <T> Class<T> generateClass(Class<T> iface) {
			return (Class<T>) PROXY_CLASS_CACHE.computeIfAbsent(iface, this::generateProxyClass);
		}
	}

	static class ByteArrayClassLoader extends ClassLoader {

		public static final ByteArrayClassLoader INSTANCE = new ByteArrayClassLoader();

		private ByteArrayClassLoader() {}

		public Class<?> loadClass(String name, byte[] bytes) {

			Class<?> clazz = findLoadedClass(name);
			return clazz != null ? clazz : defineClass(name, bytes, 0, bytes.length);
		}
	}
}
