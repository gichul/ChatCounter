package edu.handong.csee.java.hw3;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
/**
 * 
 * @author gichulkim
 *this is main method
 */
public class Home3Main {
	
	static String inputPath;
	static String outputPath;
	boolean verbose;
	boolean help;
	static ArrayList<String> unitedData=new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		Home3Main way = new Home3Main();
		way.run(args);

		ChatMessageCounter Counter;
		String filePath= inputPath;
		File files=new File(filePath);
		
		File[] fileNames=files.listFiles();
		
		
		ArrayList<DataReader> Runners = new ArrayList<DataReader>();

		// this method returns the number of available threads
		
		int numOfCoresInMyCPU = Runtime.getRuntime().availableProcessors();
		System.out.println("The number of cores of my system: " + numOfCoresInMyCPU);
		
		ExecutorService executor = Executors.newFixedThreadPool(numOfCoresInMyCPU);



		
		Runnable worker = null;
		
		for(File f : fileNames) {
			String fileName=f.getName();
	
			if(fileName.contains(".txt")) {
				worker =new DataReaderForTXT(fileName);
				executor.execute(worker);
				Runners.add((DataReader) worker);
				
			}
			
			else if(fileName.contains(".csv")) {
				worker =new DataReaderForCSV(fileName);
				executor.execute(worker);
				Runners.add((DataReader) worker);

			}
		}
		
		

		executor.execute(worker);
		Runners.add((DataReader) worker);


		executor.shutdown(); // not to accept any new threads

		while (!executor.isTerminated()) {
		}

		for(String s:Home3Main.unitedData) {
		//	System.out.println(s);
		}
		

		

		
		Counter=new ChatMessageCounter();
		Counter.split();
		Counter.count();
		
		DataWriter write = new DataWriter(Counter.result,Counter.person);
		write.run(outputPath);

			
		
	}
	/**
	 * mehtod to CLI
	 * @param args
	 */

	private void run(String[] args) {
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			
			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + inputPath + "\" as the value of the option i");
			System.out.println("You provided \"" + outputPath + "\" as the value of the option o");			
			// TODO show the number of files in the path
			
			if(verbose) {
				
				// TODO list all files in the path
				
				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			inputPath = cmd.getOptionValue("i");
			outputPath = cmd.getOptionValue("o");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("path")
				.desc("Set a directoy path that contains input files")
				.hasArg()
				.argName("Directory path")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("path")
				.desc("Set a directory path that contains output files")
				.hasArg()
				.argName("Directory path")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());

		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
	
	
}

