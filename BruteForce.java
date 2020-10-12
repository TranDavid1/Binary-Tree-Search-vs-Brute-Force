import java.util.Random;
import java.util.Arrays;

public class BruteForce
{
    public int[] bruteForce(int[] nums, int target) {
        int[] elements = new int[2];
        //Loop for every element in the array
        for (int i = 0; i < nums.length; i++) {
            //Loop for every element after nums[i] in the array
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    elements[0] = nums[i];      // Store the first element
                    elements[1] = nums[j];      // Store the second element
                    return elements;
                }
            }
        }
        throw new IllegalArgumentException("No pair found for the targeted sum in the array.");
    } // end bruteForce

    // Function to fill out an array with random values, sort the array afterwards
    public static void fillArray(int[] arr)
    {
        // Create instance of Random class
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(200) - 100 ;    // Randomly generate int value between -100 and 100.
        Arrays.sort(arr);
    }   // end fillArray

    public static void main(String[] args)
    {
        //Create instance of random class
        Random rand = new Random();
        int randomSum = rand.nextInt(400) - 200;    // Randomly generate int value for the target sum, between -200 and 200
        //Create new object of BruteForce
        BruteForce ob = new BruteForce();

        //Allocate memory for arrays
        int[] array1 = new int[100];
        int[] array2 = new int[100];
        int[] array3 = new int[100];
        int[] array4 = new int[100];
        int[] array5 = new int[100];

        //Fill arrays with random values
        fillArray(array1);
        fillArray(array2);
        fillArray(array3);
        fillArray(array4);
        fillArray(array5);

        System.out.println("The random sum between -200 and 200 is: " + randomSum + ".\n");

        /*
        Create a new array to store the possible elements from each array, take elapsed time in nanoseconds
        by keeping track of start and end time and subtracting them both, find the two values with bruteForce()
        method.
         */
        int[] values1 = new int[2];
        long nano_array1_startTime = System.nanoTime();
        values1 = ob.bruteForce(array1, randomSum);
        long nano_array1_endTime = System.nanoTime();
        System.out.println("Numbers found in array of 100 elements: " + values1[0] + " and " + values1[1] + ".");
        System.out.println("Elapsed time (ns) for 100 elements: " + (nano_array1_endTime-nano_array1_startTime) + "\n");

        int[] values2 = new int[2];
        long nano_array2_startTime = System.nanoTime();
        values2 = ob.bruteForce(array2, randomSum);
        long nano_array2_endTime = System.nanoTime();
        System.out.println("Numbers found in array of 100 elements: " + values2[0] + " and " + values2[1] + ".");
        System.out.println("Elapsed time (ns) for 100 elements: " + (nano_array2_endTime-nano_array2_startTime) + "\n");

        int[] values3 = new int[2];
        long nano_array3_startTime = System.nanoTime();
        values3 = ob.bruteForce(array3, randomSum);
        long nano_array3_endTime = System.nanoTime();
        System.out.println("Numbers found in array of 100 elements: " + values3[0] + " and " + values3[1] + ".");
        System.out.println("Elapsed time (ns) for 100 elements: " + (nano_array3_endTime-nano_array3_startTime) + "\n");

        int[] values4 = new int[2];
        long nano_array4_startTime = System.nanoTime();
        values4 = ob.bruteForce(array4, randomSum);
        long nano_array4_endTime = System.nanoTime();
        System.out.println("Numbers found in array of 100 elements: " + values4[0] + " and " + values4[1] + ".");
        System.out.println("Elapsed time (ns) for 100 elements: " + (nano_array4_endTime-nano_array4_startTime) + "\n");

        int[] values5 = new int[2];
        long nano_array5_startTime = System.nanoTime();
        values5 = ob.bruteForce(array5, randomSum);
        long nano_array5_endTime = System.nanoTime();
        System.out.println("Numbers found in array of 00 elements: " + values5[0] + " and " + values5[1] + ".");
        System.out.println("Elapsed time (ns) for 100 elements: " + (nano_array5_endTime-nano_array5_startTime));
    } // end main
}

