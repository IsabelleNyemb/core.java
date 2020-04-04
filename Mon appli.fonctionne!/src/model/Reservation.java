package model;

import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.time.DateTimeException;

public class Reservation {
	private String idReservation;
	private Date DateReserVeh;
	private Date DateRetourVeh;
	private DateFormat DateCreation;
	
	public Reservation() {
		
	}
	
	public Reservation(String idReservation,Date DateReserVeh, Date DateRetourVeh,DateFormat DateCreation) {
		this.idReservation= idReservation;
		this.DateReserVeh=DateReserVeh;
		this.DateRetourVeh=DateRetourVeh;
		this.DateCreation= DateCreation;
	}
	
	public String getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateReserVehicule() {
		return DateReserVeh;
	}
	public void setDateReserVehicule(Date dateReserVehicule) {
		DateReserVeh = dateReserVehicule;
	}
	public Date getDateRetourVehicule() {
		return DateRetourVeh;
	}
	public void setDateRetourVehicule(Date dateRetourVehicule) {
		DateRetourVeh = dateRetourVehicule;
	}
	public DateFormat getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(DateFormat dateCreation) {
		DateCreation = dateCreation;
	}
	
	
}
