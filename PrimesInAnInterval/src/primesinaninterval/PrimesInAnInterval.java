package primesinaninterval;

import java.util.List;

public class PrimesInAnInterval {

    public static void main(String[] args) throws Exception {
        
        long startTime = System.nanoTime();
        
        Primes primes = new Primes();
        List primesList;
        
        primesList = primes.primesInAnInterval(2, 30);
        System.out.println(primesList.toString());
        
        
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        
        System.out.println("");
        System.out.println(primesList.size());
        
        //  System.out.println(primes.toString());
    }
}
