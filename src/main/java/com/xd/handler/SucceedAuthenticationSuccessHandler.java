package com.xd.handler;
/*
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SucceedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public SucceedAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User principal = (User)authentication.getPrincipal();
        System.out.println("principal = " + principal.toString());//可获得user对象
        response.sendRedirect(url);
    }
}*/
class SucceedAuthenticationSuccessHandler{}
