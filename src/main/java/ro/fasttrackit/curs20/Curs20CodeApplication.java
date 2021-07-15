package ro.fasttrackit.curs20;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs20.entity.Transaction;
import ro.fasttrackit.curs20.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Curs20CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs20CodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repository) {
        return args -> {
            repository.save(new Transaction("televizor", 1000));
            repository.save(new Transaction("canapea", 321));
            repository.save(new Transaction("masa", 1312));
            repository.save(new Transaction("tablou", 132));
            repository.save(new Transaction("lampa", 32));
            repository.saveAll(List.of(
                    new Transaction("monitor", 532),
                    new Transaction("mouse", 332),
                    new Transaction("tastatura", 132),
                    new Transaction("laptop", 3200)
            ));

            Optional<Transaction> transaction3 = repository.findById(3);
            System.out.println("transaction 3 is " + transaction3.orElse(null));

            List<Transaction> monitors = repository.findByDescription("monitor");
            System.out.println(monitors);

            System.out.println("------- first by amount");
            System.out.println(repository.findFirstByAmount(321));
            System.out.println("------- by description like and amount");
            System.out.println(repository.findByDescriptionLikeAndAmount("%a%", 132));
            System.out.println("------- find by amount greater");
            System.out.println(repository.findByAmountGreaterThan(1000));
            System.out.println("------- my transactions ");
            System.out.println(repository.getMyTransactions());
            System.out.println(repository.getMyTransactions("tablou"));
            System.out.println(repository.getMyJPQL("mouse"));
            repository.findAll()
                    .forEach(System.out::println);
        };
    }

}
