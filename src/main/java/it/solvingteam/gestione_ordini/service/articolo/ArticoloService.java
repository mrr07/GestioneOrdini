package it.solvingteam.gestione_ordini.service.articolo;

import java.util.Set;

import it.solvingteam.gestione_ordini.dao.articolo.ArticoloDAO;
import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;

public interface ArticoloService {

	public Set<Articolo> listAll() throws Exception;

	public Articolo findByID(Long id) throws Exception;

	public void update(Articolo articoloInstance) throws Exception;

	public void insert(Articolo articoloInstance) throws Exception;

	public void delete(Articolo articoloInstance) throws Exception;
	
	public void addCategoria(Articolo articolo, Categoria categoria) throws Exception;
	
	public void removeCategoria(Articolo articolo, Categoria categoria) throws Exception;
	
	public void sommaPrezziArticoliDiUnaCategoria(Categoria categoria) throws Exception;

	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);
}
