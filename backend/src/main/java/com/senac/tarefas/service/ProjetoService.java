package com.senac.tarefas.service;

import com.senac.tarefas.model.Projeto;
import com.senac.tarefas.repository.ProjetoRepository;
import com.senac.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;

    public ProjetoService(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id).orElseThrow();
    }

    public Projeto salvar(Projeto projeto) {
        // BUG: nao verifica se ja existe um projeto com o mesmo nome
        return projetoRepository.save(projeto);
    }

    public void excluir(Long id) {
        // BUG: exclui o projeto sem checar/excluir as tarefas vinculadas a ele.
        // As tarefas ficam "orfas" com um projetoId que nao existe mais,
        // e a tela de tarefas pode quebrar ao tentar mostrar o nome do projeto.
        projetoRepository.deleteById(id);
    }
}
