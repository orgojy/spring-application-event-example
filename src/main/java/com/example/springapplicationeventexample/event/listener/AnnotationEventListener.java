package com.example.springapplicationeventexample.event.listener;

import com.example.springapplicationeventexample.event.TestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class AnnotationEventListener {
    @Async
    @EventListener
    public void handleTestEvent(TestEvent event) {
        System.out.println(event.getMessage());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleTestEventWithoutFailedTransaction(TestEvent event) {
        System.out.println(event.getMessage());
    }
}
