package com.pismo.rotinatransacoes.service.impl;

import com.pismo.rotinatransacoes.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pismo.rotinatransacoes.data.vo.AccountVO;
import com.pismo.rotinatransacoes.entity.Account;
import com.pismo.rotinatransacoes.repository.AccountRepository;
import com.pismo.rotinatransacoes.service.AccountService;
import com.pismo.rotinatransacoes.validator.account.ValidarSeNumeroDocumentoFoiInformadoEJaNaoExiste;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository;
	private final ValidarSeNumeroDocumentoFoiInformadoEJaNaoExiste validateAccount;

	@Override
	public AccountVO cadastrar(AccountVO accountVO) {

		Account account = Account.converter(accountVO);
		validateAccount.validate(account);
		return AccountVO.converter(accountRepository.save(account));
	}

	@Override
	public AccountVO buscarPorId(Long id) {
		return AccountVO.converter(accountRepository.findById(id)
													.orElseThrow(() -> new AccountNotFoundException(id)));
	}

	private AccountVO convertToAccountVO(Account account){
	   return AccountVO.converter(account);
	}
	
	private Account convertToAccount(AccountVO accountVO){
        return Account.converter(accountVO);
    }
}
