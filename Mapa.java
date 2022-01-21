import java.util.Scanner;
class Mapa{
    
    static int 
    rowPositionPlayer, 
    columnPositionPlayer,
    maxLimitRow, maxLimitColumn,
    minLimitRow, minLimitColumn;
    
    static boolean play = true;

    static String inputUser;

    static Scanner scanner;

    static boolean existChickens = false;

    static int acumulateChickens = 0;
    
    public static void main(String[] args) {

        int chickens [][] = {
            {3,2},
            {1,7},
            {6,7},
            {4,2},
            {2,3},
            {1,4},
        };

        rowPositionPlayer = 0;
        columnPositionPlayer = 0;
        
        minLimitRow = 0;
        minLimitColumn = 0;
        
        maxLimitRow = floor.length - 1;
        maxLimitColumn = floor[0].length - 1;

        scanner = new Scanner(System.in);

        existChickens = false;

        acumulateChickens=0;

        int countOfChickens = chickens.length;

        do{

            printBoard(rowPositionPlayer, columnPositionPlayer, chickens, countOfChickens);
            inputUser = preguntaMovimiento(countOfChickens);
            
            if(inputUser.equals("f")){play=false;}
            if(inputUser.equals("w")){goToUp();}
            if(inputUser.equals("a")){goToLeft();}
            if(inputUser.equals("d")){goToRight();}
            if(inputUser.equals("s")){goToDown();}

        } while (play);

        
    }

    public static void printBoard(int playerRowPosition, int playerColumnPosition, int[][] chickens, int countOfChickens) {
        
        for (int positionRow = 0; positionRow < floor.length; positionRow++){
            
            System.out.print("|");

            for (int positionColumn = 0; positionColumn < floor[0].length; positionColumn++){

                existChickens = false;

                //print chickens
                // for(int chickenCount = 0; chickenCount < countOfChickens; chickenCount++){
                //     if(chickens[chickenCount][0] == positionRow && chickens[chickenCount][1] == positionColumn){
                //         System.out.print("  ^"+chickenCount+"^  ");
                //         existChickens = true;
                //         break;
                //     } 
                // }

                if(!existChickens){
                    
                    if( (positionRow == playerRowPosition) && (positionColumn == playerColumnPosition) ){
                        System.out.print("  ^O^  ");
                    }else if(floor[positionRow][positionColumn] == 3){
                        System.out.print("  [0]  ");
                    }
                    else {
                        
                        System.out.print("   O   ");
                    
                    }

                }
            }   
            
            System.out.println("|");
        }

        //chicken movement
        for(int chickenCount = 0; chickenCount <chickens.length; chickenCount++){
            
            int dado = (int)(Math.random() * 4) + 1;
            if(dado == 1) {
                //norte - arriba
                chickens[chickenCount][1] = chickens[chickenCount][1] - 1;
              
            } 
            else
            if(dado == 2) {
                //sur - abajo
                chickens[chickenCount][1] = chickens[chickenCount][1] + 1;
            } 
            else
            if(dado == 3) {
                //este - derecha
                chickens[chickenCount][0] = chickens[chickenCount][0] + 1;
            } 
            else
            if(dado == 4) {
                //oeste - izquierda
                chickens[chickenCount][0] = chickens[chickenCount][0] - 1;
            } 
        }
    
    }

    public static String preguntaMovimiento(int chickens){
        System.out.println ("| COMANDOS: 'wasd' moverse / f Fin");
        System.out.println("--------------------------------");
        System.out.println("Gallinas "+chickens);

		return scanner.nextLine();
	}
    
    public static void goToUp(){
        if( (rowPositionPlayer > minLimitRow) && (floor[rowPositionPlayer-1][columnPositionPlayer]%2==0) ){
            rowPositionPlayer = rowPositionPlayer-1;
        }
    }
    public static void goToDown(){
        if( (rowPositionPlayer < maxLimitRow) && (floor[rowPositionPlayer+1][columnPositionPlayer]%2==0)  ){
            rowPositionPlayer = rowPositionPlayer+1;
        }
    }
    public static void goToRight(){
        if( columnPositionPlayer < maxLimitColumn && (floor[rowPositionPlayer][columnPositionPlayer+1]%2==0)  ){
            columnPositionPlayer = columnPositionPlayer+1;
        }
    }
    public static void goToLeft(){
        if( columnPositionPlayer > minLimitColumn && (floor[rowPositionPlayer][columnPositionPlayer-1]%2==0)){
            columnPositionPlayer = columnPositionPlayer-1;
        }
    }

    static int[][] floor = {
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,3,3,3,0},
        {0,0,0,0,0,0,0,0,0,3,3,3,0},
        {0,0,0,0,0,0,0,0,0,3,3,3,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0},
	};

    
}