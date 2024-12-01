public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] primes = new boolean[n+1]; //all values are false by default
        int amount = 0;
        int percentage;

        for (int i = 2; i <= n; i++) {
            primes[i] = true; //puts true in each index from 2 upwards
        }
        int idx = 2;
        while (idx * idx <= n) {
            if (isPrime(idx)) {
                for (int i = 2; i < primes.length; i++) {
                    if (i % idx == 0 && i != idx) {
                        primes[i] = false; //if the index isnt prime then its value is now false
                    }
                }
            }
            idx ++;
        }
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i); //prints every prime index; prime numbers from 2-n
                amount ++; //amount of true values inside the array
            }
        }
        percentage = (int) ((double)amount / n * 100);
        System.out.println("There are " + amount + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }

    //receives an integer and returns true if its prime
    //and false if not
    public static boolean isPrime (int n) {
        if (n < 2) //2 is the first prime
            return false;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && n != i) //conditions for a prime number
                return false;
        }
        return true;
    }

}