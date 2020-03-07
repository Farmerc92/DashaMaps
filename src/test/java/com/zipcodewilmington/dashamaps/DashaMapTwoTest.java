package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapTwoTest {

    private DashaMapTwo map;

    @Before
    public void init(){
        map = new DashaMapTwo();

        String expectedKey = "Help";
        Integer expectedValue = 1;
        String expectedKey1 = "Hello";
        Integer expectedValue1 = 2;
        String expectedKey2 = "Helicopter";
        Integer expectedValue2 = 3;
        String expectedKey3 = "Come";
        Integer expectedValue3 = 4;

        map.set(expectedKey, expectedValue);
        map.set(expectedKey1, expectedValue1);
        map.set(expectedKey2, expectedValue2);
        map.set(expectedKey3, expectedValue3);
    }

    @Test
    public void constructorTest(){
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char holder = (char) (a + i);
            Character alphabet = holder;
            Assert.assertEquals(map.getHashArray()[i].getKey(), alphabet.toString());
        }
    }

    @Test
    public void setTest(){
        String expectedKey = "Help";
        Integer expectedValue = 1;
        Assert.assertEquals(expectedValue, map.get(expectedKey));
    }

    @Test
    public void isEmptyTest(){
        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void isEmptyDeleteTest(){
        map.delete("Help");
        map.delete("Hello");
        map.delete("Helicopter");
        map.delete("Come");

        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void bucketSizeTest(){
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char holder = (char) (a + i);
            Character alphabet = holder;
            if (i == 4){
                Assert.assertEquals(map.bucketSize(alphabet.toString()), 3);
            }
            else if (i == 14){
                Assert.assertEquals(map.bucketSize(alphabet.toString()), 1);
            }
            else {
                Assert.assertEquals(map.bucketSize(alphabet.toString()), 0);
            }
        }
    }

    @Test
    public void sizeTest(){
        Assert.assertEquals(map.size(), 4);
    }



}
