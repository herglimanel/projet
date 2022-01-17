package com.HRPlus.space.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caisse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCaisse;
	
	private String depense;

	private int montant;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser")
	private UserInformation user;

	public Long getIdCaisse() {
		return idCaisse;
	}

	public void setIdCaisse(Long idCaisse) {
		this.idCaisse = idCaisse;
	}

	public String getDepense() {
		return depense;
	}

	public void setDepense(String depense) {
		this.depense = depense;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public UserInformation getUser() {
		return user;
	}

	public void setUser(UserInformation user) {
		this.user = user;
	}
	
	
}
