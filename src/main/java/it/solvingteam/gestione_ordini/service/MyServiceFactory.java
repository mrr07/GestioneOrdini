package it.solvingteam.gestione_ordini.service;


import it.solvingteam.gestione_ordini.dao.MyDAOFactory;
import it.solvingteam.gestione_ordini.service.articolo.ArticoloService;
import it.solvingteam.gestione_ordini.service.articolo.ArticoloServiceImpl;
import it.solvingteam.gestione_ordini.service.categoria.CategoriaService;
import it.solvingteam.gestione_ordini.service.categoria.CategoriaServiceImpl;
import it.solvingteam.gestione_ordini.service.ordine.OrdineService;
import it.solvingteam.gestione_ordini.service.ordine.OrdineServiceImpl;

public class MyServiceFactory {

	// rendiamo questo factory SINGLETON
	private static ArticoloService ARTICOLO_SERVICE_INSTANCE;
	private static OrdineService ORDINE_SERVICE_INSTANCE;
	private static CategoriaService CATEGORIA_SERVICE_INSTANCE;

	public static ArticoloService getArticoloServiceInstance() {
		if (ARTICOLO_SERVICE_INSTANCE == null)
			ARTICOLO_SERVICE_INSTANCE = new ArticoloServiceImpl();

		ARTICOLO_SERVICE_INSTANCE.setArticoloDAO(MyDAOFactory.getArticoloDAOInstance());
		return ARTICOLO_SERVICE_INSTANCE;
	}

	public static OrdineService getOrdineServiceInstance() {
		if (ORDINE_SERVICE_INSTANCE == null)
			ORDINE_SERVICE_INSTANCE = new OrdineServiceImpl();

		ORDINE_SERVICE_INSTANCE.setOrdineDAO(MyDAOFactory.getOrdineDAOInstance());
		return ORDINE_SERVICE_INSTANCE;
	}
	
	public static CategoriaService getCategoriaServiceInstance() {
		if (CATEGORIA_SERVICE_INSTANCE == null)
			CATEGORIA_SERVICE_INSTANCE = new CategoriaServiceImpl();

		CATEGORIA_SERVICE_INSTANCE.setCategoriaDAO(MyDAOFactory.getCategoriaDAOInstance());
		return CATEGORIA_SERVICE_INSTANCE;
	}

}
