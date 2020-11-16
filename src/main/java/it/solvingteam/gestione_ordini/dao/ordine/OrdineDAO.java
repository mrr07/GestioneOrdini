package it.solvingteam.gestione_ordini.dao.ordine;

import java.util.List;
import java.util.Set;

import it.solvingteam.gestione_ordini.dao.IBaseDAO;
import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	
	public List<Ordine> findByCategoria(Categoria categoria) throws Exception; 
	
	public boolean existArticoliPerOrdineX(Ordine ordine) throws Exception;

}
