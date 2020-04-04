package model;

public class Employe {
	private String idemploye;
	private String matricule;
	private String nom;
	private String prenom;
	private String numTel;
	private String fonction;
	private String numPermis;
	private int validAdmin;
		
	public Employe( String idemploye,String matricule,String nom,String prenom,String numTel,String fonction,String numPermis, int validAdmin) {
		this.idemploye= idemploye;
		this.matricule= matricule;
		this.nom=nom;
		this.prenom=prenom;
		this.numTel=numTel;
		this.fonction=fonction;
		this.numPermis=numPermis;
		this.validAdmin=validAdmin;
		
	}
	
	public int getValidAdmin() {
		return validAdmin;
	}

	public void setValidAdmin(int validAdmin) {
		this.validAdmin = validAdmin;
	}

	public String getIdemploye() {
		return idemploye;
	}

	public void setIdemploye(String idemploye) {
		this.idemploye = idemploye;
	}

	public Employe() {
		
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getnumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}
	
	

}
