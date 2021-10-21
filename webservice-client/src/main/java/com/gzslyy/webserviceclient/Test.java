package com.gzslyy.webserviceclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class Test {
    public static void main(String[] args) {
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
    }

}
