package com.formation.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Table(name="restaurants")
@Entity
public class restaurant {
	@Id
	@GeneratedValue(generator ="systeme-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	private String nom;
	private String adresse;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
