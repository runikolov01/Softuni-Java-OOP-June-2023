package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    private Service firstService;
    private Robot firstRobot;
    private Robot secondRobot;

    @Before
    public void setUp() {
        firstService = new Service("washing", 20);
        firstRobot = new Robot("Ivan");
        secondRobot = new Robot("Maria");
    }

    @Test
    public void testConstructorSuccessful() {
        Service testService = new Service("test", 10);

        Assert.assertEquals("test", testService.getName());
        Assert.assertEquals(10, testService.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorEmptyName() {
        new Service("", 25);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNullName() {
        new Service(null, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorMinusCapacity() {
        new Service("test3", -30);
    }

    @Test
    public void testAddSuccessful() {
        firstService.add(firstRobot);
        Assert.assertEquals(1, firstService.getCount());
        firstService.add(secondRobot);
        Assert.assertEquals(2, firstService.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddException() {
        Service testService = new Service("test", 0);
        testService.add(firstRobot);
    }

    @Test
    public void testRemoveSuccessful() {
        firstService.add(firstRobot);
        Assert.assertEquals(1, firstService.getCount());
        firstService.remove(firstRobot.getName());
        Assert.assertEquals(0, firstService.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithException() {
        firstService.remove("Missing");
    }

    @Test
    public void testForSaleSuccess() {
        firstService.add(firstRobot);
        firstService.forSale("Ivan");

        Assert.assertFalse(firstRobot.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleException() {
        firstService.forSale("missing");
    }

    @Test
    public void testReport() {
        firstService.add(firstRobot);
        firstService.add(secondRobot);

        String expected = "The robot Ivan, Maria is in the service washing!";

        Assert.assertEquals(expected, firstService.report());
    }


}
