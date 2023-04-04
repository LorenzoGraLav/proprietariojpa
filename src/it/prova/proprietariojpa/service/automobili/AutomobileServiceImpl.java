package it.prova.proprietariojpa.service.automobili;

import java.util.List;

import javax.persistence.EntityManager;

import it.proprietariojpa.model.Automobile;
import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.dao.automobile.AutomobileDAO;

public class AutomobileServiceImpl implements AutomobileService {
	
	private AutomobileDAO automobileDAO;
	
	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;
		
	}
	
	

	public List<Automobile> listAllAutomobili() throws Exception {
		
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					automobileDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return automobileDAO.list();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	}

	public Automobile caricaSingolaAutomobile(Long id) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					automobileDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return automobileDAO.get(id);

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	}

	public void aggiorna(Automobile automobileInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					automobileDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					automobileDAO.update(automobileInstance);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
		
	}

	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					automobileDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					automobileDAO.insert(automobileInstance);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
		
	}

	public void rimuovi(Long idAutomobileInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					automobileDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					automobileDAO.delete(automobileDAO.get(idAutomobileInstance));

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
		
	}

	
	
}
