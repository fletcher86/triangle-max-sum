package com.fletcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * By starting at the top of the triangle and moving to adjacent numbers on the
 * row below, the maximum total from top to bottom is 27.
 * 
 * <pre>
				5 
			   9 6 
			  4 6 8 
			 0 7 1 5
 * </pre>
 * 
 * i.e. 5 + 9 + 6 + 7 = 27.
 * 
 * Write a program in Java to find the maximum total from top to bottom in the
 * included file ‘triangle.txt’ - a text file containing a triangle with 100
 * rows.
 * 
 * @author Kent Fletcher
 *
 */
public class TriangleMaxSum
{

	/**
	 * Main entry point. To execute on command line
	 * 
	 * > java -jar triangle-max-sum-1.0.jar < triangle.txt
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		String[] fileData = readFile();

		List<List<Integer>> triangleData = toDataStruct(fileData);

		printTriangleData(triangleData, 4);

		computeTriangleMaxSum(triangleData);
	}

	/**
	 * Read input file and return String[] where each element is line of input
	 * 
	 * @return String [] each element is line of input
	 * @throws FileNotFoundException
	 */
	public static String[] readFile() throws FileNotFoundException
	{
		final Scanner scanner = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			sb.append(line).append("###");
		}
		scanner.close();

		return sb.toString().split("###");
	}

	/**
	 * Pass in String [] input where each element is a line of input and return a
	 * List<List<Integer>>
	 * 
	 * @param fileData String[] input where each element is line of input
	 * @return List<List<Integer>> data structure
	 */
	public static List<List<Integer>> toDataStruct(String[] fileData)
	{

		List<List<Integer>> tdl = new ArrayList<>();

		for (String line : fileData)
		{

			String[] data = line.split(" ");

			List<Integer> tdata = new ArrayList<>();
			for (int i = 0; i < data.length; i++)
			{
				tdata.add(Integer.parseInt(data[i]));
			}

			tdl.add(tdata);
		}

		return tdl;
	}

	/**
	 * Print to System.out the data structure represented by List<List<Integer>>
	 * 
	 * @param tdl   List<List<Integer>> input data structure
	 * @param width for formatting purposes the width of each field
	 */
	public static void printTriangleData(List<List<Integer>> tdl, int width)
	{
		for (int i = 0; i < tdl.size(); i++)
		{
			for (int j = 0; j <= i; j++)
			{
				System.out.printf("%0" + width + "d ", tdl.get(i).get(j));
			}
			System.out.println();
		}

	}

	/**
	 * Compute the triangle max sum given the input data structure
	 * 
	 * @param tdl List<List<Integer>> input data structure
	 * @return int the max of triangle sum
	 */
	public static int computeTriangleMaxSum(List<List<Integer>> tdl)
	{

		for (int i = tdl.size() - 2; i >= 0; i--)
		{
			for (int j = 0; j <= i; j++)
			{
				tdl.get(i).set(j, tdl.get(i).get(j) + Math.max(tdl.get(i + 1).get(j), tdl.get(i + 1).get(j + 1)));
			}
		}
		System.out.println("Max Sum = " + tdl.get(0).get(0));

		return tdl.get(0).get(0);
	}

}
