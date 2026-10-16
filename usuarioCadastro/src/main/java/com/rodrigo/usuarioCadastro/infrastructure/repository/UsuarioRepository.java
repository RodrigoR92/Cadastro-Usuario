package com.rodrigo.usuarioCadastro.infrastructure.repository;

import com.rodrigo.usuarioCadastro.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
