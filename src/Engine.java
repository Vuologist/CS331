import java.util.Arrays;

public class Engine {

    public Engine (int listLength){

        List original = new List(listLength);
        printArray(original.getList());
        medianOfMedians(original);
        printArray(original.getList());
    }

    private int[] medianOfMedians(List list){
        //sort each partition

        //if(list.getLength() > 1)

        int length = list.getLength();
        int start = 0;

        do {
            System.out.println("start is " + start);
            if (length - start >= 5) {
                sort5(list, start);
                start += 5;
            } else if (length - start == 4) {
                sort4(list, start);
                start += 4;
            } else if (length - start == 3) {
                sort3(list, start);
                start += 3;
            }else if (length - start == 2) {
                sort2(list, start);
                start += 2;
            } else
                start++;
        }while(start != length);

        return null;
    }

    //sort 2 elements in 1 comparison
    private void sort2(List partition, int x){
        //a,b
        if (partition.getElement(x) > partition.getElement(x+1))
            //a,b
            partition.swapElements(x, x+1);
    }

    //sort 3 elements in 3 comparisons
    private void sort3(List partition, int x){
        //a,b
        if(partition.getElement(x) > partition.getElement(x+1))
            //a,b
            partition.swapElements(x, x+1);
        //b,c
        if(partition.getElement(x+1) > partition.getElement(x+2))
            //b,c
            partition.swapElements(x+1,x+2);
        //a,b
        if (partition.getElement(x) > partition.getElement(x+1))
            //a,b
            partition.swapElements(x,x+1);
    }

    //sort 4 elements in 5 comparisons
    private void sort4(List partition, int x){
        //a,b
        if(partition.getElement(x) > partition.getElement(x+1))
            //a,b
            partition.swapElements(x,x+1);
        //c,d
        if(partition.getElement(x+2) > partition.getElement(x+3))
            //c,d
            partition.swapElements(x+2, x+3);
        //a,c
        if(partition.getElement(x) > partition.getElement(x+2))
            //a,c
            partition.swapElements(x, x+2);
        //b,d
        if(partition.getElement(x+1) > partition.getElement(x+3))
            //b,d
            partition.swapElements(x+1, x+3);
        //b,c
        if(partition.getElement(x+1) > partition.getElement(x+2))
            //b,c
            partition.swapElements(x+1,x+2);
    }

    //sort 5 elements in 7 comparisons; complete and fully tested
    private void sort5(List partition, int x){
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
    }


    //print array
    private void printArray(int[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

}
