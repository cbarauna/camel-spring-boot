package com.orchestrator.route;

import com.orchestrator.model.ResponseGet;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


@Component
public class OrchestratorRouterBuilder  extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        rest("/services")
                .get()
                .bindingMode(RestBindingMode.auto)
                .outType(ResponseGet.class)
                .param()
                .name("reserva")
                .type(RestParamType.query)
                .dataType("string")
                .required(true)
                .endParam()
                .responseMessage().code(HttpStatus.GATEWAY_TIMEOUT.value()).message("timeoute")
                .endResponseMessage()
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:response-get")



        ;
    }
}
