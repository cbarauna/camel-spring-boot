package com.orchestrator.route;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orchestrator.model.ResponseGet;
import com.orchestrator.processor.GetProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.util.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GetRouter extends RouteBuilder {
    @Autowired
    private GetProcessor processor;
    @Override
    public void configure() throws Exception {

        from("direct:response-get")
                .setProperty("reserva", header("reserva"))
                //.process(processor)
                .process(exchange ->  {

                    String reserva = exchange.getIn().getBody(String.class);
                var response =    new ResponseGet(1, "teste" + reserva);


                    exchange.getMessage().setBody(new  ObjectMapper().writeValueAsString(response));
                })
                ;
    }
}
