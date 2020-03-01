public class Player {
    public int health = 5;

    int[] pos=new int[2];
    public int[] setPos(int row, int column){
        pos[0]=row;
        pos[1]=column;
        return pos;
    }
    public int[] updatePos(int[] pos, int direction){
        if (direction==1){
            pos[1]--;
        } else if (direction==2){
            pos[0]++;
        } else if (direction==3){
            pos[1]++;
        } else if (direction==4){
            pos[0]--;
        }
        return pos;
    }
    public void printPos(int[] pos){
        System.out.println();
        System.out.print("Your coordinates are "+pos[0]+", "+pos[1]+".");
        System.out.println();
    }

}
