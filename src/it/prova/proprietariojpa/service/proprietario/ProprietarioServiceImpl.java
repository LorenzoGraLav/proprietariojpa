package it.prova.proprietariojpa.service.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.proprietariojpa.model.Proprietario;
import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.dao.proprietario.ProprietarioDAO;

public class ProprietarioServiceImpl implements ProprietarioService {
	
	private ProprietarioDAO proprietarioDAO;

	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;
	}

	public List<Proprietario> listAllProprietari() throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					proprietarioDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return proprietarioDAO.list();

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	}

	public Proprietario caricaSingoloproprietario(Long id) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					proprietarioDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return proprietarioDAO.get(id);

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	
	}

	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					proprietarioDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					proprietarioDAO.update(proprietarioInstance);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
		
	}

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					proprietarioDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					proprietarioDAO.insert(proprietarioInstance);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	}

	public void rimuovi(Proprietario proprietarioInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					proprietarioDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					proprietarioDAO.delete(proprietarioInstance);

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
