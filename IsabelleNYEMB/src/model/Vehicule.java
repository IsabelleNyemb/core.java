package model;

import java.sql.Date;

public class Vehicule {
	private String idVehicule;
	private String numImmat;
	private String modele;
	private String statut;
	private Date dateEntree;
	private Date dateSortie;
	
	
	public String getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(String idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getNumImmat() {
		return numImmat;
	}
	public void setNumImmat(String numImmat) {
		this.numImmat = numImmat;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	

	
	}


