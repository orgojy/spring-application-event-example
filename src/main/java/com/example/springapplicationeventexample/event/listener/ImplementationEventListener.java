package com.example.springapplicationeventexample.event.listener;

import com.example.springapplicationeventexample.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ImplementationEventListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println(this.getClass().getName() + " : " + event.getMessage());
    }
}
