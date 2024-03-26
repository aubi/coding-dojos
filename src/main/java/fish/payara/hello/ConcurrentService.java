package fish.payara.hello;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import jakarta.inject.Named;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
@Named
public class ConcurrentService {
    @Resource
    ManagedScheduledExecutorService mes;
    ScheduledFuture<?> scheduledFuture;
    final AtomicInteger count = new AtomicInteger();
    @PostConstruct
    void init() {
        scheduledFuture = mes.scheduleAtFixedRate(() -> {
            System.out.println("##################### Running concurrently. Count --> " + count.incrementAndGet());
        }, 0, 1, TimeUnit.SECONDS);

    }

    public AtomicInteger printValue() {
        return count;
    }

    public void stop() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public void start() {
        scheduledFuture = mes.scheduleAtFixedRate(() -> {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Running concurrently after restarting. Count --> " + count.incrementAndGet());
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void reset() {
        count.set(0);
    }
}
