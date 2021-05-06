package com.pismo.rotinatransacoes.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.rotinatransacoes.entity.Transaction;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TransactionVO implements Serializable{
	
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
