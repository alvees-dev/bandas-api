package br.com.magna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "ShowBandas")
@Table(name = "tb_show_bandas")
public class ShowBandas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Shows show;
	private Bandas banda;
	
	
	ShowBandas() {
		
	}
	
	

}
