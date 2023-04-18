package com.parallel.lmaxdisruptorpoc;

import com.lmax.disruptor.EventHandler;
import com.parallel.lmaxdisruptorpoc.config.DisruptorConfig;
import com.parallel.lmaxdisruptorpoc.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EventConsumer {
    @Autowired
    private DisruptorConfig disruptorConfig;

    public List<EventHandler<Event<String>>> getEventConsumer() {
        return IntStream.range(0, disruptorConfig.getConsumerSize()).mapToObj(i -> {
            return (EventHandler<Event<String>>) (event, sequence, endOfBatch) -> {
                if (sequence % disruptorConfig.getConsumerSize() == i) {
                    System.out.println(String.format("Consumer Thread: %s, Id: %d: Payload: %s", Thread.currentThread().getName(), i, event.getPayload()));
                }
            };
        }).collect(Collectors.toList());
    }
}
