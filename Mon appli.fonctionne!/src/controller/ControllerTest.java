package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import model.Employe;
import model.Reservation;


public class ControllerTest  extends TestCase{
		
			public ControllerTest() {
				super();
			}
		
			public static void testAjouterR () throws Exception {
				Connection BdConnexion= Controller.getConnection();
				Statement statement = BdConnexion.createStatement();
				
				//On compte le nombre de réservation avant l'ajout
				//System.out.println("Before adding");
				ResultSet resultatBef = statement.executeQuery("SELECT count(*) comptage FROM reservation;");	
				resultatBef.last();
				//System.out.println(resultatBef.getRow() + " Ligne renvoyée");
	            //System.out.println("Nombre de lignes avant insertion : " + resultatBef.getInt("comptage"));
				int i = (resultatBef.getInt("comptage")+ 1);
	            //Insertion réservation
	            Reservation R= new Reservation("R27", new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "9999-12-31", 1);
				Controller.AjouterR("E012", "FR 8593 201", "00004563R", R.getIdReservation(), R.getDateReserVeh(), R.getDateRetourVeh());
	            
				//On compte le nombre de réservation après l'ajout
				//System.out.println("After adding");
				ResultSet resultatAft = statement.executeQuery("SELECT count(*) comptage FROM reservation;");	
				resultatAft.last();
				//System.out.println(resultatAft.getRow() + " Ligne renvoyée");
	            //System.out.println("Nombre de lignes après insertion : " + resultatAft.getInt("comptage"));
				
				assertEquals(resultatAft.getInt("comptage"),i);
			}
}
