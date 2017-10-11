package model;

public class DataProcessor {
	
	public DataProcessor() {}
	
	private float mean, std;
	
	public void compute (String ip) {
	
		
		String [] data = ip.split(",");
		int[] input = new int[data.length];
		 for(int i=0; i<data.length;i++) {
			 input[i] += Integer.parseInt(data[i]);
		 }
		 calculateMean(input);
		 calculateStandardDeviation(input);
	}
	
	private void calculateMean(int[] input) {
		
		float total=0;
		for(int i=0;i<input.length;i++)
			total += input[i];
		mean = total/input.length;
		System.out.println("");
	}
	
	private void calculateStandardDeviation(int[] input) {
		
		float variance = 0;
		for(int i=0; i<input.length;i++) {
			float diff = input[i] - mean;
			variance += Math.pow(diff, 2);
		}
		std = variance/input.length;
		System.out.println("");
	}

	public float getMean() {
		return mean;
	}

	public float getStd() {
		return std;
	}
	
	

}
