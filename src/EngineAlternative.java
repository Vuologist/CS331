
public class EngineAlternative {

    private List original;
    private List alternativeCopy;

    public EngineAlternative(int listLength){
        original = new List(listLength, 1);
        alternativeCopy = new List(listLength, 3);
        copyListFromOriginal(alternativeCopy);

        printArray(original.getList());
        printArray(alternativeCopy.getList());
        System.out.println();

        sortAlternative(alternativeCopy.getList(),0,alternativeCopy.getLength()-1);
        printArray(alternativeCopy.getList());



    }

    //copy mirror copy of original array into destinationArray
    private void copyListFromOriginal(List destinationList){
        for(int i=0; i<original.getLength();i++){
            destinationList.setElement(i,original.getElement(i));
        }
    }

    //code sourced from geeksforgeeks.org
    private void alternativeMergeSort(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    //code sourced from geeksforgeeks.org
    private void sortAlternative(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;
            // sortAlternative first and second halves
            sortAlternative(arr, l, m);
            sortAlternative(arr , m+1, r);
            // Merge the sorted halves
            alternativeMergeSort(arr, l, m, r);
        }
    }

    private double median(){


        return 0.0;
    }

    //print array
    private void printArray(int[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }
}
