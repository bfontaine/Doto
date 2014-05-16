package doto;

import java.beans.Statement;
import java.lang.reflect.*;

public class Doto<T> implements InvocationHandler {

    private final Object delegate;

    /**
     * Wrap an object with a Doto proxy
     * @param delegate the object to wrap
     **/
    public static <T> T doto(Object delegate, Class klass) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return (T)Proxy.newProxyInstance(cl, new Class[]{klass},
                                             new Doto(delegate));
    }

    public static <T> T doto(Object delegate, String className)
            throws ClassNotFoundException {
        return doto(delegate, Class.forName(className));
    }

    private Doto(Object delegate) {
        this.delegate = delegate;
    }

    public Doto<T> invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        method.invoke(delegate, args);
        return this;
    }
}
