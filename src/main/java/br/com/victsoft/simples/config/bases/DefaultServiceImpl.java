package br.com.victsoft.simples.config.bases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DefaultServiceImpl<C extends DefaultEntity, R extends DefaultRepository<C>>
        implements DefaultService<C> {

    private static final Logger logger = LogManager.getLogger(DefaultServiceImpl.class);

    private final R repository;

    public DefaultServiceImpl(R repository) {
        this.repository = repository;
    }

    public void preDeleteValidation(C entity) {}

    public void afterDeleteValidation(C entity) {}

    public void preSaveValidation(C entity) {}

    public void afterSaveValidation(C entity) {}

    @Transactional
    @Override
    public C save(C entity) {
        preSaveValidation(entity);
        C newObject = this.getRepository().save(entity);
        afterSaveValidation(newObject);
        return newObject;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        findOne(id).ifPresent(this::delete);
    }

    @Transactional
    @Override
    public void delete(C entity) {
        preDeleteValidation(entity);
        getRepository().delete(entity);
        afterDeleteValidation(entity);
    }

    @Override
    public Optional<C> findOne(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public List<C> findAll() {
        return getRepository().findAll();
    }

    @Override
    public String toJson(Object value) {
        return null;
    }

    @Override
    public boolean hasValue(DefaultEntity obj) {
        return Objects.nonNull(obj) && Objects.nonNull(obj.getId());
    }

    @Override
    public boolean hasValue(List<?> list) {
        return Objects.nonNull(list) && !list.isEmpty();
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    public R getRepository() {
        return repository;
    }
}
