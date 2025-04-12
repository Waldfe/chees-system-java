package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

        public boolean[][] possibleMoves(){
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //acima
        p.setValues(position.getRow()-1, position.getColumn());
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo
        p.setValues(position.getRow()+1, position.getColumn());
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValues(position.getRow(), position.getColumn()+1);
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //esquerda
        p.setValues(position.getRow(), position.getColumn()-1);
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //acima direita
        p.setValues(position.getRow()-1, position.getColumn()+1);
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //acima esquerda
        p.setValues(position.getRow()-1, position.getColumn()-1);
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo direita
        p.setValues(position.getRow()+1, position.getColumn()+1);
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo esquerda
        p.setValues(position.getRow()+1, position.getColumn()-1);
        if( getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece( p )) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
        
    }
    
    @Override
    public String toString(){
        return "K";
    }

}
