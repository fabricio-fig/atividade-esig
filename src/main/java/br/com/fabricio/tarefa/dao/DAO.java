package br.com.fabricio.tarefa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fabricio.tarefa.model.ContratoID;

public class DAO<T extends ContratoID> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager manager = ConnectionFactory.getEntityManager();
	
	public T buscarPorID(Class<T> classe, Long id) {
		return manager.find(classe, id);
	}
	
	public void salvar(T t) {
		try {
			manager.getTransaction().begin();
			if(t.getId() == null) {
				manager.persist(t);
			}else {
				manager.merge(t);
			}
			
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
		}
	}
	public void remover(Class<T>classe, Long id) {
		T t = buscarPorID(classe, id);
		try {
			manager.getTransaction().begin();
			
			manager.remove(t);
			
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> buscarTodas(String jpql){
		Query query = manager.createQuery(jpql);
		return query.getResultList();
	}
}
