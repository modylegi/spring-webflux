package ru.itis.webflux.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Customer;
import ru.itis.webflux.services.CustomerService;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class UserController {
    private final CustomerService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomers() {
        return service.getCustomers();
    }

}
