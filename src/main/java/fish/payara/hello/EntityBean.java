package fish.payara.hello;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class EntityBean {

    private List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }
}
