package br.com.victsoft.simples.controller;

import br.com.victsoft.simples.model.Teste;
import br.com.victsoft.simples.service.interfaces.TesteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Teste", description = "Criação e manutenção de teste.")
@RestController
@RequestMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteController {

    @Autowired
    private TesteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Teste> getOne(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findOne(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Teste>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Teste> post(@RequestBody Teste teste) {
        return ResponseEntity.ok(service.save(teste));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> put(@PathVariable(value = "id") Long id, @RequestBody Teste teste) {
        service.findOne(id).ifPresent(obj -> {
            teste.setId(id);
            service.save(teste);
        });
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
