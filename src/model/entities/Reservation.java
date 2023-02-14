package model.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;
import model.util.DateFormat;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {	
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		
		if(checkOut.isAfter(checkIn))
		{
			this.roomNumber = roomNumber;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		}
		else {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public Long duration() {
		 long days = ChronoUnit.DAYS.between(checkIn, checkOut);
		 return days;
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate now = LocalDate.now();
		
		if(checkIn.isBefore(now) || checkOut.isBefore(now))
		{
			throw new DomainException("Reservation dates for update must be future dates");
		}
		else if (!checkOut.isAfter(checkIn))
		{
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reservation: " + roomNumber + ", checkIn: " + DateFormat.fmt.format(checkIn) + ", checkOut: " + DateFormat.fmt.format(checkOut)+ ", "+ duration()+" nights";
	}
	
	
}
