package it.solvingteam.gestione_ordini.service.ordine;

import java.util.List;
import java.util.Set;

import it.solvingteam.gestione_ordini.dao.ordine.OrdineDAO;
import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public interface OrdineService {

	public Set<Ordine> listAll() throws Exception;

	public Ordine findByID(Long id) throws Exception;

	public void update(Ordine ordineInstance) throws Exception;

	public void insert(Ordine ordineInstance) throws Exception;

	public void delete(Ordine ordineInstance) throws Exception;
	
	public void addArticolo(Ordine ordine, Articolo articolo) throws Exception;
	
	public void removeArticolo(Ordine ordine, Articolo articolo) throws Exception;
	
	public List<Ordine> findByCategoria(Categoria categoria) throws Exception;

	// per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);
}
