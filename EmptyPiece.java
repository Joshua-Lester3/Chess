package Chess.Game;

import java.awt.*;

public class EmptyPiece extends Piece {
    protected EmptyPiece(Point point) {
        super(point, '_', false);
    }

    protected EmptyPiece(int x, int y) {
        super(x, y, '_', false);
    }

    //returns false because you can't move an empty piece, or else the user will be able to move it
    @Override
    protected boolean isLegalMove(Point movement, boolean isSpaceOccupied) {
        return false;
    }

    @Override
    protected boolean isLegalTakingMove(Piece pos, boolean isSpaceOccupied) {
        return false;
    }
}
