/*****************************************************
* Contestant number 04-0207-0001
*****************************************************/

public class Prime
{
	public static void main(String[] args)
	{
		// Holds file names
		String inputName = "Numbers.txt";
		String outputName = "PrimeNumbers.txt";
		
		// Initializes constructor, passing in file names
		PrimeNumber primeHandler = new PrimeNumber(inputName, outputName);
		
		// If the files exist
		if(primeHandler.filesValid())
		{
			System.out.println("Start processing numbers.");
			// Process and output whether or not the numbers are primes
			primeHandler.processPrimes();
			System.out.println("Finished processing numbers.");
		}
	}
}