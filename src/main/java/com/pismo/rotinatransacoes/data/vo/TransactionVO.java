package com.pismo.rotinatransacoes.data.vo;

import java.io.Serializable;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.rotinatransacoes.entity.Transaction;

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
public class TransactionVO extends RepresentationModel<TransactionVO> implements Serializable{
	
	private static final long serialVersionUID = -401588496781673087L;

	@JsonProperty("id")
    private Long id;
    
    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    private Double amount;

    @JsonProperty("event_date")
    private LocalDate eventDate = LocalDate.now();

	public static TransactionVO converter(Transaction transaction){
        return new ModelMapper().map(transaction, TransactionVO.class);
    }
}
