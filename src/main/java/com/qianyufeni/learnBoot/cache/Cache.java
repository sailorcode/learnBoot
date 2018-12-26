package com.qianyufeni.learnBoot.cache;

public interface Cache<K, V> {
    void put(K key, V value);

    V getValue(K key);

    void remove(K key);

}
