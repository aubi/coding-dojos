package fish.payara.dojo.jms.hello;

import jakarta.ejb.Stateless;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

@Stateless
public class TopicCounter {

    private static final AtomicLong COUNTER = new AtomicLong();
    private static final CountDownLatch countDownTimer = new CountDownLatch(5);
    public long countMessage() {
        countDownTimer.countDown();
        return COUNTER.incrementAndGet();
    }

}
