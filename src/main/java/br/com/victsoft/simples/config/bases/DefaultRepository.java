package br.com.victsoft.simples.config.bases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
@Transactional(readOnly=true)
public interface DefaultRepository<C extends DefaultEntity> extends JpaRepository<C, Long> {
}
