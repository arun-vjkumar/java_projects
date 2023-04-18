package com.parallel.lmaxdisruptorpoc;

import com.lmax.disruptor.EventHandler;
import com.parallel.lmaxdisruptorpoc.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EventConsumer {
    public List<EventHandler<Event<String>>> getEventConsumer() {
        return IntStream.range(1, 6).mapToObj(i -> {
            return (EventHandler<Event<String>>) (event, sequence, endOfBatch) -> {
                if (sequence % 5 == i) {
                    System.out.println(String.format("Thread: %s Consumer %d: Payload: %s", Thread.currentThread().getName(), i, event.getPayload()));
                }
            };
        }).collect(Collectors.toList());
    }
}
