public class Player {
    public static int health = 5;

    static int[] pos=new int[2];
    public static int[] initialisePos(){
        pos[0]=0;
        pos[1]=0;
        return pos;
    }
    public static int[] updatePos(String direction){
        if (direction=="North"){
            pos[0]++;
        } else if (direction=="East"){
            pos[1]++;
        } else if (direction=="South"){
            pos[0]--;
        } else if (direction=="West"){
            pos[1]--;
        }
    }
    public static void printPos(){
        System.out.print("Your coordinates are"+pos[0]+", "+pos[1]+".");
        System.out.println();
    }

}
