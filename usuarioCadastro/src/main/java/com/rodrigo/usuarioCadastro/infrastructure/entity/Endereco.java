package com.rodrigo.usuarioCadastro.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereço")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua", length = 150)
    private String rua;

    @Column(name = "numero", length = 10)
    private Long numero;

    @Column(name = "bairro", length = 100)
    private String bairro;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "cep", length = 10)
    private String cep;
}
