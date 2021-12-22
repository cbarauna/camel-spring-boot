package com.orchestrator.processor;

import com.orchestrator.model.ResponseGet;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class GetProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        var reserva = exchange.getProperty("reserva", String.class);
        var responseGet = ResponseGet.builder()
                .id(1).mesage("message - " + reserva)
                .build();
        exchange.getMessage().setBody(responseGet.toString());
    }
}
