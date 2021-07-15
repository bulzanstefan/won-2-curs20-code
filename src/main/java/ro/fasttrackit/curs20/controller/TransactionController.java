package ro.fasttrackit.curs20.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs20.entity.Transaction;
import ro.fasttrackit.curs20.service.TransactionService;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }
}
