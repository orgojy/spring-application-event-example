package com.example.springapplicationeventexample;

import com.example.springapplicationeventexample.event.TestEvent;
import com.example.springapplicationeventexample.event.TestEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {
    private final TestEventPublisher testEventPublisher;

    public TestResource(TestEventPublisher testEventPublisher) {
        this.testEventPublisher = testEventPublisher;
    }

    @GetMapping
    public void publishEvent() {
        TestEvent testEvent = new TestEvent(this, "Hello world!");
        testEventPublisher.publish(testEvent);
    }
}
