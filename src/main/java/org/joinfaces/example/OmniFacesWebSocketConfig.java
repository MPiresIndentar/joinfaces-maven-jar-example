package org.joinfaces.example;

import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration.Dynamic;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import com.sun.faces.config.ConfigureListener;

@Configuration
public class OmniFacesWebSocketConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 🔹 Configuração de Parâmetros de Contexto
        servletContext.setInitParameter("org.omnifaces.SOCKET_ENDPOINT_ENABLED", "true");
        servletContext.setInitParameter("org.omnifaces.SERVLET_PUSH_ENABLED", "true");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        servletContext.setInitParameter("primefaces.THEME", "saga");
        servletContext.setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL", "true");
        servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");


        // 🔹 Registro do Listener do JSF
        servletContext.addListener(ConfigureListener.class);

        System.out.println("************ OMNIFACES E JSF INICIADOS COM SUCESSO *********");
    }
}
