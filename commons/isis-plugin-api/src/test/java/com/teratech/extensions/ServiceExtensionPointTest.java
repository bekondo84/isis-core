package com.teratech.extensions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class ServiceExtensionPointTest implements ServiceExtensionPoint{

    private ApplicationContext context ;
    @Before
    public void setUp() throws Exception {
        context = Mockito.mock(ApplicationContext.class);
    }

    /*@Test
    public void TestExecute() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Mockito.when(context.getBean("testService")).thenReturn(new TestService());
        Object value = execute("testService", "testMethod", "TEST");
        assertTrue(Objects.nonNull(value));
        assertTrue(value instanceof String);
        assertEquals(value, "TEST");
    }

    //@Test
    public void TestVoidExecute() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Mockito.when(context.getBean("testService")).thenReturn(new TestService());
        List testLisr = new ArrayList<>();
        //Object value = execute("testService", "testVoidMethod", testLisr);
       assertTrue(!testLisr.isEmpty());
       // assertEquals(value, "TEST");
    }*/
    /**
     * @return the current plugin name
     */
    @Override
    public String plugin() {
        return "";
    }

    /**
     * Return the spring application context
     *
     * @return
     */
    @Override
    public ApplicationContext getContext() {
        return context;
    }
}