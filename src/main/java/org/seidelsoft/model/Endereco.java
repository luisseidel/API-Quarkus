package org.seidelsoft.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity(name = "Endereco")
@Table(name = "endereco")
public class Endereco extends PanacheEntity {

    @NotEmpty
    @Column(name = "cep")
    private String cep;

    @Column(name = "tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cidade", referencedColumnName = "id")
    private Cidade cidade;
}
