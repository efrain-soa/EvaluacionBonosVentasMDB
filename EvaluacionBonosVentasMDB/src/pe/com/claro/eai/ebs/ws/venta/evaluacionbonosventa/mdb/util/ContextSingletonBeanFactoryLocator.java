package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.SingletonBeanFactoryLocator;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

public class ContextSingletonBeanFactoryLocator extends SingletonBeanFactoryLocator{
    
    public static transient Logger logger = Logger.getLogger(ContextSingletonBeanFactoryLocator.class);
    
    @Override
    protected BeanFactory createDefinition(String resourceLocation, String factoryKey){
		
		final ClassPathXmlApplicationContext objAplicationContext = new ClassPathXmlApplicationContext(new String[]{ resourceLocation }, false);
        final ClassLoader objClassLoader = this.getClass().getClassLoader();
                
        objAplicationContext.setClassLoader(objClassLoader);
              
        return objAplicationContext;
    }    
    
    private static final Map<Object, Object> tablaInstancias = new HashMap<Object, Object>();  

    public static BeanFactoryLocator getInstance() throws BeansException{
		
		BeanFactoryLocator objFactoryLocator = getInstance(Constantes.UBICACION_EJB_SPRING_CONTEXT); 
		logger.debug("objFactoryLocator [Instancia]#1: " + objFactoryLocator);

		return objFactoryLocator;
    }

    public static BeanFactoryLocator getInstance(String selector) throws BeansException {
		
		if((ResourcePatternUtils.isUrl(selector)) == false){
		    selector = (ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + selector);		    
		}
  
		synchronized(tablaInstancias){
			
			if(logger.isDebugEnabled()){
		         logger.debug("ContextSingletonBeanFactoryLocator.getInstance(): instances.hashCode=[" +
						  tablaInstancias.hashCode() + "], instances=[" + tablaInstancias + "]");
		     }
		     
		     BeanFactoryLocator objFactoryLocator = (BeanFactoryLocator)tablaInstancias.get(selector);
		     logger.debug("objFactoryLocator [Instancia]#2: " + objFactoryLocator);

		     if(objFactoryLocator == null){
		         objFactoryLocator = new ContextSingletonBeanFactoryLocator(selector);
		         tablaInstancias.put(selector, objFactoryLocator);
		     }
		     
		return objFactoryLocator;
		}
    }

    protected ContextSingletonBeanFactoryLocator(){
		super(Constantes.UBICACION_EJB_SPRING_CONTEXT);
    }

    protected ContextSingletonBeanFactoryLocator(String nombreRecurso){ 
		super(nombreRecurso);
    }

    protected void initializeDefinition(BeanFactory objBeanFactory) throws BeansException{
		if(objBeanFactory instanceof ConfigurableApplicationContext){
			((ConfigurableApplicationContext) objBeanFactory).refresh();
		}
    }

    protected void destroyDefinition(BeanFactory objBeanFactory, String nombreRecurso) throws BeansException{
		
		if(objBeanFactory instanceof ConfigurableApplicationContext){
			
			if(logger.isDebugEnabled()){
				logger.debug("ContextSingletonBeanFactoryLocator group with resourceName=['" + nombreRecurso + "'] being released, as there are no more references");  
			}
		       
		((ConfigurableApplicationContext)objBeanFactory).close();
		}
    }
    
}