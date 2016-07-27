package camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.Map;

/**
 * Created by jszybisty on 7/27/2016.
 */
public class RowConsoleProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        Map row = exchange.getIn().getBody(Map.class);
        System.out.println("Processing row..." + row);
    }
}
