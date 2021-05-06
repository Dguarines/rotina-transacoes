package com.pismo.rotinatransacoes.validator.transaction;

import com.pismo.rotinatransacoes.entity.Transaction;

public interface TransactionValidator {

    void validate(Transaction transaction);
}
