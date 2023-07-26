package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExcavationTests {
    private Archaeologist pesho;
    private Archaeologist toshko;
    private Excavation excavation;

    @Before
    public void setUp() {
        pesho = new Archaeologist("Pesho", 20);
        toshko = new Archaeologist("Toshko", 14);
        excavation = new Excavation("Petrich", 10);
    }


    @Test
    public void testConstructor() {
        Excavation excavation = new Excavation("test", 12);
        Assert.assertEquals("test", excavation.getName());
        Assert.assertEquals(12, excavation.getCapacity());
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithNullName() {
        new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithEmptyName() {
        new Excavation("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithNegativeCapacity() {
        new Excavation("test", -20);
    }


    @Test
    public void testAddArcheologistShouldAdd() {
        excavation.addArchaeologist(pesho);
        Assert.assertEquals(1, excavation.getCount());
        excavation.addArchaeologist(toshko);
        Assert.assertEquals(2, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArchShouldThrowIfNoCapacity() {
        Excavation excavation = new Excavation("Petrich", 0);
        excavation.addArchaeologist(pesho);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistShouldThrowIfArchExists() {
        excavation.addArchaeologist(pesho);
        excavation.addArchaeologist(pesho);
    }

    @Test
    public void testRemoveArchShouldRemove() {
        excavation.addArchaeologist(pesho);
        excavation.addArchaeologist(toshko);
        Assert.assertEquals(true, excavation.removeArchaeologist(pesho.getName()));
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void testRemoveArchShouldNotRemove() {
        excavation.addArchaeologist(pesho);
        excavation.addArchaeologist(toshko);
        Assert.assertEquals(false, excavation.removeArchaeologist("missingName"));
        Assert.assertEquals(2, excavation.getCount());
    }
}
