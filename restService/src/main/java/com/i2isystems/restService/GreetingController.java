package com.i2isystems.restService;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
//In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
//These components are identified by the @RestController annotation.
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); //id sayısı setlemek için

    @GetMapping("/greeting") //Get request
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
    //@RequestParam, sorgu dizesi parametre adının değerini greeting() yönteminin name parametresine bağlar.
    // İstekte name parametresi yoksa, defaultValue of World kullanılır.
}
