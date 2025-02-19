/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joinfaces.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

@ApplicationScoped
public class PushContextProducer {

    @Produces
    @Push(channel = "statusChannel")
    public PushContext producePushContext(@Push(channel = "statusChannel") PushContext pushContext) {
        return pushContext;
    }
}
