package Chess.Game;

import java.awt.Point;

public class Pawn extends Piece {
    protected Pawn(Point point, boolean isWhite) {
        super(point, 'p', isWhite);
    }

    protected Pawn(int x, int y, boolean isWhite) {
        super(x, y, 'p', isWhite);
    }
    @Override
    protected boolean isLegalMove(Point targetPosition, ChessBoard board) {
        boolean isSpaceEmpty = board.get(targetPosition) instanceof EmptyPiece;
        if (super.getIsWhite()) {
            if ((super.getX() == targetPosition.x + 1) && super.getY() == targetPosition.y)
                return isSpaceEmpty;
        } else {
            if ((super.getX() == targetPosition.x - 1) && super.getY() == targetPosition.y)
                return isSpaceEmpty;
        }
        return false;
    }

    @Override
    protected boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board) {
        if (super.getIsWhite() == targetIsWhite) {
            return false;
        }
        boolean isSpaceEmpty = board.get(targetPosition) instanceof EmptyPiece;
        if (super.getIsWhite()) {
            if (((targetPosition.x + 1) == super.getX()) && ((targetPosition.y - 1) == super.getY() || (targetPosition.y + 1) == super.getY()) && !isSpaceEmpty)
                return true;
        } else {
            if ((targetPosition.x - 1) == super.getX() && ((targetPosition.y - 1) == super.getY() || (targetPosition.y + 1) == super.getY()) && !isSpaceEmpty)
                return true;
        }
        return false;
    }
}
