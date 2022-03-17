package br.com.fabricio.tarefa.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fabricio.tarefa.dao.DAO;
import br.com.fabricio.tarefa.exception.ExcecaoTarefa;
import br.com.fabricio.tarefa.model.Tarefa;

public class TarefaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Tarefa> dao;
	
	public void salvar(Tarefa t) throws ExcecaoTarefa{
		if(t.getTitulo().length() < 3) {
			throw new ExcecaoTarefa("O título da tarefa não pode ter menos de 3 caracteres");
		}
		dao.salvar(t);
	}
	
	public void remover(Tarefa t) throws ExcecaoTarefa{
		dao.remover(Tarefa.class, t.getId());
	}
	public List<Tarefa> listaTarefas(){
		return dao.buscarTodas("select t from Tarefa t order by t.id");
	}
}
