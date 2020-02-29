public class WorldGenerator {

    public static double[][] heightMap(int dim){
        double[][] HeightMap=Biomes.heightGenerator(dim);
        return HeightMap;
    }

    public static String[][] generateStartLand (int dim, double[][] heightMap){
        double[][] tmpHeightArr = heightMap;
        String[][] tileValue = new String[dim][dim];
        for (int i=0; i<dim; i++){
            for (int j=0; j<dim; j++){
                tileValue[i][j]=Biomes.startTileValue(tmpHeightArr[i][j]);
                System.out.print(tileValue[i][j]);
            }
            System.out.println();
        }
        return tileValue;
    }

    private static void boardPrinter(int dimension, String[][] boardLayout){
        System.out.println();
        for (int i=0; i<dimension; i+=1){
            System.out.print(" ");
            //Loops each square in the row
            for (int c=0; c<dimension; c+=1){
                System.out.print(boardLayout[i][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void displayBoard(String[][] boardLayout, int dimension) {
            boardPrinter(dimension, boardLayout);
    }
}
