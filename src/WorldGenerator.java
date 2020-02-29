public class WorldGenerator {

    // TODO Print the world, Generate terrain, make sure land isn't randomly in the sea

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
}
