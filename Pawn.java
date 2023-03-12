package Chess.Game;

import java.awt.*;

public class Pawn extends Piece {
    protected Pawn(Point point, boolean isWhite) {
        super(point, 'P', isWhite);
    }

    protected Pawn(int x, int y, boolean isWhite) {
        super(x, y, 'P', isWhite);
    }
    @Override
    protected boolean isLegalMove(Point targetPos, boolean isSpaceOccupied) {
        if (super.getIsWhite()) {
            if ((super.getX() == targetPos.x + 1) && super.getY() == targetPos.y && !isSpaceOccupied)
                return true;
        } else {
            if ((super.getX() == targetPos.x - 1) && super.getY() == targetPos.y && !isSpaceOccupied)
                return true;
        }
        return false;
    }

    @Override
    protected boolean isLegalTakingMove(Piece target, boolean isSpaceOccupied) {
        if (super.getIsWhite()) {
            if ((target.getX() + 1) == super.getX() && ((target.getY() - 1) == super.getY() || (target.getY() + 1) == super.getY()) && isSpaceOccupied && !target.getIsWhite())
                return true;
        } else {
            if ((target.getX() - 1) == super.getX() && ((target.getY() - 1) == super.getY() || (target.getY() + 1) == super.getY()) && isSpaceOccupied && target.getIsWhite())
                return true;
        }
        return false;
    }
}
