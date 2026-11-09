package com.teratech.actions;

import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.metadata.ActionContextData;
import com.teratech.model.cms.ActionModel;
import com.teratech.model.cms.ActionType;

import java.lang.reflect.InvocationTargetException;

public interface ActionService {

    ActionContextData invoke(final ActionModel action, String method, ActionType methodType, final ActionContextData context) throws Exception;
}
