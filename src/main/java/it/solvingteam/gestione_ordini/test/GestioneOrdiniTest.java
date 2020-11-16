package it.solvingteam.gestione_ordini.test;

import java.util.HashSet;
import java.util.Set;

import it.solvingteam.gestione_ordini.dao.EntityManagerUtil;
import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;
import it.solvingteam.gestione_ordini.model.ordine.Ordine;
import it.solvingteam.gestione_ordini.service.MyServiceFactory;
import it.solvingteam.gestione_ordini.service.articolo.ArticoloService;
import it.solvingteam.gestione_ordini.service.articolo.ArticoloServiceImpl;
import it.solvingteam.gestione_ordini.service.categoria.CategoriaService;
import it.solvingteam.gestione_ordini.service.ordine.OrdineService;


public class GestioneOrdiniTest 
{
    public static void main( String[] args ) {
    	ArticoloService articoloService = MyServiceFactory.getArticoloServiceInstance();
    	CategoriaService categoriaService = MyServiceFactory.getCategoriaServiceInstance();
    	OrdineService ordineService = MyServiceFactory.getOrdineServiceInstance();
    	
    	try {
    		
    		// ----------------- CREAZIONE ARTICOLI -----------------
    		Articolo pc = new Articolo("Acer PC", 599.90);
    		Articolo cuffie = new Articolo("Cuffie Bose", 129.90);
    		Articolo tablet = new Articolo("Tablet Huawei", 599.90);
    		Articolo cuffie1 = new Articolo("Cuffie JBL", 29.90);
    		Articolo cavo = new Articolo("Cavo Ethernet", 9.90);
    		Articolo televisore = new Articolo("Televisore Samsung", 1199.99);
    		Articolo lavatrice = new Articolo("Lavatrice Whirpool", 599.90);
    		Articolo asciugatrice = new Articolo("Asciugatrice Whirpool", 599.90);
    		
    		
//    		articoloService.insert(pc);
//    		articoloService.insert(cuffie);
//    		articoloService.insert(tablet);
//    		articoloService.insert(cuffie1);
//    		articoloService.insert(cavo);
//    		articoloService.insert(televisore);
//    		articoloService.insert(lavatrice);
//    		articoloService.insert(asciugatrice);
    		
    		
    		Articolo articolo1 = articoloService.findByID(1L);
    		Articolo articolo2 = articoloService.findByID(2L);
    		Articolo articolo3 = articoloService.findByID(3L);
    		Articolo articolo4 = articoloService.findByID(4L);
    		Articolo articolo5 = articoloService.findByID(5L);
    		Articolo articolo6 = articoloService.findByID(6L);
    		Articolo articolo7 = articoloService.findByID(7L);
    		Articolo articolo8 = articoloService.findByID(8L);
    		
    		
    		// ------------------- CREAZIONE CATEGORIE ------------------------
    		Categoria informatica = new Categoria("Informatica");
    		Categoria elettronica = new Categoria("Elettronica");
    		Categoria audioVideo = new Categoria("Audio e Video");
    		
    		
//    		categoriaService.insert(informatica);
//    		categoriaService.insert(elettronica);
//    		categoriaService.insert(audioVideo);
    		
    		
    		Categoria categoria1 = categoriaService.findByID(1L); 
    		Categoria categoria2 = categoriaService.findByID(2L); 
    		Categoria categoria3 = categoriaService.findByID(3L);
    		
    		
    		// -----------------SETTO LA CATEGORIA AGLI OGGETTI -----------------
    		
    		
//    		articoloService.addCategoria(articolo1, categoria1);
//    		articoloService.addCategoria(articolo1, categoria2);
//    		articoloService.addCategoria(articolo2, categoria2);
//    		articoloService.addCategoria(articolo2, categoria3);
//    		articoloService.addCategoria(articolo4, categoria2);
//    		articoloService.addCategoria(articolo4, categoria3);
//    		articoloService.addCategoria(articolo6, categoria2);
//    		articoloService.addCategoria(articolo7, categoria2);
//    		articoloService.addCategoria(articolo8, categoria2);
//    		articoloService.addCategoria(articolo5, categoria2);
//    		articoloService.addCategoria(articolo3, categoria1);
//    		articoloService.addCategoria(articolo3, categoria2);
    		
    		
    		// ----------------- CREAZIONE ORDINI ---------------------------
    		Ordine ordine1 = new Ordine("Manuel Ferrini", "Via qualcosa1");
    		Ordine ordine2 = new Ordine("Chiara Valli", "Via qualcosa2");
    		Ordine ordine3 = new Ordine("Elisa Perti", "Via qualcosa3");
    		Ordine ordine4 = new Ordine("Claudio Folla", "Via qualcosa4");
    		
    		
//    		ordineService.insert(ordine1);
//    		ordineService.insert(ordine2);
//    		ordineService.insert(ordine3);
//    		ordineService.insert(ordine4);
    		
    		Ordine ordineDB1 = ordineService.findByID(1L);
    		Ordine ordineDB2 = ordineService.findByID(2L);
    		Ordine ordineDB3 = ordineService.findByID(3L);
    		Ordine ordineDB4 = ordineService.findByID(4L);
    		
    		
    		// ---------------- ARTICOLI PER SINGOLO ORDINE --------------------------
    		
    		
//    		ordineService.addArticolo(ordineDB1, articolo1);
//    		ordineService.addArticolo(ordineDB1, articolo2);
//    		ordineService.addArticolo(ordineDB2, articolo3);
//    		ordineService.addArticolo(ordineDB3, articolo4);
//    		ordineService.addArticolo(ordineDB4, articolo4);
//    		ordineService.addArticolo(ordineDB4, articolo5);
//    		ordineService.addArticolo(ordineDB4, articolo6);
//    		ordineService.addArticolo(ordineDB2, articolo7);
//    		ordineService.addArticolo(ordineDB3, articolo8);
    		
    		
    		
    		
    		//articoloService.delete(articolo1);  non è possibile eliminarlo
    		//categoriaService.delete(categoria1);
    		
    		//articoloService.delete(articolo2);
    		//categoriaService.delete(categoria1);
    		
    		for(Ordine o : ordineService.findByCategoria(categoria2)) {
    			System.out.println(o);
    		}
    		//categoriaService.categoriePerOrdineX(ordineDB1);
    		//articoloService.sommaPrezziArticoliDiUnaCategoria(categoria1);
    		
//    		articoloService.removeCategoria(articolo1, categoria1);
//    		articoloService.removeCategoria(articolo3, categoria1);
    		
//    		categoriaService.delete(categoria1);
    		
    		
    		
    		
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
    	}
    }
    
}
