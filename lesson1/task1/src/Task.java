public class Task {
    public static void main(String[] args) {

        //references taken from https://www.geeksforgeeks.org/quick-sort-algorithm/ and https://builtin.com/articles/quicksort


        //creating array
        int[] arr = new int[]{5,3,21,56,34,12,0};
        //using the method
        quickSort(arr, 0, arr.length - 1);
        //printing sorted array
        for (int i : arr){
            System.out.print(i + " ");
        }

    }

    //both sources used a method to partition the array
    //inputs the array, the lowest index, and the highest index, chooses a pivot,
    // puts the elements that are lower than the pivot on the left side,
    // and the ones that are greater on the right side,
    //outputs the index of the smaller 
    public static int partition(int[] arr, int low, int high){
        //initializes the pivot which will be what the smaller and greater elements partition around
        int pivot = arr[high];
        //System.out.println("pivot: " + pivot);
        //the index of the smaller element
        int i = low - 1;
        //moves the elements that are smaller than the pivot to the left of it,
        // and the ones that are greater to the right
        for (int j = low; j <= high - 1; j ++){
            if (arr[j] < pivot){
                i ++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //will move the position of the pivot to the right spot, after
        // all the smaller elements, but before the larger ones
        int temp2 = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp2;

        //returns the position of the pivot
        return i + 1;
    }

    //inputs the array, the lowest and highest index, makes a partition and
    //will recursively quick sort each side of the partitions until all elements are sorted
    //no output
    public static void quickSort(int[] arr, int low, int high){
        //runs only while the lowest index in the array is smaller than the greater one
        //base case
        if (low < high){
            //for (int i = 0; i < arr.length - 1; i ++) {
                //System.out.print(arr[i] + " ");
           // }
            //creating the partition in the array
            int partIndex = partition(arr, low, high);
            //recursively calling on itself to make new partitions and sort the elements on the left side
            quickSort(arr, low, partIndex - 1);
            //recursively calling on itself to make new partitions and sort the elements on the right side
            quickSort(arr, partIndex + 1, high);
        }
    }

    //to test: have the array print after each partition and print
    // each pivot to check that  pivot is removed, the smaller elements are moved to the left side
    //and larger ones are moved to the right
    //pivot should be put back right in between both

    //test
    //5 3 21 56 34 12 pivot: 0
    //0 3 21 56 34 12 pivot: 5
    //0 3 5 56 34 12 pivot: 21
    //0 3 5 12 21 56 pivot: 34
    //0 3 5 12 21 34 56
}