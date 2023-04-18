package com.parallel.lmaxdisruptorpoc;

import com.lmax.disruptor.RingBuffer;
import com.parallel.lmaxdisruptorpoc.config.DisruptorConfig;
import com.parallel.lmaxdisruptorpoc.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EventProducer {
    @Autowired
    private RingBuffer<Event<String>> ringBuffer;

    @Autowired
    private DisruptorConfig disruptorConfig;

    private ExecutorService executor;

    @PostConstruct()
    private void initialize() {
        executor = Executors.newFixedThreadPool(disruptorConfig.getProducerSize());
    }

    private Runnable publishEvent() {
        return () -> {
            final long sequence = ringBuffer.next();
            final Event<String> event = ringBuffer.get(sequence);
            event.setPayload(String.format("Producer Thread %s, Sequence: %d Date: %s", Thread.currentThread().getId(), sequence, new Date()));
            ringBuffer.publish(sequence);
        };
    }

    @Scheduled(fixedDelay = 1)
    public void produceEvent() {
        IntStream.range(0, disruptorConfig.getProducerSize()).forEach(i -> executor.submit(publishEvent()));
    }
}
