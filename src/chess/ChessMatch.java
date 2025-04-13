package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rock;
import java.util.ArrayList;
import java.util.List;


public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece promoted;

    private Board board;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch(){
        board = new Board( 8, 8 );
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn(){
        return turn;
    }

    public Color getcurrentPlayer(){
        return currentPlayer;
    }

    private void nextTurn() {
        turn++;
        if( turn%2 == 0 ){
            currentPlayer = Color.BLACK;
        } else{
            currentPlayer =  Color.WHITE;
        }
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for( int i=0; i<board.getRows(); i++ ){
            for( int j=0; j<board.getColumns(); j++ ){
                mat[i][j] = (ChessPiece) board.piece( i, j );
            }
        }
        return mat;
    }   
    
    public boolean[][] possibleMoves( ChessPosition sourcePosition ){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove( ChessPosition sourcePosition, ChessPosition targetPosition ){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition( source );
        validateTargetPosition( source, target );
        Piece capturedPiece = makeMove( source, target );
        nextTurn();
        return (ChessPiece)capturedPiece;
    }
    public Piece makeMove( Position source, Position target ){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if( capturedPiece != null ){
            piecesOnTheBoard.remove( capturedPiece );
            capturedPieces.add( capturedPiece );
        }

        return capturedPiece;

    }

    public void validateSourcePosition( Position position ){
        if( !board.thereIsAPiece( position ) ){
            throw new ChessException("Nao existe peca na posicao de origem");
        }
        if( getcurrentPlayer() != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("Essa peça não é sua");
            
        }
        if(!board.piece(position).IsThereAnyPosibleMove()){
            throw new ChessException("Nao existe movimentos possiveis para essa peca");
        }
    }

    public void validateTargetPosition( Position source, Position target ){
        if(!board.piece(source).possibleMove(target)){
            throw new ChessException("A posição de destino é inválida");
        }
    }

    private void placeNewPiece( char column, int row, ChessPiece piece ){
        board.placePiece( piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add( piece );
    }

    private void initialSetup() {

        placeNewPiece('e', 8, new Rock(board, Color.BLACK));
        placeNewPiece('e', 1, new Rock(board, Color.WHITE));
        placeNewPiece('c', 1, new Rock(board, Color.WHITE));
        placeNewPiece('c', 2, new Rock(board, Color.WHITE));
        placeNewPiece('d', 2, new Rock(board, Color.WHITE));
        placeNewPiece('e', 2, new Rock(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rock(board, Color.BLACK));
        placeNewPiece('c', 8, new Rock(board, Color.BLACK));
        placeNewPiece('d', 7, new Rock(board, Color.BLACK));
        placeNewPiece('e', 7, new Rock(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

    }

}
