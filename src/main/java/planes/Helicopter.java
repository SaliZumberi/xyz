package planes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Helicopter extends Airplane{
    int rotors;
    int minArea = 100;

    public Helicopter(String name, int seats, boolean canLandVertically, int rotors) {
        super(name, seats, canLandVertically);
        this.rotors = rotors;
    }
}
