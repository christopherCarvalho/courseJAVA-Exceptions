package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;
import model.util.DateFormat;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-In  (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(),DateFormat.fmt);
		System.out.print("Check-Out (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(),DateFormat.fmt);
		
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		
		System.out.println(reservation);
		
		System.out.println();
		System.out.println("Enter date to update reservation: ");
		System.out.print("Check-In  (dd/MM/yyyy): ");
		checkIn = LocalDate.parse(sc.next(),DateFormat.fmt);
		System.out.print("Check-Out (dd/MM/yyyy): ");
		checkOut = LocalDate.parse(sc.next(),DateFormat.fmt);
		
		reservation.updateDates(checkIn, checkOut);
		
		System.out.println("UPDATE DATES");
		System.out.println(reservation);
		
		}
		catch(NullPointerException e) {
			System.out.println("Invalid date format.");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Unexpected error!");
		}
		sc.close();
	}

}
