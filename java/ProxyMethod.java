import java.lang.reflect.*;

interface No {
    public String isRunning(Integer in);
}

class Gisue {
    public static void main(String [] args) {
        No proxyInstance = (No) Proxy.newProxyInstance(
            No.class.getClassLoader(), 
            new Class[] { No.class }, 
            (proxy, method, methodArgs) -> {
                for (Object methodArg: methodArgs) {
                    System.out.println(methodArg);
                }
                return method.getName()+ " called with ";
            }
        );

        System.out.println(proxyInstance.isRunning(9));
    }
}