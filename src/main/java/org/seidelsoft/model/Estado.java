package org.seidelsoft.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.seidelsoft.model.pais.Pais;

@Data
@Table(name = "estado")
@Entity(name = "Estado")
public class Estado extends PanacheEntity {

    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @Column(name = "cod_area")
    private String codigoArea;

    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    private Pais pais;
}
