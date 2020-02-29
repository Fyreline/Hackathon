import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Biomes {

    protected static final String plains = "P";
    protected static final String forest = "F";
    protected static final String mountain = "M";
    protected static final String sea = "S";
    protected static final String snowyPeak = "*";

    public static final double numOfBiomes = 4;

    private static double valueGen(double topLeft, double topRight, double bottomLeft, double bottomRight){
        int threeOrFour = 4;
        if (topLeft==0 || topRight==0 || bottomLeft==0 || bottomRight==0){
            threeOrFour=3;
        }
        double rndmAddSubtract = -1;
        if (Math.random()>0.5){
            rndmAddSubtract=1;
        }
        double value = ((topLeft+topRight+bottomLeft+bottomRight)/threeOrFour)+Math.random()*rndmAddSubtract*1.5;
        return value;
    }

    public static double[][] heightGenerator (int dim){
        double[][] data = new double[dim][dim];

        data[0][0] = Math.random()*9000;
        data[0][dim -1] = Math.random()*9000;
        data[dim -1][0] = Math.random()*9000;
        data[dim -1][dim -1] = Math.random()*9000;

        double h = 500.0;
        Random r = new Random();

        for(int sideLength = dim -1; sideLength >= 2; sideLength /=2, h/= 1.05){
            int halfSide = sideLength/2;
            //generate the new square values
            for(int x = 0; x< dim -1; x+=sideLength){
                for(int y = 0; y< dim -1; y+=sideLength){
                    //x, y is upper left corner of square
                    //calculate average of existing corners
                    double avg = data[x][y] + //top left
                            data[x+sideLength][y] +//top right
                            data[x][y+sideLength] + //lower left
                            data[x+sideLength][y+sideLength];//lower right
                    avg /= 4.0;
                    //center is average plus random offset
                    data[x+halfSide][y+halfSide] =
                            //We calculate random value in range of 2h
                            //and then subtract h so the end value is
                            //in the range (-h, +h)
                            avg + (r.nextDouble()*2*h) - h;
                }
            }

            //generate the diamond values
            //since the diamonds are staggered we only move x
            //by half side
            //NOTE: if the data shouldn't wrap then x < DATA_SIZE
            //to generate the far edge values
            for(int x = 0; x< dim -1; x+=halfSide){
                //and y is x offset by half a side, but moved by
                //the full side length
                //NOTE: if the data shouldn't wrap then y < DATA_SIZE
                //to generate the far edge values
                for(int y = (x+halfSide)%sideLength; y< dim -1; y+=sideLength){
                    //x, y is center of diamond
                    //note we must use mod  and add DATA_SIZE for subtraction
                    //so that we can wrap around the array to find the corners
                    double avg =
                            data[(x-halfSide+ dim)% dim][y] + //left of center
                                    data[(x+halfSide)% dim][y] + //right of center
                                    data[x][(y+halfSide)% dim] + //below center
                                    data[x][(y-halfSide+ dim)% dim]; //above center
                    avg /= 4.0;

                    //new value = average plus random offset
                    //We calculate random value in range of 2h
                    //and then subtract h so the end value is
                    //in the range (-h, +h)
                    avg = avg + (r.nextDouble()*2*h) - h;
                    //update value for center of diamond
                    data[x][y] = avg;

                    //wrap values on the edges, remove
                    //this and adjust loop condition above
                    //for non-wrapping values.
                    if(x == 0)  data[dim-1][y] = avg;
                    if(y == 0)  data[x][dim-1] = avg;
                }
            }
        }

//print out the data
        /**for(double[] row : data){
            for(double d : row){
                System.out.printf("%8.3f ", d);
            }
            System.out.println();
        }*/
        return data;
    }

    /**public static String startTileValue (double seed) {
        String rtnValue = sea;
        if (seed>0.75) {
            rtnValue = sea;
        } else if (seed < (1 / numOfBiomes)) {
            rtnValue = plains;
        } else if (seed < (2 / numOfBiomes)) {
            rtnValue = forest;
        } else if (seed < (3 / numOfBiomes)) {
            rtnValue = mountain;
        } else if (seed < (4 / numOfBiomes)) {
            rtnValue = sea;
        }
        return rtnValue;
    }*/

    public static String startTileValue (double seed) {
        String tileValue = sea;
        if (seed<50){
            tileValue=sea;
        } else if (seed<500){
            tileValue=plains;
        } else if (seed<1500){
            tileValue = forest;
        } else if (seed<2750){
            tileValue = mountain;
        } else if (seed<4500){
            tileValue = snowyPeak;
        }
        return tileValue;
    }

}
