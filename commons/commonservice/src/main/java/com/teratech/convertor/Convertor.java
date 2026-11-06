package com.teratech.convertor;

public interface Convertor <T, S>{
    S convert(T source);
}
