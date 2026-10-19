package com.rodrigo.usuarioCadastro.business;

import com.rodrigo.usuarioCadastro.business.converter.UsuarioConverter;
import com.rodrigo.usuarioCadastro.business.dto.UsuarioDTO;
import com.rodrigo.usuarioCadastro.infrastructure.entity.Usuario;
import com.rodrigo.usuarioCadastro.infrastructure.exception.ConflictExcepition;
import com.rodrigo.usuarioCadastro.infrastructure.exception.ResourceNotFoundException;
import com.rodrigo.usuarioCadastro.infrastructure.repository.UsuarioRepository;
import com.rodrigo.usuarioCadastro.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        try {
            existeEmail(usuarioDTO.getEmail());
            usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
            Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
            return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));

        } catch (ConflictExcepition e) {
            throw new ConflictExcepition("Email já cadastrado! " + e.getCause());
        }
    }
    public void existeEmail(String email) {
        try {
            boolean existe = verificaEmail(email);
            if (existe) {
                throw new ConflictExcepition("Email já cadastrado! " + email);
            }

        } catch (ConflictExcepition e) {
            throw new ConflictExcepition("Email já cadastrado! " + e.getCause());
        }
    }

    public boolean verificaEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscaUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email não encontrado! "));
    }

    public void deletaUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setSenha(dto.getSenha() != null ? passwordEncoder.encode(dto.getSenha()) : null);
        Usuario usuarioEntity = usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não localizado!"));

        Usuario usuario = usuarioConverter.updateUsuario(dto, usuarioEntity);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
}
