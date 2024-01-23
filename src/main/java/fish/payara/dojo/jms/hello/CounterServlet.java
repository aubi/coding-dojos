package fish.payara.dojo.jms.hello;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.jms.JMSConnectionFactoryDefinition;
import jakarta.jms.JMSDestinationDefinition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/counter")
@JMSConnectionFactoryDefinition(name = "jms/TestFactory")
@JMSDestinationDefinition(name = "jms/TestQueue", destinationName = "TestQueue", interfaceName = "jakarta.jms.Queue")
public class CounterServlet extends HttpServlet {

    @EJB
    TopicCounter topicCounter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(topicCounter.checkCounter());
    }
}
