package baseFlotte;

public class Employe {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String numTel;
	private String fonction;
	private String NumPermis;
	
	
	
	
	public Employe(String matricule,String nom,String prenom,String numTel,String fonction,String NumPermis) {
		this.matricule= matricule;
		this.nom=nom;
		this.prenom=prenom;
		this.numTel=numTel;
		this.fonction=fonction;
		this.NumPermis=NumPermis;
		
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




	public String getNumPermis() {
		return NumPermis;
	}




	public void setNumPermis(String numPermis) {
		NumPermis = numPermis;
	}



	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
