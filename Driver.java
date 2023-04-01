package Chess.Game;

import java.awt.Point;
import java.util.Scanner;
import java.util.ArrayList;

/*  Object that drives the chess game.
 */
public class Driver {
    private ChessBoard board;

    public Driver() {
        Scanner scnr = new Scanner(System.in);
        boolean keepRunning = true;
        int option = 0;

        System.out.println("Welcome to Joshua Lester's Chess Game!");
        System.out.println("Press enter to continue:");
        scnr.nextLine();

//        while (keepRunning) {
//            try {
//                System.out.print("Enter board option: ");
//                option = Integer.parseInt(scnr.nextLine());
//                keepRunning = false;
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid entry.");
//            }
//        }
//        board = new ChessBoard(option);
        board = new ChessBoard();
    }

    public void start() {
        Scanner scnr = new Scanner(System.in);
        String movingPieceString, moveString;
        boolean isPlaying = true;
        while (isPlaying) {
            board.print();
            boolean keepAsking = true;
            Point piecePosition = new Point();
            Point targetPosition = new Point();
            while (keepAsking) {
                System.out.print("Enter moving piece: ");
                movingPieceString = scnr.nextLine();
                System.out.print("Enter move: ");
                moveString = scnr.nextLine();
                try {
                    piecePosition = this.readCoordinate(movingPieceString);
                    targetPosition = this.readCoordinate(moveString);
                    keepAsking = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Coordinate out of bounds. Please enter again.");
                }
            }
            Piece movingPiece = board.get(piecePosition);
            Piece targetPiece = board.get(targetPosition);
            boolean putsKingInCheck = false;

            if (movingPiece instanceof King)
                putsKingInCheck = putsKingInCheck(movingPiece, targetPosition);

            if (putsKingInCheck) {
                System.out.println("Move puts king in check! Enter again.");
            } else if (movingPiece.isLegalMove(targetPosition, board)) {
                this.movePiece(piecePosition, targetPosition);
            } else if(movingPiece.isLegalTakingMove(targetPosition, targetPiece.getIsWhite(), board)) {
                this.movePiece(piecePosition, targetPosition);
            } else {
                System.out.println("Illegal move! Enter again.");
            }

            isPlaying = this.isStillPlaying();
        }
    }

    private boolean putsKingInCheck(Piece king, Point targetPosition) {
        ArrayList<Piece> pieces;
        if (king.getIsWhite())
            pieces = board.blackPieces;
        else
            pieces = board.whitePieces;
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).isLegalTakingMove(targetPosition, king.getIsWhite(), board)) {
                return true;
            }
        }
        return false;

    }

    private void movePiece(Point piecePosition, Point targetPosition) {
        board.get(piecePosition).setX(targetPosition.x);
        board.get(piecePosition).setY(targetPosition.y);
        board.set(targetPosition, board.get(piecePosition));
        board.set(piecePosition, new EmptyPiece(piecePosition));
    }

    //TO DO -- Implement King and make sure it's not in checkmate in this method
    //Make sure king has no available moves AND other pieces cannot block incoming check
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
