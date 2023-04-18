package com.parallel.lmaxdisruptorpoc.config;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.parallel.lmaxdisruptorpoc.model.Event;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadFactory;

@ConfigurationProperties(prefix = "config.disruptor.*")
@Configuration
public class DisruptorConfig {
    private int ringBufferSize;
    private int consumerSize;
    private int producerSize;

    public RingBuffer<Event<String>> createDisruptor(EventHandler<Event<String>>... handler) {
        ThreadFactory threadFactory = DaemonThreadFactory.INSTANCE;
        WaitStrategy waitStrategy = new BlockingWaitStrategy();

        Disruptor<Event<String>> disruptor = new Disruptor<>(
                Event::new,
                ringBufferSize,
                threadFactory,
                ProducerType.MULTI,
                waitStrategy
        );

        disruptor
                .handleEventsWith(handler);

        return disruptor.start();
    }

    public int getRingBufferSize() {
        return ringBufferSize;
    }

    public void setRingBufferSize(int ringBufferSize) {
        this.ringBufferSize = ringBufferSize;
    }

    public int getConsumerSize() {
        return consumerSize;
    }

    public void setConsumerSize(int consumerSize) {
        this.consumerSize = consumerSize;
    }

    public int getProducerSize() {
        return producerSize;
    }

    public void setProducerSize(int producerSize) {
        this.producerSize = producerSize;
    }
}
