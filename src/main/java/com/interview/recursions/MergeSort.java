package com.interview.recursions;

/**
 * Created by Mike on 2017-04-19.
 */
import java.util.Arrays;

public class MergeSort {
    public static void main(String a[]) {

        int array[] = { 10, 8, 1, 2, 13, 1, 3, 11 };

        System.out.println("STARTING ARRAY\n");

        printHorzArray(-1, -1, array, 49);

        System.out.println();

        // Send the array, 0 and the array length

        mergeSort_srt(array, 0, array.length - 1);

        System.out.print("FINAL SORTED ARRAY\n");

        printHorzArray(-1, -1, array, 49);

    }

    // Receives the array, 0 and the array length

    public static void mergeSort_srt(int array[], int lo, int n) {
        int low = lo;
        int high = n;

        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSort_srt(array, low, middle);

        mergeSort_srt(array, middle + 1, high);

        int end_low = middle;

        int start_high = middle + 1;

        while ((low <= end_low) && (start_high <= high)) {

            if (array[low] < array[start_high]) {
                low++;
            } else {

                int temp = array[start_high];

                for (int k = start_high - 1; k >= low; k--) {

                    array[k + 1] = array[k];
                }

                array[low] = temp;
                low++;
                end_low++;
                start_high++;
            }
        }

    }

    // Used to print out the smaller arrays

    static void printSmallArray(int theArray[], int lo, int high) {

        int[] tempArray = Arrays.copyOfRange(theArray, lo, high);

        int tempArrayDashes = tempArray.length * 6;

        System.out.println("Array Index Start " + lo + " and End " + high);

        printHorzArray(-1, -1, tempArray, tempArrayDashes);

    }

    static void printHorzArray(int i, int j, int theArray[], int numDashes) {

        for (int n = 0; n < numDashes; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < theArray.length; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < numDashes; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < theArray.length; n++) {

            System.out.print(String.format("| %2s " + " ", theArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < numDashes; n++)
            System.out.print("-");

        System.out.println();

    }
}