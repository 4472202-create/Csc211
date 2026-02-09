import java.util.Random;

public class SlowShuffle {
    public static int[] slowshuffle(int N) {
        int[] shuffled = new int[N];
        boolean[] notUsed = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            notUsed[i] = true;
        }
        Random rand = new Random();
        int count = 0;
        while (count < N) {
            int r = rand.nextInt(N) + 1;
            if (notUsed[r]) {
                shuffled[count] = r;
                notUsed[r] = false;
                count++;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (notUsed[i]) {
                shuffled[N - 1] = i;
                break;
            }
        }
        return shuffled;
    }
    public static void main(String[] args) {
        int[] result = slowshuffle(5);
        System.out.print("Slow shuffle result: ");
        for (int num : result) {
        System.out.print(num + " ");
    }

    }
}



