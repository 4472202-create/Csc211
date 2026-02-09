
import java.util.Random;

public class BiasedShuffle {
    public static int[] shufflebiased(int N) {
        int[] arr = new int[N];
     for (int i = 0; i < N; i++) {
     arr[i] = i + 1;
     }
     Random rand = new Random();
     for (int i = 0; i < N; i++) {
         int j = rand.nextInt(N);
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
     return arr;
 }


 public static void main(String[] args) {
     int[] result = shufflebiased(5);
     System.out.print("Biased shuffle: ");
     for (int num : result) {
         System.out.print(num + " ");
     }

 }

}



