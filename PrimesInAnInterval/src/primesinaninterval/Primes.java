package primesinaninterval;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    private final StringBuilder builder = new StringBuilder();
    private final List<Integer> primes = new ArrayList<>();
     
    public List primesInAnInterval(int from, int to) throws Exception{
        if (from > to || from < 0) {
            throw new Exception("Invalid input!");
        }
        
        findPrimeNumbers(from, to);
        
        if (primes.isEmpty()) {
            System.out.println("There are no primes in the given interval!");
            // return;
        }
        
        return primes;
    }
    
    private void findPrimeNumbers(int from, int to){
        int checkToThisNumber;
        
        //  2 is the only even prime number. The loop ignores even
        //  nmbers. Added manually        
        if (from <= 2) {
            primes.add(2);
        }
        
        // Main loop
        for (int i = from; i != to; i++) {
            checkToThisNumber = (int)Math.round(Math.sqrt(i));
            
            if (i % 2 == 0) {
                continue;
            }
            
            for (int j = 2; j <= checkToThisNumber; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == checkToThisNumber) {
                    primes.add(i);
                }
            }
        }
    }
    
    
    /*
    private boolean isPrime(int number, int divisor){
        if (number % divisor == 0) {
            return false;
        }
        if (divisor == (int)Math.round(Math.sqrt(number))) {
            return true;
        }
        int incrementedDivisor = divisor + 1;
        return isPrime(number, incrementedDivisor);
    }
    
    private void findPrimeNumbers(int from, int to){
        if (isPrime(from, 2)) {
            primes.add(from);
        }
        if (from == to) {
            return;
        }
        int incrementedFrom = from + 1;
        findPrimeNumbers(incrementedFrom, to);
    }
    */
    
    /*
    //  Another way of printing the List
    @Override public String toString(){
        for (int i = 0; i < primes.size(); i++) {
            
            builder.append(primes.get(i));
            
            if (i == primes.size() - 1) {
                builder.append(".");
            }
            else{
                builder.append(", ");
            }
        }
        return builder.toString();
    }
    */
}
