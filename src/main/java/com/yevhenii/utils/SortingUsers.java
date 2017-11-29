package com.yevhenii.utils;

import com.yevhenii.model.User;

/**
 * Created by Yevhenii on 29.11.2017.
 */
public class SortingUsers {
    public static void bubbleSort(User[] array){
        User temp;
        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < (array.length - i); j++){
                if (array[j-1].compareTo(array[j]) == 1){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void insertSort(User[] array){
        User temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j-1].compareTo(array[j]) == 1){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public static void quickSort(User[] array){
        doQuickSort(array, 0, array.length - 1);
    }

    private static void doQuickSort(User[] array, int start, int end) {
        User temp;
        int i = start, j = end;
        User pivot = array[start + (end-start)/2];
        while (i <= j) {
            while (array[i].compareTo(pivot) == -1) {
                i++;
            }
            while (array[j].compareTo(pivot) == 1) {
                j--;
            }
            if (i <= j) {
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
                j--;
            }
        }
        if (start < j)
            doQuickSort(array,start, j);
        if (i < end)
            doQuickSort(array, i, end);
    }
}
