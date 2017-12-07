import java.util.Random;

public class List {

    private int[] list;

    //if 1 then premade list for testing
    //if 2 generate a random list
    //if 3 copying a list
    public List(int length, int x) {
        if (x == 1){
            list = new int[]{5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 71};
        }else if (x == 2) {
            list = new int[length];
            generateList();
        }else if (x == 3) {
            list = new int[length];
        }
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

    public void setElement(int index, int value){
        list[index] = value;
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
