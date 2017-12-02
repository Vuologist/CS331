import java.util.Random;

public class List {

    private int[] list = new int[]{5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 71};

    public List(){

    }

    public List (int length){
        //list = new int[length];
        //generateList();
    }

    public int getLength(){
        return list.length;
    }

    public int getElement(int i){
        return list[i];
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

    public void swapElements(int x, int y){
        int holder = list[y];
        list[y] = list[x];
        list[x] = holder;
    }

}
