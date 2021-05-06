package com.pismo.rotinatransacoes.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pismo.rotinatransacoes.data.vo.TransactionVO;
import com.pismo.rotinatransacoes.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/transactions")
public class TransactionController {
	
	private final TransactionService transactionService;

    @ApiOperation(value = "Realiza cadastro de Transação.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna com a Transação cadastrada.", response = TransactionVO.class),
            @ApiResponse(code = 500, message = "Ocorreu um erro não esperado.", response = ErrorMessage.class),
    })
    @PostMapping(produces = "application/json")
    public ResponseEntity<TransactionVO> cadastrar(@RequestBody(required = true) TransactionVO transactionVO) {

        return ResponseEntity.ok(transactionService.cadastrar(transactionVO));
    }
}
