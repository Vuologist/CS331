
public class EngineMedian {

    private List original;
    private List medianCopy;

    public EngineMedian(int listLength){
        original = new List(listLength, 1);
        medianCopy = new List(listLength, 3);
        copyList(original, medianCopy, 0, original.getLength());


        printArray(original.getList());
        printArray(medianCopy.getList());
        System.out.println();

        int median1 = medianOfMedians(medianCopy, (medianCopy.getLength()/2)-1);
        int median2 = medianOfMedians(medianCopy, (medianCopy.getLength()/2));
        System.out.println(median1);
        System.out.println(median2);
        System.out.println(elementReturn(median1,median2));
    }

    private double elementReturn(int median1, int median2){
        return (median1+median2)/2.0;
    }

    //creates new list of medians and then finds the specified element
    private int medianOfMedians(List list, int element){
        int listLength = (list.getLength()/5);
        //account for last part of list that may be less than 5 elements
        if(list.getLength()%5 != 0){
            listLength++;
        }

        List medians = new List(listLength,3);
        int offset = 0;
        for(int i=0; i<medians.getLength();i++){

            if(medians.getLength()-offset >= 5){
                medians.setElement(i, list.getElement(offset+2));
                offset+=5;
            }else
                //account for median list being less than 5
                medians.setElement(i, list.getElement((medians.getLength()-offset)/2));
        }
        //printArray(medians.getList());

        int pivot;
        if(medians.getLength() <=5) {
            sortController(medians);
            //printArray(medians.getList());
            pivot = medians.getElement(medians.getLength()/2);
            //System.out.println("this is the piv at 47: " + pivot);
        }else{
            pivot = medianOfMedians(medians, medians.getLength()/2);
        }

        int lessThanPivot = 0;
        for(int i=0; i<list.getLength();i++){
            if(list.getElement(i) < pivot)
                lessThanPivot++;
        }

        List lowHalf = new List(lessThanPivot,3);
        //System.out.println(lessThanPivot);
        List highHalf = new List(list.getLength()-lessThanPivot-1, 3);
        //System.out.println(list.getLength()-lessThanPivot-1);
        int listIndex = 0;
        int lowHalfIndex = 0;
        int highHalfIndex = 0;
        do{
            if(list.getElement(listIndex) == pivot){
                listIndex++;
                continue;
            }else if(list.getElement(listIndex) < pivot) {
                lowHalf.setElement(lowHalfIndex, list.getElement(listIndex));
                lowHalfIndex++;
            }else {
                highHalf.setElement(highHalfIndex, list.getElement(listIndex));
                highHalfIndex++;
            }
            listIndex++;
        }while (listIndex < list.getLength());

        //System.out.println("printing lowhalf and highhalf");
        //printArray(lowHalf.getList());
        //System.out.println();
        //printArray(highHalf.getList());

        int lengthOfLowHalf = lowHalf.getLength();
        if(element < lengthOfLowHalf)
            return medianOfMedians(lowHalf, element);
        else if (element > lengthOfLowHalf)
            return medianOfMedians(highHalf, element-lengthOfLowHalf-1);
        else
            return pivot;
    }

    //method used to decide which sort method to use
    private void sortController(List list){
        //sort each partition in place
        if(list.getLength() > 1) {
            int length = list.getLength();
            int start = 0;
            do {
                //System.out.println("start is " + start);
                if (length - start >= 5) {
                    sort5(list, start);
                    start += 5;
                } else if (length - start == 4) {
                    sort4(list, start);
                    start += 4;
                } else if (length - start == 3) {
                    sort3(list, start);
                    start += 3;
                } else if (length - start == 2) {
                    sort2(list, start);
                    start += 2;
                } else
                    start++;
            } while (start != length);
        }
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

    //copy mirror copy of original array into destinationArray
    //or used to copy for lowHalf or highHalf
    private void copyList(List source, List destinationList, int start, int end){
        for(int i=start; i<end;i++){
            destinationList.setElement(i,source.getElement(i));
        }
    }

    //print array
    private void printArray(int[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }
}
