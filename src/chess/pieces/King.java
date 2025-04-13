package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessmatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessmatch = chessMatch;
    }

    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //acima
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //acima direita
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //acima esquerda
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo direita
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo esquerda
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Movimento especial rook
        if ( getMoveCount() == 0 && !chessmatch.getCheck() ) {

            //Rook a direita
            Position posT1 = new Position( position.getRow(), position.getColumn() + 3 );
            if ( testRookCastling(posT1) ){
                Position p1 = new Position( position.getRow(), position.getColumn() + 1 );
                Position p2 = new Position( position.getRow(), position.getColumn() + 2 );
                if( getBoard().piece(p1) == null && getBoard().piece(p2) == null ){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            //Rook a esquerda
            Position posT2 = new Position( position.getRow(), position.getColumn() - 4 );
            if ( testRookCastling(posT2) ){
                Position p1 = new Position( position.getRow(), position.getColumn() - 1 );
                Position p2 = new Position( position.getRow(), position.getColumn() - 2 );
                Position p3 = new Position( position.getRow(), position.getColumn() - 3 );
                if( getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null ){
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }

        }

        return mat;

    }

    private boolean testRookCastling(Position position) {

        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

    }

    @Override
    public String toString() {
        return "K";
    }

}
