public class DetailedBiome{
    public int[] tileCoord;
    public double height;
    public String biome;
    public int numMonsters;
    public int[] monsterCoords;
    private int[] rockLocations;

    private String groundType(String biome){
        String ground = "g";
        if (biome==Biomes.plains){
            ground="g";
        } else if (biome==Biomes.sea){
            ground="w"; //for water idiot
        } else if (biome==Biomes.forest){
            ground="g";
        } else if (biome==Biomes.mountain){
            ground="r"; //rock
        } else if (biome==Biomes.snowyPeak){
            ground="s";
        }
        return ground;
    }

    private int[] spawnRocks(String biome){
        int[] rockLocations = new int[12];
        int numRocks;
        if (biome.equals(Biomes.mountain) || biome.equals(Biomes.snowyPeak)){
            numRocks = Math.max( (int) (Math.random()*9), (int) (Math.random()*9));
        } else if (biome.equals(Biomes.sea)){
            numRocks = Math.min((int) (Math.random() * 3), (int) (Math.random() * 3));
        } else {
            numRocks = Math.min((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        for (int i=0; i<numRocks; i+=2){
            int xCoord= (int) (Math.random()*6);
            int yCoord= (int) (Math.random()*6);
            rockLocations[i]=xCoord;
            rockLocations[i+1]=yCoord;
        }
        return rockLocations;
    }

    private void spaceValue(String ground){
        boolean printRock = false;
        int[] rockLocations=spawnRocks(biome);
        for (int i=0; i<6; i+=1){
            for (int j=0; j<6; j+=1){
                for (int k=0; k<rockLocations.length; k+=2){
                    if (rockLocations[k]==i && rockLocations[k+1]==j){
                        printRock = true;
                    }
                }
                if (printRock){
                    System.out.print("R");
                    printRock=false;
                } else {
                    System.out.print(".");
                }
            } System.out.println();
        }
    }


    public void printBiome(){
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                spaceValue(groundType(biome));
            }
        }

    }

}
