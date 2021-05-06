package com.pismo.rotinatransacoes.validator.transaction;

import com.pismo.rotinatransacoes.entity.Transaction;
import com.pismo.rotinatransacoes.exception.ResourceException;
import com.pismo.rotinatransacoes.repository.OperationTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ValidarSeOperationTypeFoiInformadoEExiste implements TransactionValidator {

    private final OperationTypeRepository operationTypeRepository;

    @Override
    public void validate(Transaction transaction) {
        Long id = transaction.getOperationType().getId();

        if (transaction.getOperationType().getId() == null){
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Id do tipo da operação não foi informado");
        }else if (!operationTypeRepository.existsById(id)){
            throw new ResourceException(HttpStatus.NOT_FOUND, "Nenhum tipo de operação foi encontrado com esse id");
        }
    }
}
