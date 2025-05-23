
import entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.exceptions.DomainExceptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Davede faiska
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);

            System.out.println("");
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+reservation);
        }
        catch(ParseException e){
            System.out.println("Invaliid date format");
        }
        catch(DomainExceptions e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected  error!");
        }
        
        sc.close();
    }
    
}
