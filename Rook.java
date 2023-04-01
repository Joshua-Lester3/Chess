package Chess.Game;

import java.awt.Point;

public class Rook extends Piece {
    protected Rook(int x, int y, boolean isWhite) {
        super(x, y, 'R', isWhite);
    }

    protected Rook(Point position, boolean isWhite) {
        super(position, 'R', isWhite);
    }

    //TO DO
    @Override
    protected boolean isLegalMove(Point targetPosition, ChessBoard board) {
        boolean isSpaceEmpty = board.get(targetPosition) instanceof EmptyPiece;
        return isLegalMoveHelper(targetPosition, board) && isSpaceEmpty;
    }

    //TO DO
    @Override
    protected boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board) {
        if (super.getIsWhite() == targetIsWhite) {
            return false;
        }
        boolean isSpaceEmpty = board.get(targetPosition) instanceof EmptyPiece;
        return isLegalMoveHelper(targetPosition, board) && !isSpaceEmpty;
    }

    private boolean isLegalMoveHelper(Point targetPosition, ChessBoard board) {
        int thisX = super.getX();
        int thisY = super.getY();
        int targetX = targetPosition.x;
        int targetY = targetPosition.y;
        if ((thisX == targetX && thisY == targetY) || (thisX != targetX && thisY != targetY))
            return false;
        //forward (thisX > targetX && thisY == targetY)
        if (targetX < thisX) {
            for (int i = thisX - 1; i >= targetX; i--) {
                if (!(board.get(new Point(i, targetY)) instanceof EmptyPiece)) {
                    return false;
                }
            }
        }
        //backward
        else if (targetX > thisX) {
            for (int i = thisX + 1; i <= targetX; i++) {
                if (!(board.get(new Point(i, targetY)) instanceof EmptyPiece)) {
                    return false;
                }
            }
        }
        //left
        else if (targetY < thisY) {
            for (int i = thisY - 1; i >= targetY; i--) {
                if (!(board.get(new Point(targetX, i)) instanceof EmptyPiece)) {
                    return false;
                }
            }
        }
        //right
        else { //targetY > thisY
            for (int i = thisY + 1; i <= targetY; i++) {
                if (!(board.get(new Point(targetX, i)) instanceof EmptyPiece)) {
                    return false;
                }
            }
        }
        return true;
    }
}
