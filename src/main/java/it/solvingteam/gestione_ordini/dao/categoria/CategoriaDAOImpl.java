package it.solvingteam.gestione_ordini.dao.categoria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO{
	
	private EntityManager entityManager;

	@Override
	public Set<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria",Categoria.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Problema valore in input");
		}
		categoria = entityManager.merge(categoria);
		
	}

	@Override
	public void insert(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(categoria);
		
	}

	@Override
	public void delete(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Problema valore in input");
		}
		
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join a.categorie cat where cat.descrizione = :descrizione", Articolo.class);
		query.setParameter("descrizione", categoria.getDescrizione());
		
		
		if(query.getResultList().isEmpty()) {
			entityManager.remove(entityManager.merge(categoria));
		}else {
			System.out.println("IMPOSSIBILE ELIMINARE LA CATEGORIA");
		}
		
		
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public boolean existByDescrizione(Categoria categoria) throws Exception {
		
		Set<Categoria> listaCategorie = new HashSet<>();
		listaCategorie = list();
		
		for(Categoria cat : listaCategorie) {
			if(categoria.getDescrizione().compareTo(cat.getDescrizione()) == 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Categoria findByDescrizione(Categoria categoria) throws Exception {
		
		TypedQuery<Categoria> query = entityManager.createQuery("select c FROM Categoria c where c.descrizione = ?1",Categoria.class);
		query.setParameter(1, categoria.getDescrizione());
		return query.getSingleResult();
	
		
	}

	@Override
	public List<Categoria> categoriePerOrdineX(Ordine ordine) throws Exception {
		
		TypedQuery<Categoria> query = entityManager.createQuery("select distinct c FROM Categoria c join c.articoli a where a.ordine.id = ?1",Categoria.class);
		query.setParameter(1, ordine.getId());
		
		List<Categoria> lista = query.getResultList();
		
		for(Categoria c : lista) {
			System.out.println(c.getDescrizione());
		}
		
		return query.getResultList();

	}

	@Override
	public boolean existArticoliPerCategoriaX(Categoria categoria) throws Exception {
		
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join a.categorie c where c.id = ?1", Articolo.class);
		query.setParameter(1, categoria.getId());
		
		if(!query.getResultList().isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}
}
