/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joinfaces.example;


import jakarta.enterprise.inject.spi.CDI;
import jakarta.enterprise.util.AnnotationLiteral;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PushContextProvider {

    private static final class PushLiteral extends AnnotationLiteral<Push> implements Push {
        private static final long serialVersionUID = 1L;
        private final String channel;

        public PushLiteral(String channel) {
            this.channel = channel;
        }

        @Override
        public String channel() {
            return channel;
        }
    }

    @Bean
    public PushContext pushContext() {
        return CDI.current().select(PushContext.class, new PushLiteral("statusChannel")).get();
    }
}
