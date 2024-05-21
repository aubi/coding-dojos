package fish.payara.hello;

import fish.payara.secured.AdminResource;
import fish.payara.secured.ProtectedResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.Set;

/**
 * Configures RESTful Web Services for the application.
 */
@ApplicationPath("resources")
public class RestConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(HelloWorldResource.class, AdminResource.class, ProtectedResource.class);
    }

}
