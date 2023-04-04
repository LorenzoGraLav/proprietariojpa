package it.prova.proprietariojpa.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.proprietariojpa.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Proprietario> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();

	}

	public Proprietario get(Long id) throws Exception {
		return entityManager.find(Proprietario.class, id);

	}

	public void update(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		proprietarioInstance = entityManager.merge(proprietarioInstance);

	}

	public void insert(Proprietario propietarioInstance) throws Exception {
		if (propietarioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(propietarioInstance);
	}

	public void delete(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(proprietarioInstance));

	}

}
