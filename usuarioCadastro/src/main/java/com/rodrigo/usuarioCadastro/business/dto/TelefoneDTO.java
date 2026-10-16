package com.rodrigo.usuarioCadastro.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;
    private String numero;
    private String ddd;
}
