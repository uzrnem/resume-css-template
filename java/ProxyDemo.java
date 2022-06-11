package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
  interface If {
    void originalMethod(String str);
  }

  static class Original implements If {
    public void originalMethod(String str) {
        System.out.println(str);
    }
  }

  static class Handler implements InvocationHandler {
    private final If original;
    
    public Handler(If original) {
      this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
      throws IllegalAccessException, IllegalArgumentException,
      InvocationTargetException {

      System.out.println("Before the proxy: ");
      method.invoke(original, args);
      System.out.println("After the proxy: ");
      return null;
    }
  }

  public static void main(String[] args){
    Original original = new Original();
    Handler handler = new Handler(original);
    If a = (If) Proxy.newProxyInstance(If.class.getClassLoader(),
      new Class[] { If.class },
      handler);
    a.originalMethod("Hello");
  }
}