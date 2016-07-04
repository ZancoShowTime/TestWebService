package dao;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DAOGenerico {
	private static EntityManager entityManager;

	public void inserir(Object objeto) {
		entityManager = Banco.getConexao().getEm();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(objeto);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void exluir(Object objeto) throws Exception {
		EntityTransaction et = null;
		try {
			entityManager = Banco.getConexao().getEm();
			et = entityManager.getTransaction();
			if (!et.isActive()) {
				et.begin();
			}
			Method getChave = objeto.getClass().getMethod("getId", new Class[0]);
			objeto = entityManager.find(objeto.getClass(), getChave.invoke(objeto, new Object[0]));
			entityManager.remove(objeto);

			et.commit();
		} catch (Exception e) {

			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void alterar(Object objeto) {
		entityManager = Banco.getConexao().getEm();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(objeto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List listaComStatus(Class classe) {
		Query query = null;
		try {
			entityManager = Banco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName() + " where status is true order by id");
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}

	public List listar(Class classe) {
		Query query = null;
		try {
			entityManager = Banco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}

	public Object buscarPorId(Class classe, Long id) {
		Object retornando = null;
		try {
			entityManager.getTransaction().begin();
			retornando = entityManager.find(classe, id);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return retornando;
	}
}
