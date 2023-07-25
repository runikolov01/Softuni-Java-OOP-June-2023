package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {3, 4, 6, 8, 9, 10};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //1. Testing constructor
    //1.1. Дали конструкторът създава правилен обект

    @Test
    public void testConstructorCreateValidObject() throws OperationNotSupportedException {
        // Associate
        Integer[] databaseElements = database.getElements();

        //Action
        Assert.assertArrayEquals("Arrays are not the same!", NUMBERS, databaseElements);
        Assert.assertEquals("Count of element is incorrect!", databaseElements.length, NUMBERS.length);
        Assert.assertEquals("Index is incorrect!", NUMBERS.length - 1, database.getIndex());
    }

    //1.2 ако създаваме обект над 16 елемента
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenWeHaveMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenWeHaveLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    //2. Add method
    //2.1. добавяме null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowExceptionNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddSuccessAddedElement() throws OperationNotSupportedException {
        Integer[] elementsBefore = database.getElements();
        database.add(64);
        Integer[] elementsAfter = database.getElements();
        Assert.assertEquals("Invalid add operation!", elementsBefore.length + 1, elementsAfter.length);

        //2. дали е добавен правилния елемент
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(64));
    }

    @Test
    public void testRemoveLastElementSuccessful() throws OperationNotSupportedException {
        Integer[] elementsBefore = database.getElements();
        database.remove();
        Integer[] elementsAfter = database.getElements();
        Assert.assertEquals("Invalid remove operation!", elementsBefore.length - 1, elementsAfter.length);
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(9));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionInvalidIndex() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
       database.remove();
    }


}
