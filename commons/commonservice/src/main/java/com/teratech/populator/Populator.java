package com.teratech.populator;

/**
 * Convert Entity of type T to entity of type U
 * @param <T>
 * @param <U>
 */
public interface Populator<T , U> {
    /**
     *
     * @param source
     * @param target
     * @throws Exception
     */
    void populate(T source, U target) throws Exception;

    /**
     *
     * @param source
     * @param target
     * @throws Exception
     */
    default void reverse (U source, T target) throws Exception {}
}
