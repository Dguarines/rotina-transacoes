package com.pismo.rotinatransacoes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.modelmapper.ModelMapper;

import com.pismo.rotinatransacoes.data.vo.AccountVO;

@Entity
@Table(name = "accounts")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Account implements Serializable {
	
	private static final long serialVersionUID = 7484899215291338695L;

	@Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private Long id;

	@Column(name="document_number")
	private String documentNumber;
	
	public static Account converter(AccountVO accountVO){
        return new ModelMapper().map(accountVO, Account.class);
    }
}
