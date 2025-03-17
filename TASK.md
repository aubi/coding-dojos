JMS (Jakarta Messaging System) this time!
 
 
The task: simulate lots of complex tasks (imagine more complex work involving a lot of search in database). For our purpose just increment a number in a @Singleton service (consider also @Lock). The requirement is to response quickly, e.g. it cannot be done synchronously. Also, it cannot be done simultaneously as it will require too much memory.

Solution: JMS! Simply create a queue and process the requests sequentially.

Steps:

Make a service (e.g. @Singleton or @Stateless) with a global counter.

Source of requests: make a simple REST call, which will call the service. The first version can call the service directly.

Make it asynchronous – introduce JMS (see hints)
 
How to see the results? Do a simple JSF page!

Convenience: make index.xhtml with 
 
* convenient link to the REST call
* number of processed requests
* button to refresh the number
 
Hints:
 
* Our tutorial: JMS
 
* Definition of Factory and Destination: Admin UI, Resources, JMS Resources, Connection Factories + Destination Resources
 
** call them java:app/jms/TestFactory and java:app/jms/TestQueue
 
* Correct string setup takes some time, so making it simpler:
 
** Queue
 
@MessageDriven(name = "TestQueue", mappedName = "java:app/jms/TestQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
 
public class TestQueue implements MessageListener {
 
    public void onMessage(Message message) {
 
** Client
 
    @Resource(lookup = "java:app/jms/TestFactory")
    private ConnectionFactory factory;
    @Resource(lookup = "java:app/jms/TestQueue")
    private Queue queue;
    public void sendMessage(String msg) {
        try (JMSContext context = factory.createContext()) {
            context.createProducer().send(queue, msg);
        }
 
* OPTIONAL: When we will be done, we can learn, how to define the Queue from app:
 
@JMSConnectionFactoryDefinition(name = "java:app/jms/TestFactory")
 
@JMSDestinationDefinition(name = "java:app/jms/TestQueue", destinationName = "TestQueue", interfaceName = "jakarta.jms.Queue")
 
* OPTIONAL: we can try play with pool size
 
* OPTIONAL: what if the app doesn't contain the queue?
