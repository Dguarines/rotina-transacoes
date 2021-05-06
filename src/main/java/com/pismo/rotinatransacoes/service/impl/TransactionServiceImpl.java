package com.pismo.rotinatransacoes.service.impl;

import java.util.List;

import com.pismo.rotinatransacoes.repository.TransactionRepository;
import com.pismo.rotinatransacoes.validator.transaction.TransactionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pismo.rotinatransacoes.data.vo.TransactionVO;
import com.pismo.rotinatransacoes.entity.Transaction;
import com.pismo.rotinatransacoes.service.TransactionService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository;
	private final List<TransactionValidator> validadores;

	@Override
	public TransactionVO cadastrar(TransactionVO transactionVO) {
		
		Transaction transaction = Transaction.converter(transactionVO);
		validar(transaction);

		return TransactionVO.converter(transactionRepository.save(transaction));
	}

	private void validar(Transaction transaction) {
		validadores.forEach(transactionValidator -> transactionValidator.validate(transaction));
	}
}
