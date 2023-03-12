package Chess.Game;

import java.awt.*;

public class Knight extends Piece {
    protected Knight(Point point, boolean isWhite) {
        super(point, 'k', isWhite);
    }

    protected Knight(int x, int y, boolean isWhite) {
        super(x, y, 'k', isWhite);
    }

    // Checks the eight available moves given by knights. We can assume the point entered is
    // valid because Driver makes sure it is
    @Override
    protected boolean isLegalMove(Point targetPos, boolean isSpaceOccupied) {
        boolean topLeft1 = super.getX() - 2 == targetPos.x && super.getY() - 1 == targetPos.y;
        boolean topLeft2 = super.getX() - 1 == targetPos.x && super.getY() - 2 == targetPos.y;
        boolean topRight1 = super.getX() - 1 == targetPos.x && super.getY() + 2 == targetPos.y;
        boolean topRight2 = super.getX() - 2 == targetPos.x && super.getY() + 1 == targetPos.y;
        boolean bottRight1 = super.getX() + 2 == targetPos.x && super.getY() + 1 == targetPos.y;
        boolean bottRight2 = super.getX() + 1 == targetPos.x && super.getY() + 2 == targetPos.y;
        boolean bottLeft1 = super.getX() + 2 == targetPos.x && super.getY() - 1 == targetPos.y;
        boolean bottLeft2 = super.getX() + 1 == targetPos.x && super.getY() - 2 == targetPos.y;
        return topLeft1 || topLeft2 || topRight1 || topRight2 || bottRight1 || bottRight2 || bottLeft1 || bottLeft2;
    }

    @Override
    protected boolean isLegalTakingMove(Piece targetPos, boolean isSpaceOccupied) {
        if (targetPos.getIsWhite() == super.getIsWhite()) {
            return false;
        }
        return this.isLegalMove(new Point(targetPos.getX(),targetPos.getY()), isSpaceOccupied) && isSpaceOccupied;
    }
}
