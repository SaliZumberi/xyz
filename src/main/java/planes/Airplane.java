package planes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Airplane {
    private String name;
    private int id;
    private int seats;
    private boolean canLandVertically;
    private int minArea;

    public Airplane(String name, int seats, boolean canLandVertically) {
        this.name = name;
        this.id = (int)(Math.random() * 101);
        this.seats = seats;
        this.canLandVertically = canLandVertically;
    }
}
