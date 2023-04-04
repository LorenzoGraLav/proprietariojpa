package it.prova.proprietariojpa.service.automobili;

import java.util.List;

import it.proprietariojpa.model.Automobile;
import it.prova.proprietariojpa.dao.automobile.AutomobileDAO;


public interface AutomobileService {
	public List<Automobile> listAllAutomobili() throws Exception;

	public Automobile caricaSingolaAutomobile(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;
	
	public void trovaErroreProprietarioMinorenne();
	

	//per injection
	public void setAutomobileDAO(AutomobileDAO automobileDAO);

}
