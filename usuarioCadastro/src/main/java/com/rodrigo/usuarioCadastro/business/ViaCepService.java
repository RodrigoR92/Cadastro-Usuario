package com.rodrigo.usuarioCadastro.business;

import com.rodrigo.usuarioCadastro.infrastructure.clients.ViaCepClient;
import com.rodrigo.usuarioCadastro.infrastructure.clients.ViaCepDTO;
import com.rodrigo.usuarioCadastro.infrastructure.exception.IllegalArgumentexception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepDTO buscaDadosEndereco(String cep) {
        return viaCepClient.buscaDadosEndereco(processarCep(cep));
    }

    private String processarCep(String cep) {
        String cepFormatado = cep.replace(" ", "")
                .replace("-", "");

        if (!cepFormatado.matches("\\d+") || cepFormatado.length() != 8) {
            throw new IllegalArgumentexception("O cep contém caracteres inválidos, favor verificar");
        }

        return cepFormatado;
    }
}
