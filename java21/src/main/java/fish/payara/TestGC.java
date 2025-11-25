package fish.payara;

import java.util.ArrayList;
import java.util.List;

/**
 * Memtester for playing with GCs.
 *
 * <pre>
 * java TestGC.java
 * 479,641 allocs/s
 * java  -XX:+UseZGC TestGC.java
 * 531,542 allocs/s
 * java -XX:GCPauseIntervalMillis=1 -XX:+UseZGC TestGC.java
 * 568,404 allocs/s
 * java XX:+UseSerialGC
 * 437,865 allocs/s
 * -XX:+UseParallelGC
 * 394,025 allocs/s
 * java -XX:+UseParallelGC -XX:ParallelGCThreads=11 TestGC.java
 * 458,531 allocs/s
 * java -XX:+UseParallelGC -XX:MaxGCPauseMillis=1 TestGC.java
 * 84,179 allocs/s
 * -XX:+UseG1GC
 * 471,783 allocs/s
 * -XX:+UseConcMarkSweepGC
 * java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC TestGC.java
 * fail after 4,100,000
 * 457,587 allocs/s
 *
 * Huge pages
 * echo 4096 > /sys/kernel/mm/hugepages/hugepages-2048kB/nr_hugepages
 * java -XX:+UseZGC -XX:+UseLargePages TestGC.java
 * 688,362 allocs/s
 * </pre>
 *
 * Very detailed info at start: -XX:+PrintFlagsFinal
 *
 * Info during GC: -Xlog:gc+phases=info
 *
 * Do GC during idle periods: -XX:G1PeriodicGCInterval
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public class TestGC {

    private static long ROUNDS = 20_000_000;
    private static final int PRINT_CYCLES = 100_000;
    private static final int RESET_MEMORY_CYCLES = 1_000_000;
    private static final int ALLOC_SIZE = 1000;

    public static void main(String[] args) {
        long start = System.nanoTime();
        long now = start;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        List<int[]> memleak = new ArrayList<>();
        for (long i = 1; i <= ROUNDS; i++) {
            long before = now;
            now = System.nanoTime();
            long diff = now - before;
            min = Math.min(min, diff);
            max = Math.max(max, diff);

            int[] array = new int[ALLOC_SIZE];
            memleak.add(array);
            if (array[0] != 0) {
                System.out.println("Just tests");
            }

            if (i % RESET_MEMORY_CYCLES == 0) {
                // mem reset
                memleak.clear();
            }
            if (i % PRINT_CYCLES == 0) {
                long perf = i * 1_000_000_000 / (now - start);
                System.out.printf("%,10d diff: %,10d, min: %,10d, max: %,13d, perf: %,10d allocs/s%n", i, diff, min, max, perf);
                // reset
                min = Long.MAX_VALUE;
                max = Long.MIN_VALUE;
            }
        }
    }
}
