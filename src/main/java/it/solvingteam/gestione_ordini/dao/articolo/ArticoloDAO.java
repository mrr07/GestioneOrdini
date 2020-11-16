package it.solvingteam.gestione_ordini.dao.articolo;

import it.solvingteam.gestione_ordini.dao.IBaseDAO;
import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo>{
	
	//verifica se esistono ordini per un determinato articolo
	public boolean ExistOrdinePerArticoloDaEliminare(Articolo articolo) throws Exception;
	
	//verifica se esiste già un articolo con lo stesso nome (descrizione)
	public boolean existByDescrizione(Articolo articolo) throws Exception;
	
	//trova l'articolo mediante il nome (descrizione)
	public Articolo findByDescrizione(Articolo articolo) throws Exception;
	
	//restituisce la somma dei prezzi degli articoli di una particolare categoria
	public double sommaPrezziArticoliDiUnaCategoria(Categoria categoria) throws Exception;

	

}
