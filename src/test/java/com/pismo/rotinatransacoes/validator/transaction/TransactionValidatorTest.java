package com.pismo.rotinatransacoes.validator.transaction;

import com.pismo.rotinatransacoes.entity.Account;
import com.pismo.rotinatransacoes.entity.OperationType;
import com.pismo.rotinatransacoes.entity.Transaction;
import com.pismo.rotinatransacoes.exception.ResourceException;
import com.pismo.rotinatransacoes.repository.AccountRepository;
import com.pismo.rotinatransacoes.repository.OperationTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class TransactionValidatorTest {

    @InjectMocks
    private ValidarSeAccountExiste validarSeAccountExiste;

    @InjectMocks
    private ValidarSeAmountFoiInformadoESeValorCondizComOperationType validarSeAmountFoiInformadoESeValorCondizComOperationType;

    @InjectMocks
    private ValidarSeOperationTypeFoiInformadoEExiste validarSeOperationTypeFoiInformadoEExiste;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private OperationTypeRepository operationTypeRepository;

    @Before
    public void setup() {}

    @Test(expected = ResourceException.class)
    public void seContaNaoExistir_EntaoDeveRetornarException(){

        Transaction transacao = Transaction.builder().account(Account.builder().id(1l).build()).build();

        doReturn(false).when(accountRepository).existsById(any());

        validarSeAccountExiste.validate(transacao);
    }

    @Test(expected = ResourceException.class)
    public void seAmountForNull_EntaoDeveRetornarException(){

        Transaction transacaoComAmountNulo = Transaction.builder().amount(null).build();

        validarSeAmountFoiInformadoESeValorCondizComOperationType.validate(transacaoComAmountNulo);
    }

    @Test(expected = ResourceException.class)
    public void seValorForPositivoParaOperacaoNegativa_EntaoDeveRetornarException(){

        OperationType operacaoComTipoNegativo = OperationType.builder().id(OperationType.COMPRA_A_VISTA).build();
        Transaction transacaoComAmountPositivo = Transaction.builder().amount(100D).operationType(operacaoComTipoNegativo).build();

        validarSeAmountFoiInformadoESeValorCondizComOperationType.validate(transacaoComAmountPositivo);
    }

    @Test(expected = ResourceException.class)
    public void seValorForNegativoParaOperacaoPositiva_EntaoDeveRetornarException(){

        OperationType operacaoComTipoPositivo = OperationType.builder().id(OperationType.PAGAMENTO).build();
        Transaction transacaoComAmountNegativo = Transaction.builder().amount(-100D).operationType(operacaoComTipoPositivo).build();

        validarSeAmountFoiInformadoESeValorCondizComOperationType.validate(transacaoComAmountNegativo);
    }

    @Test(expected = ResourceException.class)
    public void seIdDoOperationTypeForNulo_EntaoDeveRetornarException(){

        Transaction transacaoComOperationTypeNulo = Transaction.builder().operationType(OperationType.builder().id(null).build()).build();

        validarSeOperationTypeFoiInformadoEExiste.validate(transacaoComOperationTypeNulo);
    }

    @Test(expected = ResourceException.class)
    public void seOperationTypeNaoExistir_EntaoDeveRetornarException(){

        Transaction transactionComOperationTypeNaoNulo = Transaction.builder().operationType(OperationType.builder().id(OperationType.PAGAMENTO).build()).build();

        doReturn(false).when(operationTypeRepository).existsById(any());

        validarSeOperationTypeFoiInformadoEExiste.validate(transactionComOperationTypeNaoNulo);
    }
}
