package it.solvingteam.gestione_ordini.service.categoria;

import java.util.Set;

import javax.persistence.EntityManager;

import it.solvingteam.gestione_ordini.dao.EntityManagerUtil;
import it.solvingteam.gestione_ordini.dao.categoria.CategoriaDAO;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;

public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaDAO categoriaDAO;

	@Override
	public Set<Categoria> listAll() throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Categoria findByID(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return categoriaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo Ã¨ come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			if(!categoriaDAO.existByDescrizione(categoriaInstance)) {
				categoriaDAO.update(categoriaInstance);
			} else {
				System.out.println("IMPOSSIBILE AGGIORNARE LA CATEGORIA!!");
			}
			

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		/// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			if(!categoriaDAO.existByDescrizione(categoriaInstance)) {
				categoriaDAO.insert(categoriaInstance);
			} else {
				System.out.println("IMPOSSIBILE INSERIRE LA CATEGORIA");
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void delete(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			
				categoriaDAO.setEntityManager(entityManager);
			
			
			if(categoriaDAO.existArticoliPerCategoriaX(categoriaInstance)) {
				// eseguo quello che realmente devo fare
				categoriaDAO.delete(categoriaInstance);
			} else {
				System.out.println("IMPOSSIBILE ELIMINARE CATEGORIA!!");
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
		
	}

	@Override
	public void categoriePerOrdineX(Ordine ordine) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);
			categoriaDAO.categoriePerOrdineX(ordine);
			// eseguo quello che realmente devo fare
			 

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

}
