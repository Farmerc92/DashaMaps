package com.zipcodewilmington.dashamaps;

public interface HashMapX {
    public void set(String key, Integer value);
    public void delete(String key);
    public Integer get(String key);
    public boolean isEmpty();
    public long size();

    public int bucketSize(String key);
}
