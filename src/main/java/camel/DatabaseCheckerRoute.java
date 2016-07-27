package camel;

import org.apache.camel.builder.RouteBuilder;

import javax.sql.DataSource;


public class DatabaseCheckerRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("timer://timer?period=60s")
                .log("DatabaseCheckerRoute - SELECTING FROM DATABASE")
                .setBody(constant("SELECT * FROM users WHERE STATUS='NEW'"))
                .to("jdbc:dataSource")
                .split(simple("${body}"))
                .process(new RowConsoleProcessor())
                .bean(new Transformer(), "transform")
                .setHeader("subject", simple("Nowy rekord"))
                .to("smtps://smtp.gmail.com?username=testowekontoxdd@gmail.com&password=testowekonto&to=kregielnial09@gmail.com");
    }
}
