package camel;

/**
 * Created by jszybisty on 7/26/2016.
 */
import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRunner {
    public static final void main(String[] args) throws Exception {

        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        DatabaseCheckerRoute databaseRouteBuilder = new DatabaseCheckerRoute();
        camelContext.addRoutes(databaseRouteBuilder);
        camelContext.addRoutes(new DatabaseCleanerRoute());

        try {
            camelContext.start();
            Thread.sleep(5 * 60 * 1000);
        } finally {
            camelContext.stop();
        }
    }
}