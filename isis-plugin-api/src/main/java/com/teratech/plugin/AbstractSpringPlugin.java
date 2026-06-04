package com.teratech.plugin;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public abstract class AbstractSpringPlugin extends SpringPlugin {

    //private static final Logger LOG = LoggerFactory.getLogger(AbstractSpringPlugin.class);

    /**
     * Abstract Spring Plugin implementation
     * @param wrapper
     */
    public AbstractSpringPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    /**
     *
     */
    @Override
    public void start() {
        super.start();
       // LOG.info(String.format("[Plugin] INFO: Plugin %s has start successfuly", getPluginId()));
    }

    /**
     *
     */
    @Override
    public void stop() {
        super.stop();
       // LOG.info(String.format("[Plugin] INFO: Plugin %s has stop successfuly"));
    }

    /**
     * @return
     */
    @Override
    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //1. Assigner le ClassLoader du plugin au contexte
        ClassLoader pluginClassLoader = this.getWrapper().getPluginClassLoader();
        context.setClassLoader(pluginClassLoader);
        // Crucial : On lie le contexte au Core pour hériter des Beans de persistance (EntityManager, TransactionManager)
        // /!\ CORRECTION ICI : On passe par le wrapper et on cast en SpringPluginManager
        if (this.getWrapper().getPluginManager() instanceof SpringPluginManager) {
            SpringPluginManager springPluginManager = (SpringPluginManager) this.getWrapper().getPluginManager();
            context.setParent(springPluginManager.getApplicationContext());
            System.out.println(String.format("[Plugin] INFO : %s SUCCESSFUL CONNECTED TO THE CORE CONTEXT", getPluginId()));
        } else {
            System.err.println(String.format("[Plugin] ERROR : Plugin %s is not instance of SpringPlugin !!!!", getPluginId()));
        }
        //Utiliser un scanner explicite lié au ClassLoader du plugin
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
        //3. Scanner le package contenant les Beans
        scanner.scan(scanPackages());
        context.refresh();
        return context;
    }

    private String getPluginId() {
        return getWrapper().getPluginId();
    }
    /**
     * Return the list of packages to scan for entities found
     * @return
     */
    public abstract String[] scanPackages() ;
}
