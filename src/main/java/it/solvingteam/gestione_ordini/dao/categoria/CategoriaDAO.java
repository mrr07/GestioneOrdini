package it.solvingteam.gestione_ordini.dao.categoria;

import java.util.List;

import it.solvingteam.gestione_ordini.dao.IBaseDAO;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	
	public boolean existArticoliPerCategoriaX(Categoria categoria) throws Exception;
	
	public boolean existByDescrizione(Categoria categoria) throws Exception;
	
	public Categoria findByDescrizione(Categoria categoria) throws Exception;
	
	public List<Categoria> categoriePerOrdineX(Ordine ordine) throws Exception;

}
