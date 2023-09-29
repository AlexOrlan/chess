public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) {
            return false;
        }

        if (toLine > chessBoard.board.length - 1 || toLine < 0 || toColumn > chessBoard.board[0].length - 1 || toColumn < 0) {
            return false;
        }

        if (isUnderAttack(chessBoard, toLine, toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn].color.equals(this.color)) {
            return false;
        }

        if ((line == toLine || column == toColumn || Math.abs(toLine - line) == Math.abs(toColumn - column)) && (Math.abs(toLine - line) == 1 || Math.abs(toColumn - column) == 1)) {
            return true;
        }

        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
