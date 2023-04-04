package it.prova.proprietariojpa.test;

import java.util.List;

import it.proprietariojpa.model.Automobile;
import it.proprietariojpa.model.Proprietario;

import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.service.MyServiceFactory;
import it.prova.proprietariojpa.service.automobili.AutomobileService;
import it.prova.proprietariojpa.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {

	public static void main(String[] args) {

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println(
					"In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size() + " elementi.");
//
//			testInserisciProprietario(proprietarioService);
//			System.out.println(
//					"In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size() + " elementi.");

			testInserisciAutomobile(proprietarioService, automobileService);
			System.out.println(
			"In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size() + " elementi.");


			
		


		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}


	}
	
	private static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testInserisciProprietario inizio.............");
		// creo nuovo proprietario
		Proprietario nuovoProprietario = new Proprietario("Marco", "Gnazio", "MRK01GKML09");
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		// salvo
		proprietarioService.inserisciNuovo(nuovoProprietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		System.out.println(".......testInserisciProprietario fine: PASSED.............");
	}
	
	private static void testInserisciAutomobile(ProprietarioService proprietarioService, AutomobileService automobileService)
			throws Exception {
		System.out.println(".......testInserisciAutomobile inizio.............");

		// creo nuova automobile ma prima mi serve un proprietario
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if (listaProprietariPresenti.isEmpty())
			throw new RuntimeException("testInserisciAutomobile fallito: non ci sono proprietari a cui collegarci ");

		Automobile nuovaAutomobile = new Automobile("Fiat", "500",  "GLC789X");
		// lo lego al primo municipio che trovo
		nuovaAutomobile.setProprietario(listaProprietariPresenti.get(0));

		// salvo il nuovo abitante
		automobileService.inserisciNuovo(nuovaAutomobile);

		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAbitante fallito ");

		// il test fallisce anche se non è riuscito a legare i due oggetti
		if (nuovaAutomobile.getProprietario() == null)
			throw new RuntimeException("testInserisciAutomobile fallito: non ha collegato il proprietario ");

		System.out.println(".......testInserisciAutomobile fine: PASSED.............");
	}

}
