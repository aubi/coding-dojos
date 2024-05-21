package fish.payara.hello;

import fish.payara.hello.model.SampleData;
import fish.payara.secured.AdminResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.net.URL;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
//@RunAsClient
public class HelloWorldResourceTest {


    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(HelloWorldResource.class)
                .addPackage(AdminResource.class.getPackage())
                .addPackage(SampleData.class.getPackage())
                .addClass(RestConfiguration.class)
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"));
    }
    
    @ArquillianResource
    private URL deploymentUrl;
    
    @Test
    public void testHelloEndpoint() {
        String baseUrl = deploymentUrl.toString();
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(baseUrl + "resources/hello")
                .queryParam("name", "John")
                .request(MediaType.TEXT_PLAIN)
                .get();


        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String responseBody = response.readEntity(String.class);
        assertEquals("John", responseBody);

        client.close();
    }
    
    @Test
    public void testDataEndpoint() {
        String baseUrl = deploymentUrl.toString();

        Client client = ClientBuilder.newClient();
        Response response = client.target(baseUrl + "resources/hello/data")
                .request(MediaType.APPLICATION_JSON)
                .get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        SampleData responseBody = response.readEntity(SampleData.class);
        assertEquals(1, responseBody.getiVal());

        client.close();
    }

    @Test
    public void testAdminEndpoint() {
        String baseUrl = deploymentUrl.toString();

        Client client = ClientBuilder.newClient();
        Response response = client.target(baseUrl).path("resources/admin")
                .request(MediaType.TEXT_PLAIN)
                .header("Authorization", "Basic "+ java.util.Base64.getEncoder().encodeToString("myadmin:secret".getBytes()))
                .get();


        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String responseBody = response.readEntity(String.class);
        assertEquals("""
            Protected information for user:myadmin | web user has role "user": true | web user has role "admin": true""", responseBody);

        client.close();
    }
    
    @Test
    public void testProtectedEndpoint() {
    }
}
