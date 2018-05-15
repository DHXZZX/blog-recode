package com.dh.blogrecode.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map缓存实现
 */
public class MapCache {
    /**
     * 默认存储1024个缓存
     */
    private static final int DEFAULT_CACHES = 1024;

    private static final MapCache INS = new MapCache();

    public static MapCache single() {
        return INS;
    }

    /**
     * 缓存容器
     */
    private Map<String, CacheObject> cachePool;

    @Data
    @AllArgsConstructor
    static class CacheObject {
        private String key;
        private Object value;
        private long expired;
    }

    public MapCache() {
        this(DEFAULT_CACHES);
    }

    public MapCache(int cacheCount) {
        cachePool = new ConcurrentHashMap<>(cacheCount);
    }

    /**
     * 读取一个缓存
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key) {
        CacheObject cacheObject = cachePool.get(key);
        if (Objects.nonNull(cacheObject)) {
            long cur = System.currentTimeMillis() / 1000;
            /**
             * 缓存未过期 直接返回
             */
            if (cacheObject.getExpired() <= 0 || cacheObject.getExpired() > cur) {
                return (T) cacheObject.getValue();
            }
            /**
             * 如果缓存过期,直接删除
             */
            if (cur > cacheObject.getExpired()) {
                cachePool.remove(key);
            }
        }
        return null;
    }

    /**
     * 读取一个hash类型缓存
     *
     * @param key
     * @param field
     * @param <T>
     * @return
     */
    public <T> T hget(String key, String field) {
        key = key + ":" + field;
        return this.get(key);
    }

    /**
     * 设置一个缓存
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        this.set(key, value, -1);
    }

    /**
     * 设置一个带时间的缓存
     *
     * @param key
     * @param value
     * @param expired
     */
    public void set(String key, Object value, long expired) {
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;
        /**
         * cachePool大于800时,强制清空缓存池
         */
        if (cachePool.size() > 800) {
            cachePool.clear();
        }
        CacheObject cacheObject = new CacheObject(key, value, expired);
        cachePool.put(key, cacheObject);
    }

    /**
     * 设置一个hash缓存
     *
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, Object value) {
        this.hset(key, field, value, -1);
    }

    /**
     * 设置一个带时间的hash缓存
     *
     * @param key
     * @param field
     * @param value
     * @param expired
     */
    public void hset(String key, String field, Object value, long expired) {
        key = key + ":" + field;
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;
        CacheObject cacheObject = new CacheObject(key, value, expired);
        cachePool.put(key, cacheObject);
    }

    public void del(String key) {
        cachePool.remove(key);
    }

    public void hdel(String key, String field) {
        key = key + ":" + field;
        this.del(key);
    }

    public void clean() {
        cachePool.clear();
    }

}
