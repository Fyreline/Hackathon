import java.util.Scanner;

public class MainProgram {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int alterDimension = 4; //2^n+1 for diamond

    private static int menuChoices(Scanner scanner){
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("1. View World Map");
        System.out.println("2. Local View");
        System.out.println("3. Print Current Coords");
        System.out.println("4. End The Miserable Simulation We Call Life");
        System.out.println();
        System.out.print("Input: ");
        boolean valid = false;

        int input = scanner.nextInt();
        if (input>0 && input<5){
            valid = true;
        }
        while (!valid){
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("Please re-enter a value between 1-4");
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("1. View World Map");
            System.out.println("2. Local View");
            System.out.println("3. Print Current Coords");
            System.out.println("4. End The Miserable Simulation We Call Life");
            System.out.println();
            System.out.print("Input: ");
        }
        return input;
    }

    private static void gameLoop(int dim, String[][] world){
        Player player = new Player();
        boolean startXCoordValid = false;
        boolean startYCoordValid = false;
        while (!startXCoordValid || !startYCoordValid){
            System.out.println(dim);
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("Please enter the xCoord you would like to begin your adventure: ");
            int xCoord = SCANNER.nextInt();
            if (xCoord>0 && xCoord<=dim) startXCoordValid=true;
            while (!startXCoordValid){
                System.out.println();
                System.out.println("Please enter a valid xCoord: ");
                xCoord = SCANNER.nextInt();
                if (xCoord>0 && xCoord<=dim) startXCoordValid=true;
            }
            System.out.println();
            System.out.println("Please enter the yCoord you would like to begin your adventure: ");
            int yCoord = SCANNER.nextInt();
            if (yCoord>0 && yCoord<=dim) startYCoordValid=true;
            while (!startYCoordValid){
                System.out.println();
                System.out.println("Please enter a valid yCoord: ");
                yCoord = SCANNER.nextInt();
                if (yCoord>0 && yCoord<=dim) startYCoordValid=true;
            }
            player.setPos(xCoord,yCoord);
        }

        boolean exit=false;

        while (!exit){
            int choice = menuChoices(SCANNER);
            if (choice==1)WorldGenerator.displayBoard(world, dim);
            else if (choice==2);
            else if (choice==3)player.printPos(player.pos);
            else if (choice==4)exit=true;
        }
    }

    public static void main(String[] args){
        int dim = (int) Math.pow(2, alterDimension)+1;
        //System.out.println(dim);
        double[][] heightMap = WorldGenerator.heightMap(dim);
        for (int i=0; i<dim; i++){
            for (int j=0; j<dim; j++){
                //System.out.println(heightMap[i][j]);
            }
        }
        String[][] world = WorldGenerator.generateStartLand(dim, heightMap);

        gameLoop(dim, world);

        SCANNER.close();
    }
}
