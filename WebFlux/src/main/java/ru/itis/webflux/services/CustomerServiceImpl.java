package ru.itis.webflux.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.webflux.clients.CustomerClient;
import ru.itis.webflux.entities.Customer;

import java.util.List;

@Component
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final List<CustomerClient> clients;

    @Override
    public Flux<Customer> getCustomers() {
        List<Flux<Customer>> fluxes = clients.stream().map(this::getCustomers).toList();
        return Flux.merge((fluxes));
    }

    private Flux<Customer> getCustomers(CustomerClient client) {
        return client.getCustomers()
                .subscribeOn(Schedulers.boundedElastic());
    }
}
