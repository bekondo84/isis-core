package com.teratech.extensions;

import com.teratech.actions.ActionService;
import com.teratech.actions.annotations.Action;
import com.teratech.metadata.ActionContextData;
import com.teratech.model.cms.ActionModel;
import com.teratech.model.cms.ActionType;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public interface ActionExtension extends IsisExtensionPoint{

    /**
     * All action is by defaut exposed
     * @param actionContext
     * @param action
     * @param method
     * @param type
     * @return
     */
    default ActionContextData invoke (ActionContextData actionContext, ActionModel action, String method, ActionType type) throws InvocationTargetException, IllegalAccessException {
        assert Objects.nonNull(action): "Action can't be null";
        assert StringUtils.isNotBlank(method) : "No method is define";

        Object actionBean = getApplicationContext().getBean(action.getBean());
        assert actionBean.getClass().isAnnotationPresent(Action.class): String.format("%s n'est pas une action, vérifier la configuration de ce bean");

        return  ((ActionService)actionBean).invoke(action, method, type, actionContext);

    }

    ApplicationContext getApplicationContext();
}
