package com.pismo.rotinatransacoes.repository;

import com.pismo.rotinatransacoes.entity.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
}
