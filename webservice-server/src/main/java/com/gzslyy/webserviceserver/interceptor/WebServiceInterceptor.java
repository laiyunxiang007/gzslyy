package com.gzslyy.webserviceserver.interceptor;//package com.gzslyy.webserviceserver.interceptor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.cxf.binding.soap.SoapMessage;
//import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
//import org.apache.cxf.interceptor.Fault;
//import org.apache.cxf.phase.AbstractPhaseInterceptor;
//import org.apache.cxf.phase.Phase;
//import org.springframework.stereotype.Component;
//import org.w3c.dom.NodeList;
//
//import javax.xml.soap.SOAPException;
//import javax.xml.soap.SOAPHeader;
//import javax.xml.soap.SOAPMessage;
//
//@Component
//@Slf4j
//public class WebServiceInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
//    private SAAJInInterceptor saa = new SAAJInInterceptor();
//    private static final String USER_NAME = "admin";
//    private static final String PASSWORD = "123456";
//
//    public WebServiceInterceptor() { //创建拦截
//        super(Phase.POST_PROTOCOL);
//        super.getAfter().add(SAAJInInterceptor.class.getName());  //添加拦截
//    }
//
//    @Override
//    public void handleMessage(SoapMessage message) throws Fault {
//        SOAPMessage soapMessage = message.getContent(SOAPMessage.class);//获取指定的消息
//        if (soapMessage == null) {
//            this.saa.handleMessage(message);
//            soapMessage = message.getContent(SOAPMessage.class);
//        }
//        SOAPHeader header = null;
//        try {
//            header = soapMessage.getSOAPHeader();
//        } catch (SOAPException e) {
//            e.printStackTrace();
//        }
//
//        if (header == null) {  //用户信息不存在
//            throw new Fault(new IllegalAccessException("用户不存在"));
//        }
//        NodeList usernameNodeList = header.getElementsByTagName("username");
//        NodeList passwordNodeList = header.getElementsByTagName("password");
//        if (usernameNodeList.getLength() < 1 || passwordNodeList.getLength() < 1) {
//            throw new Fault(new IllegalAccessException("用户不存在"));
//        }
//
//        String username = usernameNodeList.item(0).getTextContent().trim();
//        String password = passwordNodeList.item(0).getTextContent().trim();
//
//        if(username.equals(USER_NAME)&&password.equals(PASSWORD)){
//            log.debug("用户认证成功");
//        }else {
//            SOAPException soapException=new SOAPException("用户认证失败！");
//            log.debug("用户认证失败");
//            throw new Fault(soapException);
//        }
//    }
//}
