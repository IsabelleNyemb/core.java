package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import model.Employe;
import view.Jemeconnecte;


public class Controller {

	
		public static void main (String[] args) throws Exception {
			getConnection();
			
		}
		
		public static Connection getConnection() throws Exception{
			try {
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3307/gestionFlotte?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					String username = "admin";
					String password = "Firenze2";
					Class.forName(driver);
					
					Connection conn = DriverManager.getConnection(url, username, password);
						//System.out.println("connected");
						return conn;						
				}catch (Exception e) {
				//System.out.println (e);			
					return null;}			
		}	
			
		public static Employe getIdentifiant (String UserName, String PassWord) {
			Employe E= new Employe();
			
			Connection BdConnexion= null;
			try {
				
	            BdConnexion = Controller.getConnection();
	            Statement statement = BdConnexion.createStatement();// permet d'éxécuter une requête
	            ResultSet resultat = statement.executeQuery( "SELECT idEmploye,Matricule,Nom,Prenom,NumTel,Fonction,NumPermis,ValidAdmin FROM employe WHERE UserName='" + UserName + "' AND MotDePasse='" + PassWord + "';");		            	            	          
	            resultat.next();
	            System.out.println(resultat.getRow());
	            if (resultat.getRow()==1) {		// répéter à chaque demande de données
	            	System.out.println("après");
	              //on passe à l'étape suivante		
	            	String idEmploye= resultat.getString ("IdEmploye");
	                String matriculeEmploye = resultat.getString( "Matricule" );	
	                System.out.println(matriculeEmploye);
	                String nomEmploye = resultat.getString( "Nom" );
	                System.out.println(nomEmploye);
	                String prenomEmploye = resultat.getString( "Prenom" );
	                String numTelEmploye = resultat.getString( "NumTel" );
	                String fonctionEmploye = resultat.getString( "Fonction" );
	                String numPermisEmploye = resultat.getString( "NumPermis" );  
	                int validAdmin= resultat.getInt("validAdmin");
                	E= new Employe (idEmploye, matriculeEmploye,nomEmploye,prenomEmploye,numTelEmploye,fonctionEmploye,
	                			numPermisEmploye,validAdmin);           
	             } 		                	
	            		               		            		        		 		        
	        } catch (Exception e) {		        	
				e.printStackTrace();
			} finally {
	            if ( BdConnexion != null )		            
	                try {		                    
	                    BdConnexion.close();
	                } catch ( SQLException ignore ) {
	                  
	                }
	        }
			return E;
		}
	
		public static String [][] getReserver(String IdEmploye){
			Connection BdConnexion= null;
			String [][] tab = new String [1][3];
			try {
	            BdConnexion = Controller.getConnection();
	            Statement statement = BdConnexion.createStatement();// permet d'éxécuter une requête
	            ResultSet resultat = statement.executeQuery( 
	            		"SELECT NumImmat, Modele, DateReserVeh FROM reservation INNER JOIN vehicule ON Vehicule_idVehicule=idVehicule WHERE Employe_idEmploye='"+ IdEmploye + "';");	
	            System.out.println(IdEmploye);
	           // System.out.println(resultat.getRow());
	            //System.out.println(resultat.getString ("NumImmat"));            
	            if(resultat.next()){
	            	tab [0][0]= resultat.getString ("NumImmat");
	            	tab [0][1]= resultat.getString("Modele");
	            	tab [0][2]= resultat.getString("DateReserveh");
	            }	          
	          
			 } catch (Exception e) {
		        	//System.out.println (e.getMessage());
					e.printStackTrace();
				} finally {
		            if ( BdConnexion != null )		            
		                try {		                    
		                    BdConnexion.close();
		                } catch ( SQLException ignore ) {
		                  
		                }
		        }
			return tab;
		}
		         
		public static String [][] getGestionnaire(){
			Connection BdConnexion= null;
			String [][] tab = new String [1][7];
			try {				
	            BdConnexion = Controller.getConnection();
	            Statement statement1 = BdConnexion.createStatement();// permet d'éxécuter une requête
	            ResultSet resultatTab = statement1.executeQuery("SELECT Nom,Prenom,Fonction,NumPermis,NumImmat,Modele,DateReserVeh,DateRetourVeh FROM reservation INNER JOIN  vehicule on Vehicule_idVehicule = idVehicule INNER JOIN employe ON Employe_idEmploye= idEmploye");
	            
	            resultatTab.last();           
	            int compteur =resultatTab.getRow();
	            int k = 0;
			tab = new String [compteur][7];
			System.out.println(compteur);
			  resultatTab.first();
			  do {      
	        	tab [k][0]= resultatTab.getString ("Nom");
	        	tab [k][1]= resultatTab.getString ("Prenom");
	        	tab [k][2]= resultatTab.getString ("Fonction");
	        	tab [k][3]= resultatTab.getString ("NumImmat");
	        	tab [k][4]= resultatTab.getString("Modele");
	        	tab [k][5]= resultatTab.getString("DateReserveh");
	        	tab [k][6]= resultatTab.getString("DateRetourveh");
	        	k++;
	        }  while (resultatTab.next());
	        	       	    	
					 } catch (Exception e) {
						 
							e.printStackTrace();
						} finally {
				            if ( BdConnexion != null )		            
				                try {		                    
				                    BdConnexion.close();
				                } catch ( SQLException ignore ) {
				                  
				                }
				        }
			return tab;
		}
		
}


		
