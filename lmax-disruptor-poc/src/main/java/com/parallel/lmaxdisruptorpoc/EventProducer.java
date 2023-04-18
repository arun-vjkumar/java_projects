package com.parallel.lmaxdisruptorpoc;

import com.lmax.disruptor.RingBuffer;
import com.parallel.lmaxdisruptorpoc.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventProducer {
    @Autowired
    private RingBuffer<Event<String>> ringBuffer;

    @Scheduled(fixedDelay = 1000)
    public void produceEvent() {
        final long sequence = ringBuffer.next();
        final Event<String> event = ringBuffer.get(sequence);
        event.setPayload("Hello World, Date: " + new Date());
        ringBuffer.publish(sequence);
    }
}
