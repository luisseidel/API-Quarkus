package org.seidelsoft.model.pais;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity(name="Pais")
@Table(name="pais")
public class Pais extends PanacheEntity {

    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @Column(name = "cod_area")
    private String codigoArea;
}
