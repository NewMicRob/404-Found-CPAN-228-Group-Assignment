package com.example._Found.__Found_Group_Assignment;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2Console() {
        // This explicitly tells the Jakarta-based server (Tomcat 11)
        // to map the H2 console to your custom path.
        ServletRegistrationBean<JakartaWebServlet> bean = new ServletRegistrationBean<>(new JakartaWebServlet(), "/db-admin/*");
        bean.setLoadOnStartup(1);
        return bean;
    }
}