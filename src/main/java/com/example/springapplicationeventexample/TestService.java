package com.example.springapplicationeventexample;

import com.example.springapplicationeventexample.event.TestEvent;
import com.example.springapplicationeventexample.event.TestEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    private final TestEventPublisher testEventPublisher;

    public TestService(TestEventPublisher testEventPublisher) {
        this.testEventPublisher = testEventPublisher;
    }

    public void generateApplicationEvent() {
        testEventPublisher.publish(new TestEvent(this, "generateApplicationEvent"));
    }
}
