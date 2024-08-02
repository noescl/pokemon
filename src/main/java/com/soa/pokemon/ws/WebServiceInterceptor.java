package com.soa.pokemon.ws;

import com.soa.pokemon.db.entity.Request;
import com.soa.pokemon.db.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class WebServiceInterceptor implements EndpointInterceptor {
    private final HttpServletRequest httpServletRequest;
    private final RequestService requestService;
    protected static Logger LOG = LoggerFactory.getLogger(WebServiceInterceptor.class);

    public WebServiceInterceptor(HttpServletRequest httpServletRequest, RequestService requestService) {
        this.httpServletRequest = httpServletRequest;
        this.requestService = requestService;
    }

    private String getClientIp() {
        String remoteAddr = "";
        if (httpServletRequest != null) {
            remoteAddr = httpServletRequest.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = httpServletRequest.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        LOG.info("ISIDE handleRequest. . .");
        Date date = new Date();
        Request request = new Request();
        request.setMethod(messageContext.getRequest().toString().split("}")[1]);
        request.setIpOrigin(getClientIp());
        request.setTime(new Timestamp(date.getTime()));
        requestService.insertRequest(request);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {

    }
}
