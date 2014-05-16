package doto;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

interface Vehicule {
    public Vehicule setWheels(int w);
    public Vehicule setDoors(int d);
    public Vehicule setColor(String c);

    // getters
    public int getWheels();
    public int getDoors();
    public String getColor();

    public int start();
}

class Car implements Vehicule {
    private int wheels;
    private int doors;
    private String color;

    // setters
    public Vehicule setWheels(int w) { wheels = w; }
    public Vehicule setDoors(int d) { doors = d; }
    public Vehicule setColor(String c) { color = c; }

    // getters
    public int getWheels() { return wheels; }
    public int getDoors() { return doors; }
    public String getColor() { return color; }

    public int start() {
        return 42;
    }
}

public class DotoTest {
    protected Vehicule dcar;

    @Before
    public void setUp() throws Exception {
        dcar = Doto.doto(new Car(), "doto.Vehicule");
    }

    @After
    public void tearDown() {}

    @Test
    public void testOneSetter() throws Exception {
        dcar.setDoors(4);
        assertEquals(4, car.getDoors());
    }

    @Test
    public void testTwoSetter() throws Exception {
        dcar.setDoors(2)
            .setWheels(12);

        assertEquals(2, car.getDoors());
        assertEquals(12, car.getWheels());
    }
}
