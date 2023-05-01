package org.seidelsoft.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "Cidade")
@Table(name = "cidade")
public class Cidade extends PanacheEntity {

    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estado;

}
