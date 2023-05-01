package org.seidelsoft.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Calendar;

@Data
@Entity(name = "Empresa")
@Table(name = "empresa")
public class Empresa extends PanacheEntity {

    @NotEmpty
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotEmpty
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @NotEmpty
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @NotEmpty
    @Column(name = "tipo_pessoa")
    private Long tipoPessoa;

    @NotEmpty
    @Column(name = "situacao")
    private Long situacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_abertura")
    private Calendar dataAbertura;

    @Column(name = "porte_empresa")
    private Long porteEmpresa;

    @NotEmpty
    @Column(name = "telefone")
    private String telefone;

    @Email
    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;
}
