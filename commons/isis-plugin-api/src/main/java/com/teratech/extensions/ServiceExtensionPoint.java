package com.teratech.extensions;

import com.teratech.jaxb.entities.Controllers;
import com.teratech.jaxb.entities.Services;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginWrapper;
import org.springframework.beans.BeansException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

public interface ServiceExtensionPoint extends  IsisExtensionPoint{

    default Object getService(final PluginWrapper wrapper, final String beanName) throws JAXBException, ClassNotFoundException {
        assert Objects.nonNull(getContext()) : "Application context is not null";
        JAXBService jaxbService = new JAXBServiceImpl();
        Services services = jaxbService.getServiceFromResources(wrapper);
        Optional<Services.Service> service = services.getService().stream().filter(serv -> serv.getName().equalsIgnoreCase(beanName)).findAny();
        if (service.isEmpty()) {
            throw new IllegalArgumentException(String.format("Bean with name %s is not a publish service of plugin %s", beanName, wrapper.getPluginId()));
        }
        Class clazz = wrapper.getPluginClassLoader().loadClass(service.get().getClazz());
        return  getContext().getBean(clazz);
    }

    default Object execute(final PluginWrapper wrapper, final String beanName, final String methodName, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, JAXBException, ClassNotFoundException {
        Object beanInstance = getService(wrapper, beanName);
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
