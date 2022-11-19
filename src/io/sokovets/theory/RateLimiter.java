package io.sokovets.theory;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

/**
 * Whenever you expose a web service / api endpoint, you need to implement a rate limiter to prevent abuse of the service (DOS attacks).
 * <p>
 * Implement a RateLimiter Class with an isAllow method.
 * Every request comes in with a unique clientID, deny a request if that client has made more than 100 requests in the past second.
 *
 * https://leetcode.com/discuss/interview-question/124558/Implement-a-Rate-Limiter
 * https://medium.com/geekculture/system-design-basics-rate-limiter-351c09a57d14
 */

public class RateLimiter {
    //clientId - uuid
    //interval - 1 second
    //limit = 1
    //Map<Client, SumRq> = Data Structure

    Limiter limiter = new Limiter(3, 10);

    public static void main(String[] args) throws InterruptedException {
        String client1 = UUID.randomUUID().toString();
        RateLimiter rateLimiter = new RateLimiter();

        for (int i = 0; i < 10000; i++) {

            Thread.sleep(100L);
            if (rateLimiter.isAllow(client1)) {
                System.out.println("i=" + i + "    yes");
            } else {
                System.out.println("i=" + i + "    no");
            }
        }
    }

    public boolean isAllow(String clientId) {
        LocalTime localTime = LocalTime.now();
        limiter.saveRequest(clientId, localTime);
        return limiter.isAllow(clientId);
    }


    class Limiter {
        final int requestLimit;
        final int timeLimit;

        final Map<String, Deque<LocalTime>> data = new HashMap<>();


        public Limiter(int requestLimit, int timeLimitInSecond) {
            this.requestLimit = requestLimit;
            this.timeLimit = timeLimitInSecond;
        }

        void saveRequest(String clientId, LocalTime localTime) {
            //Change to merge func
            if (data.containsKey(clientId)) {
                if (isAllow(clientId)) {
                    data.get(clientId).addLast(localTime);
                }
            } else {
                Deque<LocalTime> requestTime = new ArrayDeque<>();
                requestTime.addLast(localTime);
                data.put(clientId, requestTime);
            }
        }

        //17:31:16.957825
        //17:31:16.957825
        //17:31:16.957825
        //17:31:16.957825
        //17:31:16.957825

        boolean isAllow(String clientId) {
            Deque<LocalTime> request = data.get(clientId);

            while (!request.isEmpty()
                    && Duration.between(request.peek(), LocalTime.now()).getNano() >= 500_000_000) { //Например: За последние 0,5 секунды нужно подсчитать ко-во запросов
                request.poll();
            }
            if (request.size() < requestLimit) {
                return true;
            }
            return false;
        }

    }
}


class RateLimiterSolution {

    public int REQUEST_LIMIT = 100;
    public Long TIME_LIMIT = 1000L;

    public class HitCounter {
        public Queue<Long> queue;

        public HitCounter() {
            queue = new LinkedList<>();
        }

        public boolean hit(long timestamp) {
            /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT*/
            while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) {
                queue.poll();
            }
            if (queue.size() < 500) {
                queue.add(timestamp);
                return true;
            }
            return false;
        }
    }

    public HashMap<String, HitCounter> clientTimeStampMap = new HashMap<>();

    public boolean isAllow(String clientId) {
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            HitCounter h = new HitCounter();
            h.hit(currTime);
            return true;
        } else {
            HitCounter h = clientTimeStampMap.get(clientId);
            return h.hit(currTime);
        }
    }

}
