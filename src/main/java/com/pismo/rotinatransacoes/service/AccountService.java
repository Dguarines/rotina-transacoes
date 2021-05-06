package com.pismo.rotinatransacoes.service;

import com.pismo.rotinatransacoes.data.vo.AccountVO;

public interface AccountService {

	public AccountVO cadastrar(AccountVO accountVO);
	public AccountVO buscarPorId(Long id);
}
