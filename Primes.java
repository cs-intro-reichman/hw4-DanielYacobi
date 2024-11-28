public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] primes = new boolean[n+1];
        int amount = 0;
        int percentage;

        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }
        int idx = 2;
        while (idx * idx <= n) {
            if (isPrime(idx)) {
                for (int i = 2; i < primes.length; i++) {
                    if (i % idx == 0 && i != idx) {
                        primes[i] = false;
                    }
                }
            }
            idx ++;
        }
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
                amount ++;
            }
        }
        percentage = (int) ((double)amount / n * 100);
        System.out.println("There are " + amount + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }

    public static boolean isPrime (int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && n != i)
                return false;
        }
        return true;
    }

}