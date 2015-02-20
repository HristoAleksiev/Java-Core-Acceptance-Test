package primesinaninterval;

import java.util.List;

public class PrimesInAnInterval {

    public static void main(String[] args) throws Exception {
        
        Primes primes = new Primes();
        List primesList;
        
        primesList = primes.primesInAnInterval(2, 30);
        System.out.println(primesList.toString());
    }
}
