
import java.util.Random;

import java.util.HashMap;

public class TestShuffle {
    public static void main(String[] args) {
        int N = 3;
        int trials = 60000;
        System.out.println("Testing shuffling methods with " + trials + " trials...\n");
        HashMap<String, Integer> unbiased = new HashMap<>();
        for (int t = 0; t < trials; t++) {
            int[] arr = {1, 2, 3};
            Random rand = new Random();
            for (int i = 0; i < N; i++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            String key = "" + arr[0] + arr[1] + arr[2];
            unbiased.put(key, unbiased.getOrDefault(key, 0) + 1);
        }
        System.out.println("Unbiased method results:");
        for (String key : unbiased.keySet()) {
            System.out.println(key + ": " + unbiased.get(key));
        }
        HashMap<String, Integer> biased = new HashMap<>();
        for (int t = 0; t < trials; t++) {
            int[] arr = {1, 2, 3};
            Random rand = new Random();
            for (int i = 0; i < N; i++) {
                int j = rand.nextInt(N);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            String key = "" + arr[0] + arr[1] + arr[2];
            biased.put(key, biased.getOrDefault(key, 0) + 1);
        }
        System.out.println("\nBiased method results:");
        for (String key : biased.keySet()) {
            System.out.println(key + ": " + biased.get(key));
        }
        System.out.println("\nExpected for unbiased: ~" + (trials/6) + " each");
    }

}


