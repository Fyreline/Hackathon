public class MainProgram {

    private static final int alterDimension = 8; //2^n+1 for diamond

    public static void main(String[] args){
        int dim = (int) Math.pow(2, alterDimension)+1;
        System.out.println(dim);

        double[][] heightMap = WorldGenerator.heightMap(dim);
        for (int i=0; i<dim; i++){
            for (int j=0; j<dim; j++){
                //System.out.println(heightMap[i][j]);
            }
        }
        WorldGenerator.generateStartLand(dim, heightMap);

    }
}
