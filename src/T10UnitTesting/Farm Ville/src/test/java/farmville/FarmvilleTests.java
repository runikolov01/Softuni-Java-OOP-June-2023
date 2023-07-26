package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FarmvilleTests {

    private Farm farm;
    private Animal firstAnimal;
    private Animal secondAnimal;

    @Before
    public void setUp() {
        farm = new Farm("Vratsa", 20);
        firstAnimal = new Animal("dog", 10);
        secondAnimal = new Animal("cat", 30);

    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("Vratsa", farm.getName());
        Assert.assertEquals(20, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNullName() {
        Farm farm = new Farm(null, 20);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorEmptyName() {
        Farm farm = new Farm("", 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithNegativCapacity() {
        new Farm("test", -20);
    }

    @Test
    public void testAddAnimalSuccessful() {
        farm.add(firstAnimal);
        Assert.assertEquals(1, farm.getCount());
        farm.add(secondAnimal);
        Assert.assertEquals(2, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalThrowIfNoCapacity() {
        Farm newFarm = new Farm("test", 0);
        Animal an = new Animal("testtt", 0);
        newFarm.add(an);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowIfAnimalExists() {
        farm.add(secondAnimal);
        farm.add(secondAnimal);
    }

    @Test
    public void testRemoveSuccessful() {
        farm.add(firstAnimal);
        farm.add(secondAnimal);
        Assert.assertEquals(true, farm.remove("dog"));
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveUnSuccessful() {
        farm.add(firstAnimal);
        farm.add(secondAnimal);
        Assert.assertEquals(false, farm.remove("missing"));
        Assert.assertEquals(2, farm.getCount());
    }


}
