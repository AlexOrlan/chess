public class Rook extends ChessPiece {
    public Rook(String color) {
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

        if (chessBoard.board[toLine][toColumn].color.equals(this.color)) {
            return false;
        }

        if (line == toLine || column == toColumn) {
            if (line > toLine) {
                lineDiff = -1;
            }
            else if(line < toLine) {
                lineDiff = 1;
            }

            if (column > toColumn) {
                columnDiff = -1;
            }
            else if(column < toColumn) {
                columnDiff = 1;
            }

            if (line == toLine) {
                for (int i = column; i != toColumn; i += columnDiff) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }

            if (column == toColumn) {
                for (int i = line; i != toLine; i += lineDiff) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
