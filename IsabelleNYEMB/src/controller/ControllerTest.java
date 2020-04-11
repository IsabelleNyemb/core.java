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
				ResultSet resultatBef = statement.executeQuery("SELECT count(*) comptage FROM reservation;");	
				resultatBef.last();
				int i = (resultatBef.getInt("comptage")+ 1);
	            Reservation R= new Reservation("R37", new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "9999-12-31", 1);
				Controller.AjouterR("E012", "FR 8593 201", "00004563R", R.getIdReservation(), R.getDateReserVeh(), R.getDateRetourVeh());
				ResultSet resultatAft = statement.executeQuery("SELECT count(*) comptage FROM reservation;");	
				resultatAft.last();			
				assertEquals(resultatAft.getInt("comptage"),i);
			}
}
