package com.pismo.rotinatransacoes.validator.account;

import com.pismo.rotinatransacoes.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.pismo.rotinatransacoes.entity.Account;
import com.pismo.rotinatransacoes.exception.ResourceException;

@Component
@AllArgsConstructor
public class ValidarSeNumeroDocumentoFoiInformadoEJaNaoExiste implements AccountValidator {

	private final AccountRepository accountRepository;

	@Override
	public void validate(Account account) {
		
		String numeroDocumento = account.getDocumentNumber();
		
		if (isEmpty(numeroDocumento)) {
			throw new ResourceException(HttpStatus.BAD_REQUEST, "Número documento não foi informado");

		}else if (accountRepository.jaCadastradoPorNumeroDocumento(numeroDocumento)){
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "Já existe uma conta com o número documento informado");
		}
	}

	private boolean isEmpty(String numeroDocumento){
		return numeroDocumento == "" || numeroDocumento == null;
	}
}
