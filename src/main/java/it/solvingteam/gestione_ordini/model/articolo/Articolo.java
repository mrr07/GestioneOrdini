package it.solvingteam.gestione_ordini.model.articolo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.solvingteam.gestione_ordini.model.ordine.Ordine;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;

@Entity
@Table(name = "articolo")
public class Articolo {

	//id,descrizione,prezzoSingolo,ordine,categorie
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo_singolo")
	private Double prezzoSingolo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ordine")
	private Ordine ordine;
	
	@ManyToMany()
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "id_articolo", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
	private Set<Categoria> categorie = new HashSet<>();
	
	public Articolo(String descrizione, Double prezzoSingolo) {
		this.descrizione = descrizione;
		this.prezzoSingolo = prezzoSingolo;
	}

	public Articolo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzoSingolo() {
		return prezzoSingolo;
	}

	public void setPrezzoSingolo(Double prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", prezzo_singolo=" + prezzoSingolo + ", ordine=" + ordine
				+ ", categorie=" + categorie.size() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Articolo) {
			Articolo articolo = (Articolo)obj;
			if(this.descrizione.equals(articolo.getDescrizione())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
