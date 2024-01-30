package fish.payara.hello;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "TestQueue", mappedName = "jms/TestQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class TestQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("Received message: " + message);
    }
}
