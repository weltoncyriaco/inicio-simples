package br.com.victsoft.simples.service.impl;

import br.com.victsoft.simples.config.bases.DefaultServiceImpl;
import br.com.victsoft.simples.model.Teste;
import br.com.victsoft.simples.repository.TesteRepository;
import br.com.victsoft.simples.service.interfaces.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesteServiceImpl extends DefaultServiceImpl<Teste, TesteRepository>
        implements TesteService {

    @Autowired
    public TesteServiceImpl(TesteRepository repository) {
        super(repository);
    }
}
