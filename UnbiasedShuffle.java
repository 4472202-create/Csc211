import java.util.Random;

public class UnbiasedShuffle {
    public static int[] shuffle(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int j = i + rand.nextInt(N - i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] result = shuffle(5);
        System.out.print("Unbiased shuffle: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
 }

}
