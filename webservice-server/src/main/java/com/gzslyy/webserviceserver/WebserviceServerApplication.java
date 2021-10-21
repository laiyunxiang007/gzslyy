package com.gzslyy.webserviceserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebserviceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceServerApplication.class, args);
    }

    @GetMapping("/a")
    public String a() throws JsonProcessingException {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/webservice/api?wsdl");
        Object[] objects = new Object[0];
        ObjectMapper mapper = new ObjectMapper();
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("get", "lisi1");
            System.out.println(mapper.writeValueAsString(objects[0]));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper.writeValueAsString(objects[0]);
    }

}
