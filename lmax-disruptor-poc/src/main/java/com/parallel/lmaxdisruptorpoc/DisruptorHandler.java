package com.parallel.lmaxdisruptorpoc;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.parallel.lmaxdisruptorpoc.config.DisruptorConfig;
import com.parallel.lmaxdisruptorpoc.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DisruptorHandler {
    private static RingBuffer<Event<String>> ringBuffer;

    @Autowired
    private DisruptorConfig disruptorConfig;

    @Autowired
    private EventConsumer eventConsumer;

    @PostConstruct()
    private void initialize() {
        if (Objects.isNull(ringBuffer)) {
            ringBuffer = disruptorConfig.createDisruptor(
                    eventConsumer.getEventConsumer().toArray(new EventHandler[0])
            );
        }
    }

    @Bean
    private RingBuffer<Event<String>> getRingBuffer() {
        return ringBuffer;
    }
}
