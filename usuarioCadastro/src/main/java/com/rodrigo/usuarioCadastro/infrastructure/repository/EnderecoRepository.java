package com.rodrigo.usuarioCadastro.infrastructure.repository;

import com.rodrigo.usuarioCadastro.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
