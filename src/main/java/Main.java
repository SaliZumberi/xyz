import planes.Airliner;
import planes.Airplane;
import planes.Helicopter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Airport airport1 = new Airport(30,30);
        Runway runway1 =  new Runway(10, 10, new Cell(0,1));
        Runway runway2 =  new Runway(5, 5, new Cell(11,1));
        Runway runway3 =  new Runway(4, 4, new Cell(16,5));
        Runway runway4 =  new Runway(3, 3, new Cell(16,10));
        Runway runway5 =  new Runway(3, 3, new Cell(16,15));
        Runway runway6 =  new Runway(30, 4, new Cell(20,0));
        Runway runway7 =  new Runway(30, 4, new Cell(25,0));

        airport1.addRunway(runway1);
        airport1.addRunway(runway2);
        airport1.addRunway(runway3);
        airport1.addRunway(runway4);
        airport1.addRunway(runway5);
        airport1.addRunway(runway6);
        airport1.addRunway(runway7);

        System.out.println(airport1.toString());

        Helicopter helicopter = new Helicopter("TIGER",2,true,4);
        Airliner airliner = new Airliner("JUMBO",232, false,3 );

        runway1.assignAirplane(helicopter);
        runway2.assignAirplane(airliner);

        System.out.println(airport1.toString());

    }
}
