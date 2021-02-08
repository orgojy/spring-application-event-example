package com.example.springapplicationeventexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {
    private final TestService testService;

    public TestResource(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/generates/application-event")
    public void publishEvent() {
        testService.generateApplicationEvent();
    }
}
