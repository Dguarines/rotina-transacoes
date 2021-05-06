package com.pismo.rotinatransacoes.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.rotinatransacoes.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountVO extends RepresentationModel<AccountVO> implements Serializable {
	
	private static final long serialVersionUID = 7392174081401620824L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("document_number")
	private String documentNumber;
	
	public static AccountVO converter(Account account){
        return new ModelMapper().map(account, AccountVO.class);
    }
}
