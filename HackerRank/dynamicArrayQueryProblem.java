import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
       if(n == 0){
           return new ArrayList();
       }
       List<Integer> res = new ArrayList();
       List<List<Integer>> tempList = new ArrayList();
       Integer lastAns = 0;
       for(int i=0; i<n; i++){
           tempList.add(new ArrayList());
       }

       for(List<Integer> query : queries){
           int qval = query.get(0);
           int x = query.get(1);
           int y = query.get(2);
           int seq = 0;
           if(qval == 1){
               seq = (x ^ lastAns) % n;
               tempList.get(seq).add(y);
           }
           else if(qval == 2){
               seq = (x^lastAns) % n;
               int idx = (y % tempList.get(seq).size());
               lastAns = tempList.get(seq).get(idx);
               res.add(lastAns);
           }
           else{
               System.out.println("Wrong Query");
           }
       }
       return res;
    }
}
