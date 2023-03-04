public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInField(toLine, toColumn) && isRightMove(line, column, toLine, toColumn) && isNotSame(line, column, toLine, toColumn)) {
            return true;
        } else {
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

    public boolean isRightMove(int line, int column, int toLine, int toColumn) {
        boolean rez = false;

        if (Math.abs(toColumn - column) == Math.abs(toLine - line)) {
            rez = true;
        }

        return rez;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    public boolean isInField(int toLine, int toColumn) {
        return ChessBoard.checkPos(toLine) && ChessBoard.checkPos(toColumn);
    }
}


