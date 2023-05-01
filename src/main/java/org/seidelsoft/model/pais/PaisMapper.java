package org.seidelsoft.model.pais;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PaisMapper {
    List<PaisDTO> toDomainList(List<Pais> list);
    PaisDTO toDomain(Pais dto);
    @InheritInverseConfiguration(name = "toDomain")
    Pais toEntity(PaisDTO pais);
    void updateEntityFromDomain(PaisDTO domain, @MappingTarget Pais entity);
    void updateDomainFromEntity(Pais entity, @MappingTarget PaisDTO domain);
}
