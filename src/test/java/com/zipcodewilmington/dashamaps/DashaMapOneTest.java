package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapOneTest {

    @Before
    public void init(){
        //DashaMapOne  map = new DashaMapOne();
    }

    @Test
    public void constructorTest(){
        DashaMapOne map = new DashaMapOne();
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char holder = (char) (a + i);
            Character alphabet = holder;
            Assert.assertEquals(map.getHashArray()[i].getKey(), alphabet.toString());
        }
    }

    @Test
    public void setTest(){
        DashaMapOne map = new DashaMapOne();

        String expectedKey = "Hello";
        Integer expectedValue = 25;

        map.set(expectedKey, expectedValue);

        Assert.assertEquals(expectedValue, map.get(expectedKey));
    }

    @Test
    public void isEmptyTest(){
        DashaMapOne map = new DashaMapOne();

        String expectedKey = "Hello";
        Integer expectedValue = 25;

        map.set(expectedKey, expectedValue);

        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void isEmptyTest1(){
        DashaMapOne map = new DashaMapOne();

        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void bucketSize(){
        DashaMapOne map = new DashaMapOne();

        String expectedKey = "Hello";
        Integer expectedValue = 25;

        map.set(expectedKey, expectedValue);

        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char holder = (char) (a + i);
            Character alphabet = holder;
            if (i == 7){
                Assert.assertEquals(map.bucketSize(alphabet.toString()), 1);
            }
            else {
                Assert.assertEquals(map.bucketSize(alphabet.toString()), 0);
            }
        }
    }

    @Test
    public void sizeTest(){
        DashaMapOne map = new DashaMapOne();

        String expectedKey = "Hello";
        Integer expectedValue = 25;

        map.set(expectedKey, expectedValue);

        Assert.assertEquals(map.size(), 1);
    }

    @Test
    public void removeTest(){
        DashaMapOne map = new DashaMapOne();

        String expectedKey = "Help";
        Integer expectedValue = 1;
        String expectedKey1 = "Hello";
        Integer expectedValue1 = 2;
        String expectedKey2 = "Helicopter";
        Integer expectedValue2 = 3;

        map.set(expectedKey, expectedValue);
        map.set(expectedKey1, expectedValue1);
        map.set(expectedKey2, expectedValue2);

        Assert.assertEquals(map.bucketSize("h"), 3);

        map.delete("Hello");

        Assert.assertEquals(map.bucketSize("h"), 2);
    }
}
