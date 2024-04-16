package fish.payara.hello;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.net.URL;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@RunAsClient
public class HelloWorldResourceTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(HelloWorldResource.class.getPackage())
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"));
    }

    @ArquillianResource
    private URL deploymentUrl;

    @Test
    public void testGetAllUsers() {
        String baseUrl = deploymentUrl.toString();
        GenericType<List<User>> genericType = new GenericType<List<User>>() {
        };

        Client client = ClientBuilder.newClient();
        List<User> response = client.target(baseUrl + "rest/v1/entities")
                .request()
                .get(genericType);

        assertEquals(5, response.size());
        client.close();
    }

    @Test
    public void testGetUser() {
        String baseUrl = deploymentUrl.toString();

        Client client = ClientBuilder.newClient();
        User user = client.target(baseUrl + "rest/v1/entities/Gaurav")
                .request()
                .get(User.class);

        assertEquals("Gaurav", user.getUsername());

        client.close();
    }
}
