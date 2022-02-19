import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.lang.Math;
public class SorensenMichael_Project_2
{
	public static void main (String[] args)
	{
		//Create Scanner object to get Sample RTT input
		Scanner Keyboard = new Scanner(System.in);
		//Create a new object of the SamRTT class to
		//hold SampleRTT and Alpha
		SamRTT sample = new SamRTT();
		//Prompt user to enter a Sample RTT
		System.out.print("Enter SampleRTT:");
		//Call the method to set the SampleRTT for sample
		sample.setSampleRTT(Keyboard.nextDouble());
		System.out.println();
//Print table headers
		System.out.println("Alpha" + "\t \t" + "SampleRTT" + "\t \t"
			+ "EstimatedRTT" + "\t \t" + "Deviation" + "\t \t" + "RTO");
		System.out.println("----------------------------------------------------------------"
		+ "----------------------------------");

//Loop through values of alpha incrementing
//by .001. For each value of alpha, store the
//values of the other variables in the sample
//object, then print the object. 
		for (double j = 0; j <= 1000; j = j + 1)
		{
			sample.setAlpha(j/1000);
			double EstimatedRTT = CalculateEstimatedRTT(sample);
			sample.setEstimatedRTT(EstimatedRTT);
			double Deviation = CalculateDeviation(sample);
			sample.setDeviation(Deviation);
			double RTO = CalculateRTO(sample);
			sample.setRTO(RTO);
			System.out.println(sample);
		}

	}
	public static double CalculateEstimatedRTT(SamRTT sample)
	{
		int EstRTTold = 0;
		double SampleRTT = sample.getSampleRTT();
		double EstimatedRTT;
		double Alpha = sample.getAlpha();

		EstimatedRTT = (1-Alpha) * EstRTTold + Alpha * SampleRTT;
		return(EstimatedRTT);
	}
	public static double CalculateDeviation(SamRTT sample)
	{
		int DeviationOld = 0;
		double Deviation;
		double EstimatedRTT = sample.getEstimatedRTT();
		double SampleRTT = sample.getSampleRTT();
		double Alpha = sample.getAlpha();

		Deviation = (1-Alpha) * DeviationOld
		+ Alpha * Math.abs(SampleRTT - EstimatedRTT);
		return(Deviation);
	}
	public static double CalculateRTO(SamRTT sample)
	{
		double RTO;
		double EstimatedRTT = sample.getEstimatedRTT();
		double Deviation = sample.getDeviation();

		RTO = EstimatedRTT + 4*Deviation;
		return(RTO);
	}


}
