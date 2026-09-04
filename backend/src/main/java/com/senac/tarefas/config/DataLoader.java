package com.senac.tarefas.config;

import com.senac.tarefas.model.*;
import com.senac.tarefas.repository.ProjetoRepository;
import com.senac.tarefas.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;

    public DataLoader(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public void run(String... args) {
        if (projetoRepository.count() == 0) {
            Projeto p1 = projetoRepository.save(new Projeto(null, "Site institucional", "Reformular o site da empresa"));
            Projeto p2 = projetoRepository.save(new Projeto(null, "App mobile", "App de pedidos para o cliente"));

            Tarefa t1 = new Tarefa();
            t1.setProjetoId(p1.getId());
            t1.setTitulo("Criar wireframes");
            t1.setStatus(StatusTarefa.CONCLUIDA);
            t1.setPrioridade(Prioridade.MEDIA);
            t1.setDataLimite(LocalDate.now().minusDays(5));
            tarefaRepository.save(t1);

            Tarefa t2 = new Tarefa();
            t2.setProjetoId(p1.getId());
            t2.setTitulo("Implementar tela de login");
            t2.setStatus(StatusTarefa.EM_ANDAMENTO);
            t2.setPrioridade(Prioridade.ALTA);
            t2.setDataLimite(LocalDate.now().plusDays(3));
            tarefaRepository.save(t2);

            Tarefa t3 = new Tarefa();
            t3.setProjetoId(p2.getId());
            t3.setTitulo("Configurar ambiente React Native");
            t3.setStatus(StatusTarefa.PENDENTE);
            t3.setPrioridade(Prioridade.BAIXA);
            t3.setDataLimite(LocalDate.now().plusDays(10));
            tarefaRepository.save(t3);
        }
    }
}
