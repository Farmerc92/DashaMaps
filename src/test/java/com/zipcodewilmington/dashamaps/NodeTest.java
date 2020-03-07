package com.zipcodewilmington.dashamaps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    private Node node;

    @Before
    public void init(){
        String key = "";
        Integer value = 1;

        node = new Node(key, value, null);
    }

    @After
    public void finalize(){
        String key = "";
        Integer value = 1;

        node = new Node(key, value, null);
    }

    @Test
    public void constructorTest(){
        String expectedKey = "";
        Integer expectedValue = 1;

        Assert.assertEquals(expectedKey, node.getKey());
        Assert.assertEquals(expectedValue, node.getValue());
        Assert.assertEquals(null, node.getNext());
    }

    @Test
    public void setKey(){
        String expectedKey = "a";
        node.setKey(expectedKey);

        Assert.assertEquals(expectedKey, node.getKey());
    }

    @Test
    public void setValue(){
        Integer expectedValue  = 1;
        node.setValue(expectedValue);

        Assert.assertEquals(expectedValue, node.getValue());
    }

    @Test
    public void setNode(){
        Node next = new Node(null, null, null);
        node.setNext(next);

        Assert.assertEquals(next, node.getNext());
    }
}
