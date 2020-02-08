package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;
//import org.slf4j.Logger; 
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.access.BeanFactoryLocator;
//import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
//import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

public class SpringBeanInterceptor extends SpringBeanAutowiringInterceptor{
	 
//    private final Logger LOGGER = LoggerFactory.getLogger( this.getClass().getName() );

    @Override
    protected BeanFactoryLocator getBeanFactoryLocator(Object target) {

        return ContextSingletonBeanFactoryLocator.getInstance();
    }
    
//    @Override
//    protected BeanFactoryLocator getBeanFactoryLocator( Object target ){
//    	      LOGGER.info("************** OBTENIENDO: [getBeanFactoryLocator] **************");
//              BeanFactoryLocator objFactoryLocator = ContextSingletonBeanFactoryLocator.getInstance();
//              LOGGER.info("objFactoryLocator 'RETURN': [" + objFactoryLocator + "]");
//              return objFactoryLocator;
//    }
}
