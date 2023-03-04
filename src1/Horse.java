public class Horse extends ChessPiece {

    public Horse(String color){
        super(color);
    }
    public String getColor(){
        return this.color;
    }
    public boolean canMoveToPosition( ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInField(toLine,toColumn) && isRightMove(line,column,toLine,toColumn) && isNotSame(line,column,toLine,toColumn)){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isNotSame(int line, int column, int toLine, int toColumn) {
        if (column != toColumn){
            return true;
        }
        if (line != toLine){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isRightMove(int line, int column, int toLine, int toColumn){
        boolean rez = false;
        if (Math.abs(toLine - line) <= 2 && Math.abs(toColumn - column) <= 2){
            rez = true;
        }
        return rez;
    }
    public String getSymbol(){
        return "H";
    }
    public boolean isInField(int toLine, int toColumn){
        return ChessBoard.checkPos(toLine) && ChessBoard.checkPos(toColumn);
    }

}
