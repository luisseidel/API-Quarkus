package org.seidelsoft.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.service.spi.ServiceException;
import org.seidelsoft.dao.PaisRepository;
import org.seidelsoft.model.pais.Pais;
import org.seidelsoft.model.pais.PaisDTO;
import org.seidelsoft.model.pais.PaisMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class PaisService {

    private final PaisRepository repository;
    private final PaisMapper mapper;

    public List<PaisDTO> findAll() {
        return this.mapper.toDomainList(repository.findAll().list());
    };

    public Optional<PaisDTO> findById(@NonNull Long id) {
        return repository.findByIdOptional(id).map(mapper::toDomain);
    }

    @Transactional
    public void save(@Valid PaisDTO dto) {
        Pais pais = mapper.toEntity(dto);
        repository.persist(pais);
        mapper.updateDomainFromEntity(pais, dto);
    }

    @Transactional
    public void update(@Valid PaisDTO dto) {
        if (Objects.isNull(dto)) {
            throw new ServiceException("Object don't have a id");
        }

        Pais entity = repository.findByIdOptional(dto.getId())
                .orElseThrow(() -> new ServiceException("Nenhum país encontrado!"));
        mapper.updateEntityFromDomain(dto, entity);
        repository.persist(entity);
        mapper.updateDomainFromEntity(entity, dto);
    }
}
