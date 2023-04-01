package Chess.Game;

import java.awt.Point;

public abstract class Piece {
    public final char type;
    private int x;
    private int y;
    private boolean isWhite;

    protected Piece(Point position, char type, boolean isWhite) { //SHOULD I LEAVE OUT THE isWhite FOR THE SUBCLASSES TO DEAL WITH IN THEIR CONSTRUCTORS?
        this(position.x, position.y, type, isWhite);
    }

    protected Piece (int x, int y, char type, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.isWhite = isWhite;
    }

    protected boolean getIsWhite() {
        return this.isWhite;
    }

    protected char pieceToChar() {
        return type;
    }

    protected int getX() {
        return this.x;
    }

    protected int getY() {
        return this.y;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected abstract boolean isLegalMove(Point targetPosition, ChessBoard board); //SHOULD THIS BE PASSED A Point OBJECT OR A Piece OBJECT?

    protected abstract boolean isLegalTakingMove(Point targetPosition, boolean targetIsWhite, ChessBoard board); //SAME WITH HERE WHICH SHOULD I DO?
}
