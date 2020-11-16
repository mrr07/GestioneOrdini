package it.solvingteam.gestione_ordini.dao;

import it.solvingteam.gestione_ordini.dao.articolo.*;
import it.solvingteam.gestione_ordini.dao.categoria.*;
import it.solvingteam.gestione_ordini.dao.ordine.*;

public class MyDAOFactory {

	// rendiamo questo factory SINGLETON
	private static OrdineDAO ORDINE_DAO_INSTANCE = null;
	private static ArticoloDAO ARTICOLO_DAO_INSTANCE = null;
	private static CategoriaDAO CATEGORIA_DAO_INSTANCE = null;

	public static OrdineDAO getOrdineDAOInstance() {
		if (ORDINE_DAO_INSTANCE == null)
			ORDINE_DAO_INSTANCE = new OrdineDAOImpl();
		return ORDINE_DAO_INSTANCE;
	}

	public static ArticoloDAO getArticoloDAOInstance() {
		if (ARTICOLO_DAO_INSTANCE == null)
			ARTICOLO_DAO_INSTANCE = new ArticoloDAOImpl();
		return ARTICOLO_DAO_INSTANCE;
	}
	
	public static CategoriaDAO getCategoriaDAOInstance() {
		if (CATEGORIA_DAO_INSTANCE == null)
			CATEGORIA_DAO_INSTANCE = new CategoriaDAOImpl();
		return CATEGORIA_DAO_INSTANCE;
	}

}
