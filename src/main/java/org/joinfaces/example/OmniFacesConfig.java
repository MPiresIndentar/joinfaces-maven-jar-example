/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joinfaces.example;

/**
 *
 * @author pcmix
 */
import jakarta.servlet.ServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OmniFacesConfig {
    
    //@Bean
    public ServletListenerRegistrationBean<ServletContextListener> omniFacesListener() {
        ServletListenerRegistrationBean<ServletContextListener> bean =
            new ServletListenerRegistrationBean<>(new org.omnifaces.ApplicationListener());
        
        System.out.println("######### OMNI FACES CONFIG INICIALIZADO ########");
        
        return bean;
    }
}
