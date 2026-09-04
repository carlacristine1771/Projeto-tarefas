package com.senac.tarefas.controller;

import com.senac.tarefas.model.Tarefa;
import com.senac.tarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listar(@RequestParam(required = false) Long projetoId) {
        if (projetoId != null) {
            return tarefaService.listarPorProjeto(projetoId);
        }
        return tarefaService.listarTodas();
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> listarAtrasadas() {
        return tarefaService.listarAtrasadas();
    }

    @GetMapping("/por-prioridade")
    public List<Tarefa> listarPorPrioridade() {
        return tarefaService.listarPorPrioridade();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
    }
}
