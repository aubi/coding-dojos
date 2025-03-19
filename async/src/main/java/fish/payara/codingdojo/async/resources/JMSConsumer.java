package fish.payara.codingdojo.async.resources;

import fish.payara.codingdojo.async.resources.model.Data;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSDestinationDefinition;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@JMSDestinationDefinition(
        name = "java:global/queue/msgQueue",
        interfaceName = "jakarta.jms.Queue",
        destinationName = "msgQueue"
)
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "java:global/queue/msgQueue"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "jakarta.jms.Queue"),
    @ActivationConfigProperty(propertyName = "maxSessions", // this doesn't work, how to set it up?
            propertyValue = "100")
})

public class JMSConsumer implements MessageListener {

    @EJB
    private DataService dataService;

    @Override
    public void onMessage(Message message) {
        try {
//                long start = System.currentTimeMillis();
            dataService.processData(message.getBody(Data.class));
//                long end = System.currentTimeMillis();
//                Logger.getAnonymousLogger().info("Counting to 10000000 takes " +
//                        (end - start) + "ms");
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
