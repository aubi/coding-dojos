package fish.payara.codingdojo.async.resources;

import fish.payara.codingdojo.async.resources.model.Data;
import jakarta.enterprise.concurrent.Asynchronous;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * Attempt with the Asynchronous annotation.
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class DataServiceAsynch {

    private static Logger log = Logger.getLogger(DataServiceAsynch.class.getName());

    @Asynchronous
    public CompletableFuture<Long> asynProcessData(Data data) {
        processData(data);
        return Asynchronous.Result.complete(data.sourceId());
    }
    
    public void processData(Data data) {
//        try {
            log.info(() -> ">>> Starting processing " + data.label() + ", #" + data.sourceId());
        //Thread.sleep(Duration.ofSeconds(10));
            log.info(() -> "<<< Finishing processing " + data.label() + ", #" + data.sourceId());
//        } catch (InterruptedException ex) {
//            log.log(Level.SEVERE, "Something's wrong with sleep: " + ex.getMessage(), ex);
//        }
    }
}
