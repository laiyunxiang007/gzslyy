package com.gzslyy.webserviceserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "HelloService",targetNamespace = "http://webservice.gzslyy.com")
public interface HelloService {
     @WebMethod
     String get(@WebParam String a);
}
