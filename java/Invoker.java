
import java.lang.reflect.*;

interface IMyEntity {
    int getValue1();
    void setValue1(int x);
}



public class Invoker {

    public static void main(String[] args) {
        System.out.println("Working Java Code on Docker");
        InvocationHandler handler = new MyInvocationHandler();
        IMyEntity e = (IMyEntity) Proxy.newProxyInstance(
            IMyEntity.class.getClassLoader(),
            new Class[] { IMyEntity.class },
            handler
        );
        e.getValue1();
    }
}

class MyInvocationHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)  {
        System.out.println("This methos is invoked: " + method.getName());
        return 5;
   }
}