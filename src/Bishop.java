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
        int lineDiff = 0;
        int columnDiff = 0;
        int columnCoord = 0;

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (toLine > chessBoard.board.length - 1 || toLine < 0 || toColumn > chessBoard.board[0].length - 1 || toColumn < 0) {
            return false;
        }

        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            if (line > toLine) {
                lineDiff = -1;
            }
            else {
                lineDiff = 1;
            }
            if (column > toColumn) {
                columnDiff = -1;
            }
            else {
                columnDiff = 1;
            }

            columnCoord = column;
            for (int lineCoord = line; lineCoord != toLine; lineCoord += lineDiff) {
                columnCoord += columnDiff;

                if (lineCoord == line) {
                    continue;
                }

                if (chessBoard.board[lineCoord][columnCoord] != null) {
                    return false;
                }
            }

            if (chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}