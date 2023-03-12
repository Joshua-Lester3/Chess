package Chess.Game;

import java.awt.*;
import java.util.Scanner;

/*  Object that drives the chess game.
 */
public class Driver {
    private ChessBoard board;

    public Driver() {
        Scanner scnr = new Scanner(System.in);
        boolean keepRunning = true;
        int option = 0;

        System.out.println("Welcome to Joshua Lester's Chess Game!");

        while (keepRunning) {
            try {
                System.out.print("Enter board option: ");
                option = Integer.parseInt(scnr.nextLine());
                keepRunning = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry.");
            }
        }
        board = new ChessBoard(option);
    }

    public void start() {
        Scanner scnr = new Scanner(System.in);
        String movingPieceString, moveString;
        boolean isPlaying = true;
        while (isPlaying) {
            board.print();
            boolean keepAsking = true;
            Point piecePos = new Point();
            Point targetPos = new Point();
            while (keepAsking) {
                System.out.print("Enter moving piece: ");
                movingPieceString = scnr.nextLine();
                System.out.print("Enter move: ");
                moveString = scnr.nextLine();
                try {
                    piecePos = this.readCoordinate(movingPieceString);
                    targetPos = this.readCoordinate(moveString);
                    keepAsking = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Coordinate out of bounds. Please enter again.");
                }
            }

            if (board.get(piecePos).isLegalMove(targetPos, this.isSpaceOccupied(targetPos))) {
                this.movePiece(piecePos, targetPos);
            } else if(board.get(piecePos).isLegalTakingMove(board.get(targetPos), this.isSpaceOccupied(targetPos))/*&& this.isSpaceOccupied(targetPos)*/) {
                this.movePiece(piecePos, targetPos);
            } else {
                System.out.println("Illegal move! Enter again.");
            }

            isPlaying = this.isStillPlaying();
        }
    }

    private boolean isSpaceOccupied(Point pos) {
        if (board.get(pos) instanceof EmptyPiece) {
            return false;
        }
        return true;
    }

    private void movePiece(Point piecePos, Point targetPos) {
        board.get(piecePos).setX(targetPos.x);
        board.get(piecePos).setY(targetPos.y);
        board.set(targetPos, board.get(piecePos));
        board.set(piecePos, new EmptyPiece(piecePos));
    }

    //TO DO -- Implement King and make sure it's not in checkmate in this method
    private boolean isStillPlaying() {
        return true;
    }

    private Point readCoordinate(String move) {
        char column = Character.toUpperCase(move.charAt(0));
        int y;
        int x = (-1) * (Integer.parseInt(move.charAt(1) + "") - 8);
        if (x < 0 || x > 7)
            throw new IllegalArgumentException("input out of bounds");
        switch (column) {
            case 'A':
                y = 0;
                break;
            case 'B':
                y = 1;
                break;
            case 'C':
                y = 2;
                break;
            case 'D':
                y = 3;
                break;
            case 'E':
                y = 4;
                break;
            case 'F':
                y = 5;
                break;
            case 'G':
                y = 6;
                break;
            case 'H':
                y = 7;
                break;
            default:
                throw new IllegalArgumentException("Letter not accepted");
        }
        return new Point(x, y);
    }
}
