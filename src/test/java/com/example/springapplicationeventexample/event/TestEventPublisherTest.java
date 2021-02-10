package com.example.springapplicationeventexample.event;

import com.example.springapplicationeventexample.event.listener.AnnotationEventListener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TestEventPublisher.class})
class TestEventPublisherTest {
    @Autowired
    private TestEventPublisher publisher;
    @MockBean
    private AnnotationEventListener listener;

    @Test
    void publish() {
        // given
        TestEvent event = new TestEvent(this, "message");

        // when
        publisher.publish(event);

        // then
        verify(listener, times(1))
                .handleTestEvent(event);
    }
}
