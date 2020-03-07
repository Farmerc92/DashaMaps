package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class DashaMapThreeTest {

    private DashaMapOne mapOne;
    private DashaMapTwo mapTwo;
    private DashaMapThree  mapThree;
    private static final Logger LOGGER = Logger.getLogger(DashaMapThreeTest.class.getName());

    @Before
    public void init(){
        textReader reader = new textReader();
        reader.readFile();
        mapOne = reader.getMapOne();
        mapTwo = reader.getMapTwo();
        mapThree = reader.getMapThree();
    }

    @Test
    public void testBucketSize(){
        long sizeMapOne = mapOne.size();
        long sizeMapTwo = mapTwo.size();
        long sizeMapThree = mapThree.size();

        Assert.assertEquals(sizeMapOne, 124);
        Assert.assertEquals(sizeMapTwo, 124);
        Assert.assertEquals(sizeMapThree, 122);
    }

    @Test
    public void testConstructor(){
        DashaMapThree mapp = new DashaMapThree();

        char a = 'a';
        char a1 = 'a';
        int count = 0;
        for (int i = 0; i < 26; i++) {
            char holder = (char) (a+i);
            Character alphabet = holder;
            for (int j = 0; j < 26; j++) {
                char holder1 = (char) (a1 + j);
                Character alphabet1 = holder1;
                Assert.assertEquals(mapp.getHashArray()[count].getKey(), alphabet.toString() + alphabet1.toString());
                count++;
            }
        }
    }

    @Test
    public void setTest(){
        DashaMapThree mapp = new DashaMapThree();

        mapp.set("AA", 10);
        mapp.set("ZZ", 1);

        Integer expected = mapp.get("AA");
        Integer actual = 10;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void deleteTest(){
        LOGGER.info("\n" + mapThree.get("themselves"));
        mapThree.delete("themselves");
        mapThree.get("themselves");
    }

    @Test
    public void isEmptyTest(){
        Assert.assertFalse(mapThree.isEmpty());
    }
}
