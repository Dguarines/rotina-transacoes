package com.pismo.rotinatransacoes.validator.transaction;

import com.pismo.rotinatransacoes.entity.Transaction;
import com.pismo.rotinatransacoes.exception.ResourceException;
import com.pismo.rotinatransacoes.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidarSeAccountExiste implements TransactionValidator {

    private final AccountRepository accountRepository;

    @Override
    public void validate(Transaction transaction) {

        Long id = transaction.getAccount().getId();
        if (!accountRepository.existsById(id)){
            throw new ResourceException(HttpStatus.NOT_FOUND, "Nenhuma conta foi encontrada com o id informado");
        }
    }
}
