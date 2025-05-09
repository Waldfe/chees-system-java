package application;

public class Program {
    public static void main(String[] args) {

        ChessGUI chess = new ChessGUI();

/*      executar no terminal

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        
        while ( !chessMatch.getCheckMate() ) { 
            try {
                
                UI.clearScreen();
                UI.printMatch( chessMatch, captured );

                System.out.println();
                System.out.print("Source: ");   
                ChessPosition source = UI.readChessPosition( sc );

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard( chessMatch.getPieces(), possibleMoves );

                System.out.println();
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition( sc );

                ChessPiece capturedPiece = chessMatch.performChessMove( source, target );

                if( capturedPiece != null ){
                    captured.add( capturedPiece );
                }

                if( chessMatch.getPromoted() != null ){
                    System.out.print("Insira a peça para promoção (B/N/R/Q): ");
                    String type = sc.nextLine();
                    while( !type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q") ){
                        System.out.print("Tipo de promoção é inválido, Insira a peça para promoção (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece( type );
                }

            } catch( ChessException e ){
                System.out.println( e.getMessage() );
                sc.nextLine();

            } catch( InputMismatchException e ){
                System.out.println( e.getMessage() );
                sc.nextLine();
            }
            
        }

        UI.clearScreen();
        UI.printMatch( chessMatch, captured );
        
*/ 

    }

}