package com.pismo.rotinatransacoes.repository;

import com.pismo.rotinatransacoes.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
