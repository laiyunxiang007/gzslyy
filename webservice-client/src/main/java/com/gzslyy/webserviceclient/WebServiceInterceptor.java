package com.gzslyy.webserviceclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

@Component
@Slf4j
public class WebServiceInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private SAAJInInterceptor saa = new SAAJInInterceptor();
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "123456";

    public WebServiceInterceptor() { //创建拦截
        super(Phase.PREPARE_SEND);
        super.getAfter().add(SAAJInInterceptor.class.getName());  //添加拦截
    }

    @Override
    public void handleMessage(SoapMessage soap) throws Fault {
        List<Header> headers=soap.getHeaders();
        Document document= DOMUtils.createDocument();
        Element auth=document.createElement("authority");
        Element username=document.createElement("username");
        Element password=document.createElement("password");
        username.setTextContent(USER_NAME);
        password.setTextContent(PASSWORD);
        auth.appendChild(username);
        auth.appendChild(password);
        headers.add(0,new Header(new QName("auth"),auth));
    }
}
