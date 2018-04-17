import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Airport {
    Cell[][] grid;
    List<Runway> runways = new ArrayList<>();

    Airport(){}

    Airport(int height, int width) {
        this.grid = new Cell[height][width];
        createGrid();
    }

    public final void createGrid() {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                grid[y][x] = new Cell(y, x);
            }
        }
    }

    public void addRunway(Runway runway) {
        if (doesRunwayFitInAirport(runway) && isAreaAvailable(runway)) {
            for (int y = runway.startingPoint.yCoordinate; y < runway.startingPoint.yCoordinate + runway.shape.getHeight(); y++) {
                for (int x = runway.startingPoint.xCoordinate; x < runway.startingPoint.xCoordinate + runway.shape.getWidth(); x++) {

                    if ((y == runway.startingPoint.xCoordinate + runway.shape.getWidth())
                            || (y == runway.startingPoint.yCoordinate)
                            || (x == runway.startingPoint.xCoordinate)
                            || (y == runway.startingPoint.yCoordinate + runway.shape.getHeight() - 1)
                            || (x == runway.startingPoint.xCoordinate + runway.shape.getWidth() - 1)) {
                        grid[y][x].isBorder = true;
                    }
                }
            }
        } else {
            System.out.println("shapes.Rectangle does not fit in System");
        }

        for (int y = runway.startingPoint.yCoordinate; y < runway.startingPoint.yCoordinate + runway.shape.getHeight(); y++) {
            for (int x = runway.startingPoint.xCoordinate; x < runway.startingPoint.xCoordinate + runway.shape.getWidth(); x++) {
                    runway.area.add(grid[y][x]);
            }
        }
    }

    public boolean doesRunwayFitInAirport(Runway runway) {
        boolean doesWidthFit = grid.length >= (runway.startingPoint.xCoordinate + runway.shape.getWidth());
        boolean doesHeightFit = grid[0].length >= (runway.startingPoint.yCoordinate + runway.shape.getHeight());
        return doesHeightFit && doesWidthFit;
    }

    public boolean isAreaAvailable(Runway runway){
        for (int y = runway.startingPoint.yCoordinate; y < runway.startingPoint.yCoordinate + runway.shape.getHeight(); y++) {
            for (int x = runway.startingPoint.xCoordinate; x < runway.startingPoint.xCoordinate + runway.shape.getWidth(); x++) {
                if (!grid[y][x].isAvailable || grid[y][x].isBorder ) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String gridString = "";
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if(grid[r][c].isBorder){
                    gridString += "[#]";
                }else if (!grid[r][c].isAvailable){
                    gridString += "[X]";
                }else{
                    gridString += "[ ]";
                }
            }
            gridString += ("\n");
        }
        return gridString;
    }
}
