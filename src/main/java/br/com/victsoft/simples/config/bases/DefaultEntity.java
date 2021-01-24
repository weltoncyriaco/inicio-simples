package br.com.victsoft.simples.config.bases;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    @Column(name="version")
    protected Integer version;

    public abstract Long getId();

    public abstract void setId(Long id);
}
