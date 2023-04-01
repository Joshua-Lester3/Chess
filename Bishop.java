package Chess.Game;

import java.awt.Point;

public class Bishop extends Piece {

    protected Bishop(int x, int y, boolean isWhite) {
        super(x, y, 'b', isWhite);
    }

    protected Bishop(Point position, boolean isWhite) {
        super(position, 'b', isWhite);
    }

    //TO DO
    @Override
    public boolean isLegalMove(Point targetPosition, ChessBoard board) {
        return true;
    }

    //TO DO
    @Override
    public boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board) {
        return true;
    }
}
