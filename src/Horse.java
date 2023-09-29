public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int[] possibleLineDiff = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
        int[] possibleColumnDiff = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (toLine > chessBoard.board.length - 1 || toLine < 0 || toColumn > chessBoard.board[0].length - 1 || toColumn < 0) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn].color.equals(this.color)) {
            return false;
        }

        for(int i = 0, stop = possibleLineDiff.length; i < stop; i++) {
            if (line + possibleLineDiff[i] == toLine && column + possibleColumnDiff[i] == toColumn) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}