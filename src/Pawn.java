public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int lineDiff = 0;

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (toLine > chessBoard.board.length - 1 || toLine < 0 || toColumn > chessBoard.board[0].length - 1 || toColumn < 0) {
            return false;
        }

        if (column != toColumn) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn].color.equals(this.color)) {
            return false;
        }

        if ((line == 1 || line == 6) && Math.abs(toLine - line) <= 2) {
            if (Math.abs(toLine - line) == 2) {
                if (line > toLine) {
                    lineDiff = -1;
                } else {
                    lineDiff = 1;
                }

                if (chessBoard.board[(line + lineDiff)][column] != null) {
                    return false;
                }
            }

            return true;
        }

        if (line != 1 && line != 6 && Math.abs(toLine - line) == 1) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
