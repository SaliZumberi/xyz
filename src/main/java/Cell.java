public class Cell {
    public boolean isBorder;
    int yCoordinate;
    int xCoordinate;
    boolean isAvailable;

    public Cell(int yCoordinate,int xCoordinate) {
        this.yCoordinate = yCoordinate;
        this.xCoordinate = xCoordinate;
        this.isAvailable = true;
    }

    @Override
    public String toString(){
        if(isAvailable){
            return " ";
        }else{
            return "#";
        }
    }
}
