package com.example.b5firstconfigclient.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FirstFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String method = request.getMethod();
        String secret = request.getHeader("secret");
        System.out.println("Method : "+method);
        System.out.println("Secret : " + secret);

//        System.out.println("Second Service : " + secondMicroService);
//        System.out.println("First Service : " + firstMicroService);
//
//        if (secret == null) {
//            if (!method.equals("POST")||!method.equals("GET")) {
//                throw new ServletException("Not access From First!!!");
//            }
//        }
        filterChain.doFilter(request, response);
    }
}
