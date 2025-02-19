package org.joinfaces.example;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Named
@ApplicationScoped
public class LongRunningProcessService implements Serializable{
    
    private ExecutorService executorService;
    

    @PostConstruct
    public void init() {
        executorService = Executors.newSingleThreadExecutor();
    }
    
    public void startLongRunningProcess(Runnable consumer) {
        executorService.submit(consumer);
    }
    
    public void shutdown() {
        executorService.shutdown();
    }
}
