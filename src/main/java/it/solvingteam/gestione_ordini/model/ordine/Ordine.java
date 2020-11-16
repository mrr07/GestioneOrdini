package it.solvingteam.gestione_ordini.model.ordine;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.solvingteam.gestione_ordini.model.articolo.Articolo;
import it.solvingteam.gestione_ordini.model.categoria.Categoria;

@Entity
@Table(name = "ordine")
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome_destinatario")
	private String nomeDestinatario;
	@Column(name = "indirizzo_spedizione")
	private String indirizzoSpedizione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordine")
	private Set<Articolo> articoli = new HashSet<>();
	
	public Ordine() {
		
	}
	
	public Ordine( String nomeDestinatario, String indirizzoSpedizione) {
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
	@Override
	public String toString() {
		return "Ordine [id=" + id + ", nome_destinatario=" + nomeDestinatario + ", indirizzo_spedizione=" + indirizzoSpedizione + 
				"]";
	}
	


}
