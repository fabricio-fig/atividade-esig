package br.com.fabricio.tarefa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fabricio.tarefa.exception.ExcecaoTarefa;
import br.com.fabricio.tarefa.model.Tarefa;
import br.com.fabricio.tarefa.service.TarefaService;
import br.com.fabricio.tarefa.utility.Message;

@ManagedBean(name="tarefaMB")
@Named
@ViewScoped
public class TarefaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Tarefa tarefa;

	@Inject
	private TarefaService tarefaService;

	private List<Tarefa> tarefas;

	@PostConstruct
	public void carregarTarefas() {
		tarefas = tarefaService.listaTarefas();
	}

	public void adicionarTarefa() {

		try {
			tarefaService.salvar(tarefa);
			tarefa = new Tarefa();
			carregarTarefas();

			Message.info("Tarefa salva com sucesso");
		} catch (ExcecaoTarefa e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluirTarefa() {
		try {
			tarefaService.remover(tarefa);
			carregarTarefas();

			Message.info(tarefa.getTitulo() + " foi removida!");

		} catch (ExcecaoTarefa e) {
			Message.erro(e.getMessage());
		}
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}
}
