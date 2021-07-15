package ro.fasttrackit.curs20.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs20.entity.Transaction;
import ro.fasttrackit.curs20.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction create(Transaction transaction) {
        //validari
        transaction.setId(null);
        return transactionRepository.save(transaction);
    }
}
