package ro.fasttrackit.curs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrackit.curs20.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByDescription(String description);

    Optional<Transaction> findFirstByAmount(double amount);

    List<Transaction> findByDescriptionLikeAndAmount(String containsString, double amount);

    List<Transaction> findByAmountGreaterThan(double minAmount);

    @Query("SELECT t from Transaction t where t.description=:description")
    List<Transaction> getMyJPQL(@Param("description") String description);

    @Query(value = "SELECT * from Transaction where description='televizor'", nativeQuery = true)
    List<Transaction> getMyTransactions();

    @Query(value = "SELECT * from Transaction where description=:desc", nativeQuery = true)
    List<Transaction> getMyTransactions(@Param("desc") String desc);
}
