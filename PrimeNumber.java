/*****************************************************
* Contestant number 04-0207-0001
*****************************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class PrimeNumber
{
	// Contains file names
	private String input;
	private String output;
	
	// File objects holding file names
	private File inputFile;
	private File outputFile;
	
	// Constructor
	public PrimeNumber(String inputName, String outputName)
	{
		// Pass in file names
		input = inputName;
		output = outputName;
		
		// Set file objects with file names
		inputFile = new File(input);
		outputFile = new File(output);
	}
	
	// Checks if files exist
	public boolean filesValid()
	{
		if(!inputFile.exists() || !outputFile.exists())
			return false;
		return true;
	}
	
	// Processes whether prime or not
	public void processPrimes()
	{
		try
		{
			// Create scanner and printwriter for input and output
			Scanner inputFileReader = new Scanner(inputFile);
			PrintWriter outputFileWriter = new PrintWriter(output);
			
			// Until the file reaches EOF
			while(inputFileReader.hasNext())
			{
				// Get next number from file
				int num = inputFileReader.nextInt();
				
				// If it's prime, output prime and number
				if(this.isPrime(num))
				{
					outputFileWriter.print("Prime! ");
					outputFileWriter.println(num);
				}
				else
				{
					// Output not prime and sets up arraylist to hold divisibles
					ArrayList<String> possibles = new ArrayList<String>();
					outputFileWriter.print("Not prime!");
					
					// Gets divisibles
					possibles = getPossibles(num);
					// Output each possibility to output file
					for(int i = 0; i < possibles.size(); i++)
					{
						outputFileWriter.print(" ");
						outputFileWriter.print(Integer.parseInt(possibles.get(i)));
					}
					outputFileWriter.println();
				}
			}
			
			// Close files
			inputFileReader.close();
			outputFileWriter.close();
		}
		// Empty catch statement
		catch(IOException ex)
		{
		}
	}
	
	// Determines if it is prime
	public boolean isPrime(int number)
	{
		boolean isPrime = true;
		
		for(int i = 2; i < (int)Math.sqrt(number); i++)
		{
			if(number % i != 0)
			{
				isPrime = false;
			}
		}
		
		return isPrime;
	}
	
	// Returns arraylist of numbers that are divisible for a non-prime number
	public ArrayList<String> getPossibles(int number)
	{
		ArrayList<String> possibles = new ArrayList<String>();
		for(int i = 2; i < (int)Math.sqrt(number); i++)
		{
			if(number % i != 0)
			{
				possibles.add(Integer.toString(i));
			}
		}
		return possibles;
	}
}