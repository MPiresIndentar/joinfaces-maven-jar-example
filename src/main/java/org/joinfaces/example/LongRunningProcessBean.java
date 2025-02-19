package org.joinfaces.example;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.PushContext;

@Named
@SessionScoped
public class LongRunningProcessBean implements Serializable {

    @Inject
    private LongRunningProcessService longRunningProcessService;

    /*bean cdi customizado*/
    @Inject
     private PushContext pushContext;

    @Setter
    @Getter
    private int segundos = 0;
    
    @Setter
    @Getter
    private String mensagem = "iniciar";
    
    public void contaSegundos(){
     
        longRunningProcessService.startLongRunningProcess(()->{
                    try{
                        System.out.println("contagem iniciou");
                        mensagem = "contagem foi iniciada";
                        pushContext.send("{\"mensagem\": \"" + mensagem + "\", \"segundos\": " + segundos + "}"); 
                        //pushContext.send(mensagem);
                        
                        for(int i = 0; i < 10; i++){
                            segundos ++;
                            System.out.println("segundos: " + segundos);
                            //pushContext.send(segundos);
                             pushContext.send("{\"mensagem\": \"" + mensagem + "\", \"segundos\": " + segundos + "}"); 
                            Thread.sleep(1000L);
                        }
                       
                    }catch(InterruptedException e){
                        System.out.println("Interrompido: " + e);
                        Thread.currentThread().interrupt();
                    }

             mensagem = "contagem finalizada";
             System.out.println("contagem finalizada");
             pushContext.send("{\"mensagem\": \"" + mensagem + "\", \"segundos\": " + segundos + "}"); 
        
        });
    }
}
