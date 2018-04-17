import lombok.Getter;
import lombok.Setter;
import planes.Airplane;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Runway {
    Airplane assignedAirplane;
    List<Cell> area = new ArrayList<>();
    Cell startingPoint;
    boolean isAvailable;
    Shape shape;

    public Runway(){}

    public Runway(int width, int height, Cell startingPoint) {
        addShape(width,height);
        this.startingPoint = startingPoint;
    }

    public final void addShape(int width, int height) {
        if(width == height){
            shape = new Square(width);
        }else{
            shape = new Rectangle(width,height);
        }
    }

    public void assignAirplane(Airplane airplane) {
        if (airplane.getMinArea() <= (area.size())) {
            this.assignedAirplane = airplane;
            this.isAvailable = false;
            for (Cell cell : area) {
                cell.isAvailable = true;
            }
        } else {
            System.out.print("Area is too small for this type of Airplane");
        }
    }
}
