package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(position.getRow(), position.getColumn());

        if (getColor() == Color.WHITE) {

            // acima
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Priemira jogada acima
            p.setValues(position.getRow() - 2, position.getColumn());
            if (getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //acima direita
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //acima esquerda
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //Movimento especial EnPassant
            if( position.getRow() == 3 ){
                Position left = new Position( position.getRow(), position.getColumn() - 1 );
                if( getBoard().piece( left.getRow() - 1, left.getColumn() ) == null ){
                    if( getBoard().positionExists( left ) && isThereOpponentPiece( left ) && getBoard().piece( left ) == chessMatch.getEnPassantVunerable()){
                        mat[left.getRow() - 1][left.getColumn() ] = true;
                    }
                }
                Position Rigth = new Position( position.getRow(), position.getColumn() + 1 );
                if( getBoard().piece( Rigth.getRow() - 1, Rigth.getColumn() ) == null ){
                    if( getBoard().positionExists( Rigth ) && isThereOpponentPiece( Rigth ) && getBoard().piece( Rigth ) == chessMatch.getEnPassantVunerable() ){
                        mat[Rigth.getRow() - 1][Rigth.getColumn()] = true;
                    }
                }
            }

        } else{

            //abaixo
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //primeira jogada abaixo
            p.setValues(position.getRow() + 2, position.getColumn());
            if ( getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //abaixo direita
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //abaixo esquerda
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //Movimento especial EnPassant
            if( p.getRow() == 4 ){
                Position left = new Position( position.getRow(), position.getColumn() - 1 );
                if( getBoard().piece( left.getRow() + 1, left.getColumn() ) == null ){
                    if( getBoard().positionExists( left ) && isThereOpponentPiece( left ) && getBoard().piece( left ) == chessMatch.getEnPassantVunerable() ){
                        mat[left.getRow() + 1 ][left.getColumn()] = true;
                    }
                }
                Position Rigth = new Position( position.getRow(), position.getColumn() + 1 );
                if( getBoard().positionExists( Rigth ) && isThereOpponentPiece( Rigth ) && getBoard().piece( Rigth ) == chessMatch.getEnPassantVunerable() ){
                    mat[Rigth.getRow() + 1][Rigth.getColumn()] = true;
                }
            }

        }

        return mat;

    }

    @Override
    public String toString() {
        return "P";
    }

}
