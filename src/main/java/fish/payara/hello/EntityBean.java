package fish.payara.hello;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class EntityBean {

    private List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<>();
        users.add(new User("Gaurav", "Secret"));
        users.add(new User("Petr", "Secret"));
        users.add(new User("Kalin", "Secret"));
        users.add(new User("Luis", "Secret"));
        users.add(new User("Abdul", "Secret"));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getByName(String name) {
        return users.stream().filter(user -> user.getUsername().equals(name)).findFirst();
    }
}
