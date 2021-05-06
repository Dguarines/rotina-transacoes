package com.pismo.rotinatransacoes.controller;

import com.pismo.rotinatransacoes.data.vo.AccountVO;
import com.pismo.rotinatransacoes.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/accounts")
public class AccountRestController {
	
	private final AccountService accountService;

    @ApiOperation(value = "Realiza cadastro de Conta.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Realiza cadastro de Transação.", response = AccountVO.class),
            @ApiResponse(code = 406, message = "Não é possível criar uma nova conta com limite negativo.", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Ocorreu um erro não esperado.", response = ErrorMessage.class),
    })
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			 	 consumes = {"application/json", "application/xml", "application/x-yaml"})
    public AccountVO cadastrar(@RequestBody AccountVO accountVO) { //(required = true)
        
    	AccountVO savedAccountVO = accountService.cadastrar(accountVO);
    	return savedAccountVO;
    }

    @ApiOperation(value = "Busca uma conta por ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a conta com base no id informado.", response = AccountVO.class),
            @ApiResponse(code = 404, message = "A operação não pôde ser concluída .", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Ocorreu um erro não esperado.", response = ErrorMessage.class),
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public AccountVO buscarPorId(@PathVariable(name = "id", required = true) Long id) {
        return accountService.buscarPorId(id);
    }
}
