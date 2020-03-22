package gradeshistogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HistogramGenerator {

	/***
	 * Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 *
	 * @param dataValues Single dimension integer array
	 */
	public void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grade", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("Frequency Chart", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException{
		//checks if the user has given any arguments
		File inFile = null;
		if (0 < args.length) {
			inFile = new File(args[0]);
		} else {
			System.err.println("No file given. Please try again!");
			System.exit(1);
		}

		Scanner sfile = null;
		try {
			sfile = new Scanner(inFile);
			ArrayList<Integer> listOfNumbers = new ArrayList<>();
			while (sfile.hasNext()) {
				// find next line
				int num = sfile.nextInt();
				listOfNumbers.add(num);
			}
			sfile.close();
			//turns arraylist of integers into array of integers
			int[] datavalues = new int[listOfNumbers.size()];
			for (int i = 0; i < listOfNumbers.size(); i++) datavalues[listOfNumbers.get(i)] = datavalues[listOfNumbers.get(i)] + 1;


			HistogramGenerator histogramGenerator = new HistogramGenerator();
			histogramGenerator.generateChart(datavalues);
		} catch (FileNotFoundException e) {
			System.err.println("The file you inserted was not found. Please try again!");
			System.exit(1);
		}

	}
}

