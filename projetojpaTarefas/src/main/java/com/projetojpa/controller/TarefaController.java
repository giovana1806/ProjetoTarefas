package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Tarefa;
import com.projetojpa.services.TarefaService;

@RestController
@RequestMapping("/tarefas")

public class TarefaController {
    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscaTarefasControlId(@PathVariable Long id){
    	Tarefa tarefa = tarefaService.buscaTarefaId(id);
    	if (tarefa != null) {
    		return ResponseEntity.ok(tarefa);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/")
    public ResponseEntity<List<Tarefa>> buscaTodasTarefasControl(){
    	List<Tarefa> tarefa = tarefaService.buscaTodasTarefas();
    	return ResponseEntity.ok(tarefa);
    }
    @PostMapping("/")
    public ResponseEntity<Tarefa> salvaTarefasControl(@RequestBody Tarefa tarefa){
    	Tarefa salvaTarefa = tarefaService.salvaTarefa(tarefa);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> alteraTarefasControl(@PathVariable Long id, @RequestBody Tarefa tarefa){
    	Tarefa alteraTarefa = tarefaService.alterarTarefa(id, tarefa);
    	if (alteraTarefa != null) {
    		return ResponseEntity.ok(tarefa);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaTarefaControl(@PathVariable Long id){
    	boolean apagar = tarefaService.apagarTarefa(id);
    	if(apagar) {
    		return ResponseEntity.ok().body("A tarefa foi excluida!");
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
}

