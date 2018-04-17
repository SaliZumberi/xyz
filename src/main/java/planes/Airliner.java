package planes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airliner extends Airplane{
    int numberOfCabins;
    int minArea = 250;

    public Airliner(String name, int seats, boolean canLandVertically, int numberOfCabins) {
        super(name, seats, canLandVertically);
        this.numberOfCabins = numberOfCabins;
    }
}
