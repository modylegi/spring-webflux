package ru.itis.webflux.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.webflux.entities.Customer;

import java.util.Arrays;

@Component
public class CustomerClientImpl implements CustomerClient {
    private final WebClient client;

    @Override
    public Flux<Customer> getCustomers(){
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Customer[].class))
                .flatMapIterable(Arrays::asList);
    }

    public CustomerClientImpl(@Value("${customer.api.url}") String url) {
        client = WebClient.builder()
                .baseUrl(url)
                .build();
    }

}
