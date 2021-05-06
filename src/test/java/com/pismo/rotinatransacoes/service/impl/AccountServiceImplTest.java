package com.pismo.rotinatransacoes.service.impl;

import com.pismo.rotinatransacoes.exception.AccountNotFoundException;
import com.pismo.rotinatransacoes.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void setUp() {}

    @Test(expected = AccountNotFoundException.class)
    public void seBuscaPorIdRetornarVazio_EntaoDeveRetornarException() {
        doReturn(Optional.empty()).when(accountRepository).findById(any());

        accountService.buscarPorId(-1L);
    }
}
