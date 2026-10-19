package com.rodrigo.usuarioCadastro.business.converter;

import com.rodrigo.usuarioCadastro.business.dto.EnderecoDTO;
import com.rodrigo.usuarioCadastro.business.dto.TelefoneDTO;
import com.rodrigo.usuarioCadastro.business.dto.UsuarioDTO;
import com.rodrigo.usuarioCadastro.infrastructure.entity.Endereco;
import com.rodrigo.usuarioCadastro.infrastructure.entity.Telefone;
import com.rodrigo.usuarioCadastro.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListarEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListarTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListarEndereco(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream()
                .map(this::paraEndereco)
                .toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .bairro(enderecoDTO.getBairro())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListarTelefone(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream()
                .map(this::paraTelefone)
                .toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListarEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListarTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListarEnderecoDTO(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(this::paraEnderecoDTO)
                .toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .bairro(endereco.getBairro())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListarTelefoneDTO(List<Telefone> telefones) {
        return telefones.stream()
                .map(this::paraTelefoneDTO)
                .toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario entity) {
        return Usuario.builder()
                .id(entity.getId())
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : entity.getNome())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : entity.getEmail())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : entity.getSenha())
                .enderecos(entity.getEnderecos())
                .telefones(entity.getTelefones())
                .build();
    }

    public Endereco updateEndereco(EnderecoDTO enderecoDTO, Endereco entity) {
        return Endereco.builder()
                .id(entity.getId())
                .rua(enderecoDTO.getRua() != null ? enderecoDTO.getRua() : entity.getRua())
                .numero(enderecoDTO.getNumero() != null ? enderecoDTO.getNumero() : entity.getNumero())
                .cidade(enderecoDTO.getCidade() != null ? enderecoDTO.getCidade() : entity.getCidade())
                .bairro(enderecoDTO.getBairro() != null ? enderecoDTO.getBairro() : entity.getBairro())
                .estado(enderecoDTO.getEstado() != null ? enderecoDTO.getEstado() : entity.getEstado())
                .cep(enderecoDTO.getCep() != null ? enderecoDTO.getCep() : entity.getCep())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO telefoneDTO, Telefone entity) {
        return Telefone.builder()
                .id(entity.getId())
                .numero(telefoneDTO.getNumero() != null ? telefoneDTO.getNumero() : entity.getNumero())
                .ddd(telefoneDTO.getDdd() != null ? telefoneDTO.getDdd() : entity.getDdd())
                .build();
    }

    public Endereco paraEnderecoEntity(EnderecoDTO enderecoDTO, Long idUsuario) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .bairro(enderecoDTO.getBairro())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .usuarioId(idUsuario)
                .build();
    }

    public Telefone paraTelefoneEntity(TelefoneDTO telefoneDTO, Long idTelefone) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .usuarioId(idTelefone)
                .build();
    }
}
