package ru.itis.webflux.clients;

import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Customer;

public interface CustomerClient {
    Flux<Customer> getCustomers();
}
