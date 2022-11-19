package io.sokovets.theory;

import java.time.Duration;

public class RateLimiterTokenBucket {

    private final long capacity;
    private final long nanosToGenerateToken;
    private long availableToken;
    private long lastRefillNanoTime;

    public RateLimiterTokenBucket(long permits, Duration period) { //permits - разрешать, допускать
        this.capacity = permits;
        this.availableToken = permits;
        this.nanosToGenerateToken = period.toNanos()/permits; //Сколько времени будет потрачено на генерацию одного токена
        this.lastRefillNanoTime = System.nanoTime();
    }

    public synchronized boolean tryConsume(int permits) { //потреблять
        refill();
        if (availableToken < permits) {
            return false;
        } else {
            availableToken -= permits;
            return true;
        }
    }

    private void refill() {
        long now = System.nanoTime();
        long nanosSinceLastRefill = now - lastRefillNanoTime;

        //We just try to define do we have time to add one token or not
        if (nanosSinceLastRefill <= nanosToGenerateToken) {
            return;
        }

        //How much token we can refill
        long tokensSinceLastRefill = nanosSinceLastRefill / nanosToGenerateToken;

        //We should choose the smallest value between capacity and the calculated value
        availableToken = Math.min(capacity, availableToken + tokensSinceLastRefill);

        //Refresh last refill time
        lastRefillNanoTime += tokensSinceLastRefill + nanosToGenerateToken;
    }

    public static void main(String[] args) {
        RateLimiterTokenBucket rateLimiterTokenBucket = new RateLimiterTokenBucket(10, Duration.ofMinutes(1));
        boolean b = rateLimiterTokenBucket.tryConsume(9);
        System.out.println(b);
    }
}
