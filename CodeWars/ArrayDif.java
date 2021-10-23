import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDif {
    public static void main(String[] args) {
        int[] a = new int[] {1,2};
        int[] b = new int[] {1};
        System.out.println(Arrays.toString(arrayDiff(a, b)));
    }
    public static int[] arrayDiff(int[] a, int[] b) {
        int [] tempArray = new int[a.length];
        int counter = 0;
            for (int i : b){
                for(int j : a){
                    if(j != i)
                    {
                        tempArray[i] = j;
                        counter++;
                    }
                }
            }
            //System.out.println(Arrays.toString(tempArray));
            int [] arrayToReturn = new int[counter];
            int f = 0;
            for(int r : tempArray)
            {
                if(r != 0)
                {
                    arrayToReturn[f] = r;
                    f++;
                }
            }
            return arrayToReturn;
      }
}
