package com.pismo.rotinatransacoes.validator.account;

import com.pismo.rotinatransacoes.entity.Account;
import com.pismo.rotinatransacoes.exception.ResourceException;
import com.pismo.rotinatransacoes.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AccountValidatorTest {

    @InjectMocks
    private ValidarSeNumeroDocumentoFoiInformadoEJaNaoExiste validarSeNumeroDocumentoFoiInformadoEJaNaoExiste;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void setup() {
    }

    @Test(expected = ResourceException.class)
    public void seDocumentNumberForNull_EntaoRetorneException(){

        Account accountNulo = Account.builder().documentNumber(null).build();

        validarSeNumeroDocumentoFoiInformadoEJaNaoExiste.validate(accountNulo);
    }

    @Test(expected = ResourceException.class)
    public void seJaPossuiAccountComDocumentNumber_EntaoRetorneException(){

        Account accountNaoNulo = Account.builder().documentNumber("1").build();

        doReturn(true).when(accountRepository).jaCadastradoPorNumeroDocumento(any());

        validarSeNumeroDocumentoFoiInformadoEJaNaoExiste.validate(accountNaoNulo);
    }
}
