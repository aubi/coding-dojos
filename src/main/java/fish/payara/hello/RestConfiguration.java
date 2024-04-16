package fish.payara.hello;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures RESTful Web Services for the application.
 */
@ApplicationPath("rest/v1")
public class RestConfiguration extends Application {

}
