# spring-application-event-example

: In SpringBoot, example for ApplicationEvent

## Index

1. Create event class to handle as unit in ApplicationContext
2. Create event publisher to publish an event to ApplicationContext
3. Create event listener to handle an event
4. Create environment to test ApplicationEvent

---

## 1. Create event class to handle as unit in ApplicationContext

``` java
import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
    private final String message;

    public TestEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```

## 2. Create event publisher to publish an event to ApplicationContext

``` java
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class TestEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void publish(TestEvent testEvent) {
        this.eventPublisher.publishEvent(testEvent);
    }
}
```

## 3. Create event listener to handle an event

* It is required @Component, because event listener has to load it into Spring Container

``` java
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
```

## 4. Create environment to test ApplicationEvent

``` java
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
```
