package doto;

import java.lang.reflect.Field;

public class Doto<T> {

    private final T delegate;
    private final Class<?> klass;

    /**
     * Wrap an object in a Doto class
     * @param delegate the wrapped object
     **/
    public static <T> Doto doto(T delegate) {
        return new Doto(delegate);
    }

    private Doto(T delegate) {
        this.delegate = delegate;
        this.klass = delegate.getClass();
    }

    /**
     * Return the underlying object.
     **/
    public T create() {
        return (T)delegate;
    }

    /**
     * Set a property on the underlying object and return itself. This allows
     * chained calls.
     * @param name the property's name
     * @param value the value to set
     * @return the current Doto object
     **/
    public Doto set(String name, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        Field f = klass.getDeclaredField(name);
        f.setAccessible(true);
        f.set(delegate, value);

        return this;
    }
}
