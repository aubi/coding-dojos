package fish.payara.dojo.jms.hello;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Stateless
public class TestMessageService {


    @Resource(lookup = "jms/TestFactory")
    private ConnectionFactory factory;
    @Resource(lookup = "jms/TestQueue")
    private Queue queue;

    public void sendMessage(String msg) {
        try (JMSContext context = factory.createContext()) {
            context.createProducer().send(queue, msg);
        }
    }

}
