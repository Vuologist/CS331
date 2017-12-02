import java.util.Arrays;

public class Engine {

    public Engine (int listLength){

        List original = new List(listLength);
        printArray(original.getList());
        medianOfMedians(original);
        printArray(original.getList());
    }

    private int[] medianOfMedians(List originalList){
        //sort each partition
        for(int i = 0; i < originalList.getLength(); i+=5){
            System.out.println("first run");
            sort5(originalList, i);

            printArray(originalList.getList());
        }

        return null;
    }
    //blalablablablablablablabl
    //sort for 5 elements; complete and fully tested
    private int[] sort5(List partition, int x){
        //a, b
        if(partition.getElement(x) > partition.getElement(x+1))
            //a, b
            partition.swapElements(x,x+1);
        //c, d
        if(partition.getElement(x+2) > partition.getElement(x+3))
            //c,d
            partition.swapElements(x+2,x+3);
        //b, d
        if(partition.getElement(x+1) > partition.getElement(x+3))
            //b, d
            partition.swapElements(x+1,x+3);
        //e, b
        if(partition.getElement(x+4) < partition.getElement(x+1)){
            //e, a
            if(partition.getElement(x+4) < partition.getElement(x)){
                //a, e
                partition.swapElements(x, x+4);
                //d, e
                partition.swapElements(x+3, x+4);
            } else {
                //b, e
                partition.swapElements(x+1, x+4);
                //d, e
                partition.swapElements(x+3, x+4);
            }
        } else {
            //e, d
            if(partition.getElement(x+4) < partition.getElement(x+3))
                //d, e
                partition.swapElements(x+3,x+4);
        }
        //c, b
        if(partition.getElement(x+2) < partition.getElement(x+1)){
            //c, a
            if (partition.getElement(x+2) < partition.getElement(x)){
                //a,c
                partition.swapElements(x, x+2);
                //b, c
                partition.swapElements(x+1, x+2);
            }else{
                //c, b
                partition.swapElements(x+2, x+1);
            }
        } else {
            //c, d
            if(partition.getElement(x+2) > partition.getElement(x+3)){
                //d, c
                partition.swapElements(x+3, x+2);
            }
        }
        return null;
    }



    private void printArray(int[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

}
