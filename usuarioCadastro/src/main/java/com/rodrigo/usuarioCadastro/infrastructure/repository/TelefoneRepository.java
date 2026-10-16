package com.rodrigo.usuarioCadastro.infrastructure.repository;

import com.rodrigo.usuarioCadastro.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
