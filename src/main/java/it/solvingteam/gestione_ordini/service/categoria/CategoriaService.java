package it.solvingteam.gestione_ordini.service.categoria;

import java.util.Set;

import it.solvingteam.gestione_ordini.dao.categoria.CategoriaDAO;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public interface CategoriaService {

	public Set<Categoria> listAll() throws Exception;

	public Categoria findByID(Long id) throws Exception;

	public void update(Categoria categoriaInstance) throws Exception;

	public void insert(Categoria categoriaInstance) throws Exception;

	public void delete(Categoria categoriaInstance) throws Exception;
	
	public void categoriePerOrdineX(Ordine ordine) throws Exception;

	// per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
