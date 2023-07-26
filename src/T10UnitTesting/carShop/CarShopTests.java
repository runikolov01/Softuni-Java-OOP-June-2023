package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarShopTests {
    private CarShop carShop;
    private Car audiA4;

    @Before
    public void setUp() {
        carShop = new CarShop();
        audiA4 = new Car("Audi", 130, 4000);
        carShop.add(audiA4);
    }

    @Test
    public void testAddSuccessful() {
        Assert.assertEquals(1, carShop.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testAddUnSuccessful() {
        Car testCar = null;
        carShop.add(testCar);
    }

    @Test
    public void getCarsShouldReturnCorrectList() {
        List<Car> expected = new ArrayList<>();
        expected.add(audiA4);

        List<Car> actualCars = carShop.getCars();

        Assert.assertEquals(expected, actualCars);
    }

    @Test
    public void findCarsMaxSPeedAboveShouldReturnCorrectList() { //Tested N2
        Car car = new Car("Skoda", 198, 599.45);
        Car car2 = new Car("Car2", 10, 24);
        Car car3 = new Car("Car3", 199, 24);
        Car car4 = new Car("Car4", 192, 22);
        carShop.add(car);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);

        List<Car> expectedCars = new ArrayList<>(Arrays.asList(car, car3, car4));
        List<Car> actualCars = carShop.findAllCarsWithMaxHorsePower(190);

        Assert.assertEquals(expectedCars, actualCars);
    }

    @Test
    public void testRemove() {
        Assert.assertEquals(1, carShop.getCount());
        carShop.remove(audiA4);
        Assert.assertEquals(0, carShop.getCount());
    }

    @Test
    public void testGetMostLuxury() {
        Car bmwX5 = new Car("BMWX5", 150, 5500);
        carShop.add(bmwX5);
        Car citroen3 = new Car("CitroenC3", 110, 3300);
        carShop.add(citroen3);
        Car expected = bmwX5;
        Car actual = carShop.getTheMostLuxuryCar();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllCarsByModel() {
        Car audi = new Car("Audi", 100, 2900);
        Car audi2 = new Car("Audi", 140, 3000);
        Car audi3 = new Car("Audi", 150, 3300);
        carShop.add(audi);
        carShop.add(audi2);
        carShop.add(audi3);

        List<Car> expectedCars = new ArrayList<>(Arrays.asList(audiA4, audi, audi2, audi3));
        List<Car> actualCars = carShop.findAllCarByModel("Audi");

        Assert.assertEquals(expectedCars, actualCars);
    }


}

