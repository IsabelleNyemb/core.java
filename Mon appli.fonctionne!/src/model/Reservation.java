package model;

import java.sql.Connection;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

public class Reservation {
	private String idReservation;
	private String DateReserVeh;
	private String DateRetourVeh;
	private String DateCreation;
	private String Employe;
	private String Vehicule;	
	private int ActivReserv;
	
	public Reservation(String idReservation,String DateReserVeh, String DateRetourVeh,int ActivReserv) {
		this.idReservation= idReservation;
		this.DateReserVeh=DateReserVeh;
		this.DateRetourVeh=DateRetourVeh;
		this.DateCreation= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.ActivReserv= ActivReserv;
	}

	public String getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}

	public String getDateReserVeh() {
		return DateReserVeh;
	}

	public void setDateReserVeh(String dateReserVeh) {
		DateReserVeh = dateReserVeh;
	}

	public String getDateRetourVeh() {
		return DateRetourVeh;
	}

	public void setDateRetourVeh(String dateRetourVeh) {
		DateRetourVeh = dateRetourVeh;
	}

	public String getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(String dateCreation) {
		DateCreation = dateCreation;
	}
	
	public int getActivReserv() {
		return ActivReserv;
	}

	public void setActivReserv(int ActivReserv) {
		ActivReserv = ActivReserv;
	}
	
	public String getEmploye() {
		return Employe;
	}

	public void setEmploye(String employe) {
		Employe = employe;
	}

	public String getVehicule() {
		return Vehicule;
	}

	public void setVehicule(String vehicule) {
		Vehicule = vehicule;
	}

	

	public Reservation() {
		
	}
	
}
