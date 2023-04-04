package it.prova.proprietariojpa.service.proprietario;

import java.util.List;


import it.proprietariojpa.model.Proprietario;
import it.prova.proprietariojpa.dao.proprietario.ProprietarioDAO;




public interface ProprietarioService {
	public List<Proprietario> listAllProprietari() throws Exception;

	public Proprietario caricaSingoloproprietario(Long id) throws Exception;
	
	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Proprietario proprietarioInstance) throws Exception;
	

	//per injection
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

}
