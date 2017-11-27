import java.util.Random;

public class List {

    private int[] list;

    public List (int length){
        list = new int[length];
        generateList();
    }

    public int[] getList(){
        return list;
    }

    private void generateList(){
        Random rand = new Random();
        for(int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(100);
        }
    }

    private void swapElements(int x, int y){
        int holder = list[y];
        list[y] = list[x];
        list[x] = holder;
    }

}
