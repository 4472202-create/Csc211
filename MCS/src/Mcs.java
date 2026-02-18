import java.util.Random;

public class Mcs {
    static long countOn3 = 0 ;
    static long countOn2A = 0 ;
    static long countOn2B = 0 ;
    static long countOn = 0 ;
    public static int mcsOn3(int[] X) {
        int n = X.length ;
        int maxSoFar = 0 ;
        countOn3 = 0 ;
        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = 0;

                for (int r = low; r < high; r++) {
                    sum += X[r];
                    countOn3++;
                }
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }
    public static int mcsOn2A(int[] X) {
        int n = X.length;
        int maxSoFar = 0;
        countOn2A = 0;

        for (int low = 0; low < n; low++) {
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += X[r];
                countOn2A++;

                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }
    public static int mcsOn2B(int[] X) {
        int n = X.length;
        countOn2B = 0;

        int[] sumTo = new int[n + 1];
        sumTo[0] = 0;

        for (int i = 1; i <= n; i++) {
            sumTo[i] = sumTo[i - 1] + X[i - 1];
        }

        int maxSoFar = 0;

        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = sumTo[high + 1] - sumTo[low];
                countOn2B++; // Core operation

                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }

        return maxSoFar;
    }
    public static int mcsOn(int[] X) {
        int n = X.length;
        int maxSoFar = 0;
        int maxToHere = 0;
        countOn = 0;

        for (int i = 0; i < n; i++) {
            maxToHere = Math.max(maxToHere + X[i], 0);
            maxSoFar = Math.max(maxSoFar, maxToHere);

            countOn++;
        }

        return maxSoFar;
    }
    public static int[] generateArray(int n) {
        int[] X = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(n) + 1;

            if (rand.nextInt(3) == 0) {
                value = -value;
            }

            X[i] = value;
        }

        return X;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        System.out.printf("%-10s %-18s %-18s %-18s %-18s%n",
                "n", "O(n^3)", "O(n^2)A", "O(n^2)B", "O(n)");

        for (int n : sizes) {
            int[] X = generateArray(n);
            if (n <= 1000) {
                mcsOn3(X);
            } else {
                countOn3 = -1;
            }
            mcsOn2A(X);
            mcsOn2B(X);
            mcsOn(X);

            System.out.printf("%-10d %-18s %-18d %-18d %-18d%n",
                    n,
                    (countOn3 == -1 ? "SKIPPED" : countOn3),
                    countOn2A,
                    countOn2B,
                    countOn
            );
        }
    }

}