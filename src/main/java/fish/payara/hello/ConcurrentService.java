package fish.payara.hello;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
public class ConcurrentService {
    @Resource
    ManagedScheduledExecutorService mes;
    final AtomicInteger count = new AtomicInteger();
    @PostConstruct
    void init() {
        mes.schedule(() -> {
            System.out.println("##################### Running currently. Count --> " + count.incrementAndGet());
        }, 1, TimeUnit.SECONDS);
    }
}
