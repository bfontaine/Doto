package doto;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

class Car {
    private int wheels;
    private int doors;
    private String color;

    // getters
    public int getWheels() { return wheels; }
    public int getDoors() { return doors; }
    public String getColor() { return color; }
}

public class DotoTest {
    private Doto dcar;

    @Before
    public void setUp() throws Exception {
        dcar = Doto.doto(new Car());
    }

    @After
    public void tearDown() {}

    @Test
    public void testOneSetter() throws Exception {
        dcar.set("doors", 4);
        assertEquals(4, ((Car)dcar.create()).getDoors());
    }

    @Test
    public void testTwoSetter() throws Exception {
        dcar.set("doors", 2)
            .set("wheels", 12);

        Car car = (Car)dcar.create();

        assertEquals(2, car.getDoors());
        assertEquals(12, car.getWheels());
    }
}
