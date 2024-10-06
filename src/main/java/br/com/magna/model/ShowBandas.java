package br.com.magna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_shows_bandas")
@Entity(name = "ShowBandas")
public class ShowBandas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shows")
	private Shows show;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bandas")
	private Bandas banda;

	public ShowBandas() {

	}

	public ShowBandas(Long id, Shows show, Bandas banda) {
		this.id = id;
		this.show = show;
		this.banda = banda;
	}

	public Long getId() {
		return id;
	}

	public Shows getShow() {
		return show;
	}

	public Bandas getBanda() {
		return banda;
	}

}
