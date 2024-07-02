package com.github.williamdlm.message_director.camelprocessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TestProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("Testing: " + exchange.getIn().getBody());
    }
}
