package com;

import View.Facade.FBFacadeConcrete;
import View.Facade.FlightBookerFacade;

import java.util.Scanner;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class Main {
    public static void main(String[] args){

        FlightBookerFacade flightBooker = new FBFacadeConcrete();
        System.out.println("Please provide your origin and destination airport separated by space: ");
        Scanner scan  = new Scanner(System.in);
        String[] airports = scan.nextLine().split(" ");
        flightBooker.setDestination(airports[1]);
        flightBooker.setOrigin(airports[0]);

        flightBooker.SearchFlight();


    }
}
