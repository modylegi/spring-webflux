package ru.itis.webflux.services;

import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Customer;

public interface CustomerService {
    Flux<Customer> getCustomers();
}
