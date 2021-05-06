package com.pismo.rotinatransacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pismo.rotinatransacoes.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = " select exists " +
                   " (select 1 from accounts " +
                   " where document_number = :documentNumber) " ,
            nativeQuery = true)
    Boolean jaCadastradoPorNumeroDocumento(@Param("documentNumber") String documentNumber);
}
