import java.util.Arrays;

public class Engine {

    public Engine (int listLength){

        List original = new List(listLength);

        printArray(original.getList());
        System.out.println();
        //swapElements(list, 0, 1);
        printArray(original.getList());
    }

    private int[] superMedian(int[] originalList){
        int[] tempArray = Arrays.copyOf(originalList, originalList.length);

        for(int i = 0; i < originalList.length; i+=5){
             //if(tempArray[i] > tempArray[i+1])
             //   swapElements(tempArray, i, i+1);

        }

        return null;
    }

    private void printArray(int[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

}
