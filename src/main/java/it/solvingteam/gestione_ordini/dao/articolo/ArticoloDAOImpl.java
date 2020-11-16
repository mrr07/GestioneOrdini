package it.solvingteam.gestione_ordini.dao.articolo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public class ArticoloDAOImpl implements ArticoloDAO{
	
	private EntityManager entityManager;

	@Override
	public Set<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo",Articolo.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo articolo) throws Exception {
		if (articolo == null) {
			throw new Exception("Problema valore in input");
		}
		articolo = entityManager.merge(articolo);
		
	}

	@Override
	public void insert(Articolo articolo) throws Exception {
		if (articolo == null ) {
			throw new Exception("Problema valore in input");
		}
		
		entityManager.persist(articolo);
		
	}

	@Override
	public void delete(Articolo articolo) throws Exception {
		if (articolo == null) {
			throw new Exception("Problema valore in input");
		}
		
			entityManager.remove(entityManager.merge(articolo));
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}
	
	
	@Override
	public boolean existByDescrizione(Articolo articolo) throws Exception {
		
		Set<Articolo> listaArticoli = new HashSet<>();
		listaArticoli = list();
		
		for(Articolo art : listaArticoli) {
			if(articolo.getDescrizione().compareTo(art.getDescrizione()) == 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Articolo findByDescrizione(Articolo articolo) throws Exception {
		
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a where a.descrizione = ?1",Articolo.class);
		query.setParameter(1, articolo.getDescrizione());
		return query.getSingleResult();
	
		
	}

	@Override
	public double sommaPrezziArticoliDiUnaCategoria(Categoria categoria) throws Exception {
		
		TypedQuery<Double> query = entityManager.createQuery("select sum(a.prezzoSingolo) FROM Articolo a join a.categorie c where c.id=?1",Double.class);
		query.setParameter(1, categoria.getId());
		System.out.println(query.getSingleResult());
		return query.getSingleResult();
	}

	@Override
	public boolean ExistOrdinePerArticoloDaEliminare(Articolo articolo) throws Exception {
		
		TypedQuery<Ordine> query = entityManager.createQuery("select o FROM Ordine o join o.articoli a where a.id = ?1", Ordine.class);
		query.setParameter(1, articolo.getId());
		
		if(!query.getResultList().isEmpty()) {
			return false;
		} else {
			return true;
		}
		
	}

}
