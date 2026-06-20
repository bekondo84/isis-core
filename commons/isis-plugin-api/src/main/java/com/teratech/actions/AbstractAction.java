package com.teratech.actions;

import com.teratech.actions.annotations.ActionMethod;
import com.teratech.metadata.ActionContextData;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AbstractAction {

    /**
     * Save or update new record in the database
     * @param context
     * @return
     */
    @ActionMethod(value = "save", scope = RequestMethod.POST)
     ActionContextData createOrUpdate(final ActionContextData context) {
         final String className = (String) context.get("class");
         final String pluginId = (String) context.get("plugin.id");
         if(StringUtils.isBlank(className))
             throw new IllegalArgumentException(String.format(""));

         return context;
     }

    /**
     * Fetch List of items
     * @param context
     * @return
     */
     @ActionMethod(value = "fetchitems", scope = RequestMethod.GET)
    public ActionContextData getItems (final ActionContextData context) {

        return context;
    }

    /**
     * Fetch single Item
     * @param context
     * @return
     */
    @ActionMethod(value = "fetchitem", scope = RequestMethod.GET)
    public ActionContextData getItem (final ActionContextData context) {

        return context;
    }

    /**
     * Delete Items or list of items
     * @param context
     * @return
     */
   @ActionMethod(value = "delete", scope = RequestMethod.DELETE)
    public ActionContextData delete (final ActionContextData context) {
        return context;
   }
}
