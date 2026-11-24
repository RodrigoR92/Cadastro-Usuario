package com.rodrigo.usuarioCadastro.infrastructure.repository;

import com.rodrigo.usuarioCadastro.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    Optional<Telefone> findByIdAndUsuarioId(Long id, Long usuarioId);
}
