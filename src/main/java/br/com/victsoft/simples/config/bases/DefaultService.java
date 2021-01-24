package br.com.victsoft.simples.config.bases;

import java.util.List;
import java.util.Optional;

public interface DefaultService<C extends DefaultEntity> {

    C save(C entity);

    void delete(Long id);

    void delete(C entity);

    Optional<C> findOne(Long id);

    List<C> findAll();

    String toJson(Object value);

    boolean hasValue(DefaultEntity obj);

    boolean hasValue(List<?> list);

    long count();
}
