package com.pismo.rotinatransacoes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="operation_type")
public class OperationType implements Serializable {
	
	private static final long serialVersionUID = 3804066974068543820L;
	
	public static final Long COMPRA_A_VISTA = 1L;
    public static final Long COMPRA_PARCELADA = 2L;
    public static final Long SAQUE = 3L;
    public static final Long PAGAMENTO = 4L;
    
    @Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="operation_type_id")
    private Long id;

    private String description;

    public static boolean valorNaoCondizComOTipoDaOperacao(Transaction transaction){
        return isTransacaoNaoCondizComOperacaoNegativa(transaction) || isTransacaoNaoCondizComOperacaoPositiva(transaction);
    }

    private static boolean isTransacaoNaoCondizComOperacaoPositiva(Transaction transaction){
        return isOperacaoNegativa(transaction.getOperationType().getId()) && transaction.getAmount() > 0;
    }

    private static boolean isTransacaoNaoCondizComOperacaoNegativa(Transaction transaction){
        return isOperacaoPositiva(transaction.getOperationType().getId()) && transaction.getAmount() < 0;
    }

    private static boolean isOperacaoPositiva(Long idOperation) {
        return PAGAMENTO.equals(idOperation);
    }

    private static boolean isOperacaoNegativa(Long idOperation) {
        return COMPRA_A_VISTA.equals(idOperation) || COMPRA_PARCELADA.equals(idOperation) || SAQUE.equals(idOperation);
    }
}
