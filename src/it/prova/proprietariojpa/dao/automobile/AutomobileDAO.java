package it.prova.proprietariojpa.dao.automobile;

import java.util.List;

import it.proprietariojpa.model.Automobile;
import it.prova.proprietariojpa.dao.IBaseDAO;

public interface AutomobileDAO extends IBaseDAO<Automobile> {
	public List<Automobile> erroreConProprietarioMinorenne();
}
