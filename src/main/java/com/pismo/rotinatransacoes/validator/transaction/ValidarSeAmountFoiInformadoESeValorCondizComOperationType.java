package com.pismo.rotinatransacoes.validator.transaction;

import com.pismo.rotinatransacoes.entity.Transaction;
import com.pismo.rotinatransacoes.exception.ResourceException;
import com.pismo.rotinatransacoes.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.pismo.rotinatransacoes.entity.OperationType.valorNaoCondizComOTipoDaOperacao;
import static java.util.Objects.isNull;

@Component
@AllArgsConstructor
public class ValidarSeAmountFoiInformadoESeValorCondizComOperationType implements TransactionValidator{

    private final TransactionRepository transactionRepository;

    @Override
    public void validate(Transaction transaction) {

        if (isNull(transaction.getAmount())) {
            throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "Amount: valor deve ser informado");
        }else if(valorNaoCondizComOTipoDaOperacao(transaction)){
            throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "Amount: valor informado não condiz com a operação realizada");
        }
    }
}
