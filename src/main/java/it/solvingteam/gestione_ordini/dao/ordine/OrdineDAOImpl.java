package it.solvingteam.gestione_ordini.dao.ordine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public class OrdineDAOImpl implements OrdineDAO{
	
	private EntityManager entityManager;

	@Override
	public Set<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine",Ordine.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine ordine) throws Exception {
		if (ordine == null) {
			throw new Exception("Problema valore in input");
		}
		ordine = entityManager.merge(ordine);
		
	}

	@Override
	public void insert(Ordine ordine) throws Exception {
		if (ordine == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(ordine);
		
	}

	@Override
	public void delete(Ordine ordine) throws Exception {
		if (ordine == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ordine));
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}
	

	@Override
	public List<Ordine> findByCategoria(Categoria categoria) throws Exception {
		
		TypedQuery<Ordine> query = entityManager.createQuery("SELECT DISTINCT a.ordine from Articolo a JOIN a.categorie c where a.ordine is not null and c.descrizione = ?1",Ordine.class);
		query.setParameter(1, categoria.getDescrizione());		
		
		return query.getResultList();
	}

	@Override
	public boolean existArticoliPerOrdineX(Ordine ordine) throws Exception {
		
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join a.ordine o where o.id = ?1", Articolo.class);
		query.setParameter(1, ordine.getId());
		
		if(!query.getResultList().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
