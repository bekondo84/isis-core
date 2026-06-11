package com.teratech.populator;

/**
 * Convert Entity of type T to entity of type U
 * @param <T>
 * @param <U>
 */
public interface Populator<T , U> {
    void populate(T source, U target);
}
