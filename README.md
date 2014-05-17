# doto

`Doto` is a proxy class to make quick builders.

## Building

    mvn install

This creates `target/Doto.jar`.

## Usage

Say you have a class with a lot of fields:

```java
class Human {
    private int eyes;
    private int noses;
    private int mouths;
    private int legs;
    private int arms;
    private String name;

    // ...
}
```

Without Doto, you would need to either have a long constructor:

```java
Human me = new Human(2, 1, 1, 2, 2, "Bob");
```

…or a lot of setters:

```java
Human me = new Human();
me.setEyes(2);
me.setNoses(1);
me.setMouths(1);
me.setLegs(2);
me.setArms(2);
me.setName("Bob");
```

With Doto, you can do the same using chained calls:

```java
Human me = Doto.doto(new Human())
               .set("eyes", 2)
               .set("noses", 1)
               .set("mouths", 1)
               .set("legs", 2)
               .set("arms", 2)
               .set("name", "Bob")
               .create();
```

# History

`Doto` was originally an attempt to make something like Clojure’s [`doto`][cd],
which allows one to call a bunch of methods on an object without repetition:

```clj
(doto (Human.)
      (.setEyes 2)
      (.setNoses 1)
      (.setMouths 1))
```

But Java’s proxies made it hard to have a clean API without requiring too much
work from the developper.

Please note that Doto is more a proof of concept than a production-ready
library.

[cd]: http://clojuredocs.org/clojure_core/clojure.core/doto
