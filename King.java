package Chess.Game;

import java.awt.Point;

public class King extends Piece {

    protected King(int x, int y, boolean isWhite) {
        super(x, y, 'K', isWhite);
    }

    protected King(Point position, boolean isWhite) {
        super(position, 'K', isWhite);
    }

    @Override
    protected boolean isLegalMove(Point targetPosition, ChessBoard board) {
        boolean isSpaceOccupied = !(board.get(targetPosition) instanceof EmptyPiece);
        return this.isLegalMoveHelper(targetPosition) && !isSpaceOccupied;
    }

    @Override
    protected boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board) {
        if (super.getIsWhite() == targetIsWhite) {
            return false;
        }
        boolean isSpaceOccupied = !(board.get(targetPosition) instanceof EmptyPiece);
        return this.isLegalMoveHelper(targetPosition) && isSpaceOccupied;
    }

    private boolean isLegalMoveHelper(Point targetPosition) {
        if (super.getX() == targetPosition.x && super.getY() == targetPosition.y) {
            return false;
        }
        boolean isXLegal = super.getX() + 1 == targetPosition.x || super.getX() - 1 == targetPosition.x || super.getX() == targetPosition.x;
        boolean isYLegal = super.getY() + 1 == targetPosition.y || super.getY() - 1 == targetPosition.y || super.getY() == targetPosition.y;
        return isXLegal && isYLegal;
    }
}
