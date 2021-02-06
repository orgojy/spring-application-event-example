package com.example.springapplicationeventexample.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TestEventListener {
    @Async
    @EventListener
    public void handleTestEvent(TestEvent event) {
        System.out.println(event.getMessage());
    }
}
