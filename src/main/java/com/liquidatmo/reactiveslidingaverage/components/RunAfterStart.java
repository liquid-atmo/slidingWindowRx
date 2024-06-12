package com.liquidatmo.reactiveslidingaverage.components;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Component
public class RunAfterStart {

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        slidingAverage(5, 1, 10);
    }

    private void slidingAverage(int bucketSize, int rangeStart, int rangeEnd) {
        Flux.range(rangeStart, rangeEnd)
                .index()
                .scan(
                        new int[bucketSize],
                        (acc, elem) -> {
                            acc[(int) (elem.getT1() % bucketSize)] = elem.getT2();
                            return acc;
                        }
                )
                .skip(bucketSize)
                .map(array -> Arrays.stream(array).sum() * 1.0 / bucketSize)
                .subscribe(av -> System.out.println("Running average " + av));
    }
}