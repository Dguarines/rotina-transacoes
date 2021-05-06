package com.pismo.rotinatransacoes.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.rotinatransacoes.entity.Account;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountVO implements Serializable {
	
	private static final long serialVersionUID = 7392174081401620824L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("document_number")
	private String documentNumber;
	
	public static AccountVO converter(Account account){
        return new ModelMapper().map(account, AccountVO.class);
    }
}
