package WebApplicationListeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static HUtils.HUtilities.getFactory;

@WebListener
public class SFManager implements ServletContextListener {

    public SFManager() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	System.out.println(" ---< Inside ContextDestroyed >--- ");
    	getFactory().close();
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        
    	System.out.println(" ---< Inside ContextInitialized >--- ");
    	getFactory();
    }
	
}
