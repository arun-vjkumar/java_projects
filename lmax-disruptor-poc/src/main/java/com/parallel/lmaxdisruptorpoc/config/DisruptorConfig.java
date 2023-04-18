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
    private int maxConcurrency;

    public RingBuffer<Event<String>> createDisruptor(EventHandler<Event<String>>... handler) {
        ThreadFactory threadFactory = DaemonThreadFactory.INSTANCE;
        WaitStrategy waitStrategy = new BlockingWaitStrategy();

        Disruptor<Event<String>> disruptor = new Disruptor<>(
                Event::new,
                maxConcurrency,
                threadFactory,
                ProducerType.SINGLE,
                waitStrategy
        );

        disruptor
                .handleEventsWith(handler);

        return disruptor.start();
    }

    public int getMaxConcurrency() {
        return maxConcurrency;
    }

    public void setMaxConcurrency(int maxConcurrency) {
        this.maxConcurrency = maxConcurrency;
    }
}
