package Chess.Game;

import java.awt.Point;

public class EmptyPiece extends Piece {
    protected EmptyPiece(Point point) {
        super(point, '_', false);
    }

    protected EmptyPiece(int x, int y) {
        super(x, y, '_', false);
    }

    //returns false because you can't move an empty piece, or else the user will be able to move it
    @Override
    protected boolean isLegalMove(Point targetPosition, ChessBoard board) {
        return false;
    }

    @Override
    protected boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board) {
        return false;
    }
}
