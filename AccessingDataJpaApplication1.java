package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
 class AccessingDataJpaApplication{

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRespository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer","kerla","9948108458","kony67@gmail.com"));
      repository.save(new Customer("Jack", "O'Brian","banglore","9010895448","ksowmyasree1999@gmail.com"));
      repository.save(new Customer("Kim", "Bauer","kerla","123456789","hony567@gmail.com"));
      repository.save(new Customer("David", "Palmer","mp","8142722693","lalitha567@gmail.com"));
      repository.save(new Customer("Kim", "Dessler","mp","123456789","hony567@gmail.com"));

      // fetch all customers
     log.info("Customers found with findAll():");
log.info("-------------------------------");
for (Customer customer : repository.findAll())
    log.info(customer.toString());
log.info("");

// fetch an individual customer by ID
Customer customer = repository.findById(1L);
log.info("Customer found with findById(1L):");
log.info("--------------------------------");
log.info(customer.toString());
log.info("");

// fetch customers by last name
log.info("Customer found with findByLastName('Bauer'):");
log.info("--------------------------------------------");
repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
log.info("Customer found with findByFirstName('Jack'):");
log.info("--------------------------------------------");
repository.findByFirstName("Jack").forEach(Jack -> log.info(Jack.toString()));
log.info("Customer found with findByAddress('mp'):");
log.info("--------------------------------------------");
repository.findByAddress("mp").forEach(mp -> log.info(mp.toString()));
log.info("Customer found with findByPhone('123456789'):");
log.info("--------------------------------------------");
repository.findByPhone("123456789").forEach(Customer -> log.info("Customer with phone: " + Customer.getPhone()));
log.info("Customer found with findByEmail('hony567@gmail.com'):");
log.info("--------------------------------------------");
repository.findByEmail("hony567@gmail.com").forEach(Customer -> log.info(Customer.toString()));

log.info("");
    };
  }
}