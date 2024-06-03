package ru.itis.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.users.entities.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping()
    public List<Customer> getAllCustomers() throws InterruptedException {

        Thread.sleep(5000);

        return List.of(
                Customer.builder()
                        .username("rtwargwergwerg")
                        .password("rgergergwerg")
                        .email("qertgwrtjhdfhh")
                        .build(),
                Customer.builder()
                        .username("ewrgegsergwegr")
                        .password("fgsdgzxcvastgr ")
                        .email("sdgzsvxvasgd")
                        .build(),
                Customer.builder()
                        .username("awqsxzzxcadsfasf")
                        .password("sdgsfgsdfgsdgf")
                        .email("ffgzxbvzdfgbsdhtgsrtgh")
                        .build()
        );

    }
}
