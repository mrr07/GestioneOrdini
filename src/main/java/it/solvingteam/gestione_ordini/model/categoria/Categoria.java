package it.solvingteam.gestione_ordini.model.categoria;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.solvingteam.gestione_ordini.model.articolo.Articolo;


@Entity
@Table(name = "categoria")
public class Categoria {

	//id,descrizione, articoli
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	
	@ManyToMany(mappedBy = "categorie")
	private Set<Articolo> articoli = new HashSet<>();
	
	public Categoria() {
		super();
	}
	
	public Categoria(String descrizione) {
		this.descrizione = descrizione;
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

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + ", articoli=" + articoli.size() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Categoria) {
			Categoria categoria = (Categoria)obj;
			if(this.descrizione.equals(categoria.getDescrizione())) {
				return true;
			}
		}
		return false;
	}
	
}
