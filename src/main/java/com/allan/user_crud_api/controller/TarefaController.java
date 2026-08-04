package com.allan.user_crud_api.controller;

import com.allan.user_crud_api.Service.TarefaService;
import com.allan.user_crud_api.model.Tarefa;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listarPorUsuario(@PathVariable Long usuarioId) {
        return tarefaService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Tarefa criar(@PathVariable Long usuarioId, @Valid @RequestBody Tarefa tarefa) {
        return tarefaService.criar(usuarioId, tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long usuarioId, @PathVariable Long id, @RequestBody Tarefa tarefa){
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long usuarioId, @PathVariable Long id){
        tarefaService.deletar(id);
    }
}
