package camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jszybisty on 7/27/2016.
 */
public class ConsoleProcessor implements Processor {

    protected final Logger log = LoggerFactory.getLogger(ConsoleProcessor.class);

    public void process(Exchange exchange) throws Exception {
        log.info("WORKING WITH DATABASE on " + getClass().getName());
    }
}
