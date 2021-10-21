package com.gzslyy.webserviceserver.config;


import com.gzslyy.webserviceserver.HelloService;
import com.gzslyy.webserviceserver.service.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {
//    @Autowired
//    WebServiceInterceptor webServiceInterceptor;
    /**
     * 注入Servlet 注意beanName不能为dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean  cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public HelloService helloService() {
        return new HelloServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), helloService());
        endpoint.publish("/api");
//        endpoint.getInInterceptors().add(this.webServiceInterceptor);
        return endpoint;
    }
}
