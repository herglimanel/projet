package com.HRPlus.space.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employe extends UserInformation {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String status;
	private String salary;
	private String cnss; 
	private String departement;
	private String fonction;
	private String typeContrat;
	private LocalDate dateEntree;
	private LocalDate dateSortie;
	private String coutHeuresSup;
	private String dureeConges;
	private String id_card_number;
	
	
	private boolean archived;
	

	@OneToMany(mappedBy = "employe")
	private List<EmployeMeeting> employeMeetings;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employe")
	@JsonManagedReference
	private List<Document> docs ;

	public Employe(String username, String email, LocalDate dateOfBirth, String phone, String password, String status,
			String salary, String cnss, String departement, String fonction, String typeContrat, LocalDate dateEntree,
			LocalDate dateSortie, String coutHeuresSup, String dureeConges, String id_card_number, boolean archived,
			List<EmployeMeeting> employeMeetings, List<Document> docs) {
		super(username, email, dateOfBirth, phone, password);
		this.status = status;
		this.salary = salary;
		this.cnss = cnss;
		this.departement = departement;
		this.fonction = fonction;
		this.typeContrat = typeContrat;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.coutHeuresSup = coutHeuresSup;
		this.dureeConges = dureeConges;
		this.id_card_number = id_card_number;
		this.archived = archived;
		this.employeMeetings = employeMeetings;
		this.docs = docs;
	}
	

	public Employe(String username, String email, LocalDate dateOfBirth, String phone, String password) {
		super(username, email, dateOfBirth, phone, password);
		// TODO Auto-generated constructor stub
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getCoutHeuresSup() {
		return coutHeuresSup;
	}

	public void setCoutHeuresSup(String coutHeuresSup) {
		this.coutHeuresSup = coutHeuresSup;
	}

	public String getDureeConges() {
		return dureeConges;
	}

	public void setDureeConges(String dureeConges) {
		this.dureeConges = dureeConges;
	}

	public String getId_card_number() {
		return id_card_number;
	}

	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public List<EmployeMeeting> getEmployeMeetings() {
		return employeMeetings;
	}

	public void setEmployeMeetings(List<EmployeMeeting> employeMeetings) {
		this.employeMeetings = employeMeetings;
	}

	public List<Document> getDocs() {
		return docs;
	}

	public void setDocs(List<Document> docs) {
		this.docs = docs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	

}
