import org.junit.Before;
import org.junit.Test;
import planes.Helicopter;
import shapes.Square;

import static org.junit.Assert.assertEquals;


public class AirportTrafficControlTest {
    Airport airport;

    @Before
    public void setup() {
        airport = new Airport(20, 20);
    }

    @Test
    public void testGridCreation() {
        //arrange
        Airport airport = new Airport(30, 30);

        //act
        airport.createGrid();

        //assert
        assertEquals(airport.getGrid().length, 30);
        assertEquals(airport.getGrid()[0].length, 30);
    }

    @Test
    public void testDoesRunwayFitInAirport_true() {
        //arrange
        Cell startingPoint1 = new Cell(1, 1);
        Runway runway1 = new Runway(12, 40, startingPoint1);

        Cell startingPoint2 = new Cell(1, 1);
        Runway runway2 = new Runway(10, 12, startingPoint2);

        //act
        boolean doesRunwayFit1 = airport.doesRunwayFitInAirport(runway1);
        boolean doesRunwayFit2 = airport.doesRunwayFitInAirport(runway2);

        //assert
        assertEquals(doesRunwayFit1, false);
        assertEquals(doesRunwayFit2, true);
    }

    @Test
    public void testIsAreaAvailable() {
        //arrange
        Runway existingRunway1 = new Runway(10, 10, new Cell(1, 1));
        airport.addRunway(existingRunway1);

        //act
        Runway runwayToBeAdded1 = new Runway(10, 12, new Cell(1, 1));
        boolean IsAreaAvailable1 = airport.isAreaAvailable(runwayToBeAdded1);

        Runway runwayToBeAdded2 = new Runway(2, 2, new Cell(11, 1));
        boolean IsAreaAvailable2 = airport.isAreaAvailable(runwayToBeAdded2);

        //assert
        assertEquals(IsAreaAvailable1, false);
        assertEquals(IsAreaAvailable2, true);
    }

    @Test
    public void testBorderDrawing() {
        //arrange
        Runway existingRunway1 = new Runway(3, 3, new Cell(0, 0));

        //act
        airport.addRunway(existingRunway1);

        //assert
        assertEquals(airport.getGrid()[0][0].isBorder, true);
        assertEquals(airport.getGrid()[0][1].isBorder, true);
        assertEquals(airport.getGrid()[0][2].isBorder, true);
        assertEquals(airport.getGrid()[1][0].isBorder, true);
        assertEquals(airport.getGrid()[1][1].isBorder, false);
        assertEquals(airport.getGrid()[1][2].isBorder, true);
        assertEquals(airport.getGrid()[2][0].isBorder, true);
        assertEquals(airport.getGrid()[2][1].isBorder, true);
        assertEquals(airport.getGrid()[2][2].isBorder, true);
    }

    @Test
    public void testAssignedShape() {
        //arrange
        Runway existingRunway1 = new Runway();

        //act
        existingRunway1.addShape(3, 3);

        //assert
        assertEquals(existingRunway1.shape.getClass(), Square.class);
    }

    @Test
    public void testAreaOfRunway() {
        //arrange
        Runway existingRunway1 = new Runway(2,2,new Cell(1,1));

        //act
        airport.addRunway(existingRunway1);

        //assert
        assertEquals(existingRunway1.getArea().get(0).xCoordinate,1);
        assertEquals(existingRunway1.getArea().get(0).yCoordinate,1);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);

        assertEquals(existingRunway1.getArea().get(1).xCoordinate,2);
        assertEquals(existingRunway1.getArea().get(1).yCoordinate,1);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);

        assertEquals(existingRunway1.getArea().get(2).xCoordinate,1);
        assertEquals(existingRunway1.getArea().get(2).yCoordinate,2);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);

        assertEquals(existingRunway1.getArea().get(3).xCoordinate,2);
        assertEquals(existingRunway1.getArea().get(3).yCoordinate,2);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);
    }

    @Test
    public void testAssignmentOfPlane() {
        //arrange
        Runway existingRunway1 = new Runway(2,2,new Cell(1,1));
        airport.addRunway(existingRunway1);

        //act
        Helicopter helicopter = new Helicopter("TIGER",2,true,4);
        existingRunway1.assignAirplane(helicopter);

        //assert
        assertEquals(existingRunway1.getArea().get(0).xCoordinate,1);
        assertEquals(existingRunway1.getArea().get(0).yCoordinate,1);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);

        assertEquals(existingRunway1.getArea().get(1).xCoordinate,2);
        assertEquals(existingRunway1.getArea().get(1).yCoordinate,1);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);

        assertEquals(existingRunway1.getArea().get(2).xCoordinate,1);
        assertEquals(existingRunway1.getArea().get(2).yCoordinate,2);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);

        assertEquals(existingRunway1.getArea().get(3).xCoordinate,2);
        assertEquals(existingRunway1.getArea().get(3).yCoordinate,2);
        assertEquals(existingRunway1.getArea().get(0).isAvailable,true);
    }
}
