import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.lang.Math;
//Create a Class to hold variables used in
//the moving weighted average formula.
public class SamRTT {

	private double SampleRTT;
	private double Alpha;
	private double EstimatedRTT;
	private double Deviation;
	private double RTO;

	SamRTT()
	{
		SampleRTT = 0;
		Alpha = 0;
		EstimatedRTT = 0;
		Deviation = 0;
		RTO = 0;
	}

	public void setSampleRTT (double SampleRTT){
		this.SampleRTT = SampleRTT;
	}
	public double getSampleRTT() {
		return SampleRTT;
	}
	public void setAlpha (double Alpha) {
		this.Alpha = Alpha;
	}
	public double getAlpha() {
		return Alpha;
	}
	public void setEstimatedRTT (double EstimatedRTT) {
		this.EstimatedRTT = EstimatedRTT;
	}
	public double getEstimatedRTT() {
		return EstimatedRTT;
	}
	public void setDeviation (double Deviation) {
		this.Deviation = Deviation;
	}
	public double getDeviation() {
		return Deviation;
	}
	public void setRTO (double RTO) {
		this.RTO = RTO;
	}
	public double getRTO() {
		return RTO;
	}
	//Formats the string printed when calling
	//the system.out.print(thisObject) method
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		df.setMinimumFractionDigits(3);
		DecimalFormat sixdf = new DecimalFormat("#.######");
		sixdf.setRoundingMode(RoundingMode.CEILING);
		sixdf.setMinimumFractionDigits(6);
		return df.format(this.Alpha) + "\t \t"
		+ sixdf.format(this.SampleRTT) + "\t \t" + sixdf.format(this.EstimatedRTT)
		+ "\t \t" + sixdf.format(this.Deviation) + "\t \t" + sixdf.format(this.RTO);
	}

}
