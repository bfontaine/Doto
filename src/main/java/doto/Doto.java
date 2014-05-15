package doto;

import java.lang.reflect.*;

public class Doto implements InvocationHandler {

    private final Object delegate;

    /**
     * Wrap an object with a Doto proxy
     * @param delegate the object to wrap
     **/
    static Object doto(Object delegate, Class klass) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return (Object)Proxy.newProxyInstance(cl, new Class[]{klass},
                                                  new Doto(delegate));
    }

    static Object doto(Object delegate, String className)
            throws ClassNotFoundException {
        return doto(delegate, Class.forName(className));
    }

    private Doto(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        method.invoke(delegate, args);
        return this;
    }
}
