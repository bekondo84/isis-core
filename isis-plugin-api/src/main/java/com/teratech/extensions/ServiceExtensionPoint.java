package com.teratech.extensions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public interface ServiceExtensionPoint extends  IsisExtensionPoint{

    default Object getService(final String beanName) {
        assert Objects.nonNull(getContext()) : "Application context is not null";

        return  getContext().getBean(beanName);
    }

    default Object execute(final String beanName, final String methodName, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object beanInstance = getService(beanName);
        assert Objects.nonNull(beanInstance) : String.format("No bean found with name %s", beanName);
        Method[] methods =  beanInstance.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase(methodName)) {
                method.setAccessible(true);
                return method.invoke(beanInstance, args);
            }
        }
        throw new NoSuchMethodException(String.format("Not Method %s found for bean %s", methodName, beanName));
    }
}
