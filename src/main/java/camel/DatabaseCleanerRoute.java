package camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by jszybisty on 7/27/2016.
 */
public class DatabaseCleanerRoute extends RouteBuilder {

    public static final String DB_UPDATED = "DATABASE HAS BEEN UPDATED";

    public void configure() throws Exception {
        from("scheduler://scheduler?initialDelay=30000&delay=60000")
                .log("DatabaseCleanerRoute - UPDATING DATABASE")
                .setBody(constant("UPDATE users SET STATUS = 'NORMAL' WHERE STATUS='NEW'"))
                .to("jdbc:dataSource")
                .setHeader("subject", simple("New mail from apache camel"))
                .setBody(simple(DB_UPDATED))
                .to("smtps://smtp.gmail.com?username=testowekontoxdd@gmail.com&password=testowekonto&to=kregielnial09@gmail.com")
                .log(DB_UPDATED);
    }
}
