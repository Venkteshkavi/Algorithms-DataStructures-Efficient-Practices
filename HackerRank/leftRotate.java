import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static void leftRotate(int[] arr,int k,int size){
        if(arr.length == 0){
            return;
        }

        k = k % size;

        reverse(arr,0,size-1);
        reverse(arr,size-k,size-1);
        reverse(arr,0,size-k-1);

    }

    private static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
      rotateLeft(a,k,n);
    }
}
