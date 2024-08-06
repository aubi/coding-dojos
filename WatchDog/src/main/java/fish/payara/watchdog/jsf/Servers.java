package fish.payara.watchdog.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubi
 */
@Named(value = "servers")
@RequestScoped
public class Servers {
    private List<String> servers = new ArrayList<>();
    /**
     * Creates a new instance of Servers
     */
    public Servers() {
        servers.add("google.com");
        servers.add("seznam.cz");
    }

    public List<String> getList() {
        return servers;
    }

    public void setList(List<String> servers) {
        this.servers = servers;
    }

}
