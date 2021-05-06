package com.pismo.rotinatransacoes.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AccountNotFoundException extends ResourceException {

    private Long idAccount;

    public AccountNotFoundException(Long idResource) {
        super(HttpStatus.NOT_FOUND , "Nenhuma conta foi encontrada com o id inforamdo");
        this.idAccount = idResource;
    }
}
