package Chess.Game;

import java.awt.Point;

public class Knight extends Piece {
    protected Knight(Point point, boolean isWhite) {
        super(point, 'k', isWhite);
    }

    protected Knight(int x, int y, boolean isWhite) {
        super(x, y, 'k', isWhite);
    }

    // Checks the eight available moves given by knights
    @Override
    protected boolean isLegalMove(Point targetPosition, ChessBoard board) {
        boolean isSpaceEmpty = board.get(targetPosition) instanceof EmptyPiece;
        return isLegalMoveHelper(targetPosition) && isSpaceEmpty;
    }

    @Override
    protected boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board) {
        if (targetIsWhite == super.getIsWhite()) {
            return false;
        }
        boolean isSpaceEmpty = board.get(targetPosition) instanceof EmptyPiece;
        return this.isLegalMoveHelper(targetPosition) && !isSpaceEmpty;
    }

    private boolean isLegalMoveHelper(Point targetPosition) {
        boolean topLeft1 = super.getX() - 2 == targetPosition.x && super.getY() - 1 == targetPosition.y;
        boolean topLeft2 = super.getX() - 1 == targetPosition.x && super.getY() - 2 == targetPosition.y;
        boolean topRight1 = super.getX() - 1 == targetPosition.x && super.getY() + 2 == targetPosition.y;
        boolean topRight2 = super.getX() - 2 == targetPosition.x && super.getY() + 1 == targetPosition.y;
        boolean bottRight1 = super.getX() + 2 == targetPosition.x && super.getY() + 1 == targetPosition.y;
        boolean bottRight2 = super.getX() + 1 == targetPosition.x && super.getY() + 2 == targetPosition.y;
        boolean bottLeft1 = super.getX() + 2 == targetPosition.x && super.getY() - 1 == targetPosition.y;
        boolean bottLeft2 = super.getX() + 1 == targetPosition.x && super.getY() - 2 == targetPosition.y;
        return topLeft1 || topLeft2 || topRight1 || topRight2 || bottRight1 || bottRight2 || bottLeft1 || bottLeft2;
    }
}
