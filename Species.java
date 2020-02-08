/*
	Author: Lily Shpak
	Date: 2/8/2020
	This is code for my biogeography class
	We had to calculate three different metrics for measuring regional diversity based off three 
	different populations we were given.
	The three metrics were 
		- Shannon-Weiner Diversity Index
		- Evenness
		- Simpson's Diversity Index
	Each site is represented by an array containing the abundance of each species in a site
*/

import java.lang.Math;
public class Species
{
	public static void main(String[]args)
	{
		double [] site1 = {.083,.083,.083,.25,.166,.083,.083,.083,.083};
		double site1num = 12;
		double site1H = shannonWeiner(site1);
		System.out.println("Shannon-Weiner Diversity Index for site one: "+site1H);
		System.out.println("Evenness for site one: "+evenness(site1H,site1num));
		System.out.println("Simpson Diversity for site one: " + simpsonDiversity(site1));
		System.out.println("");

		double [] site2 = {.071,.28,.071,.071,.071,.071,.071,.071,.071};
		double site2num = 14;
		double site2H = shannonWeiner(site2);
		System.out.println("Shannon-Weiner Diversity Index for site two: "+site2H);
		System.out.println("Evenness for site two: "+evenness(site2H,site2num));
		System.out.println("Simpson Diversity for site two: " + simpsonDiversity(site2));
		System.out.println("");

		double [] site3 = {.375,.125,.125,.125};
		double site3num = 8;
		double site3H = shannonWeiner(site3);
		System.out.println("Shannon-Weiner Diversity Index for site three: "+site3H);
		System.out.println("Evenness for site three: "+evenness(site3H,site3num));
		System.out.println("Simpson Diversity for site three: " + simpsonDiversity(site3));
		System.out.println("");

	}
	public static double shannonWeiner(double [] site)
	{
		double sum = 0;
		for(int i = 0; i<site.length;i++)
		{
			double lnSpecies = Math.log(site[i]);
			sum = sum + (site[i]/lnSpecies);
		}
		sum = sum * -1;
		return sum;
	}
	public static double evenness(double shannonWeiner, double speciesNum)
	{
		double lnSpecies = Math.log(speciesNum);
		return shannonWeiner/lnSpecies;
	}
	public static double simpsonDiversity(double [] site)
	{
		double sum = 0;
		for(int i = 0; i<site.length; i++)
		{
			double square = site[i] * site[i];
			sum = sum + square;
		}
		return 1.0/sum;
	}
}