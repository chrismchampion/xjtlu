package edu.xjtlu.cse313.torture;

import java.io.IOException;
import java.util.Arrays;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Torture extends Configured implements Tool {
	public static void main(String[] args) throws Exception {
		System.out.println(Arrays.toString(args));
		int res = ToolRunner.run(new Configuration(), new Torture(), args);
		System.exit(res);
	}

	@Override
	public int run(String[] args) throws Exception {
		System.out.println(Arrays.toString(args));
		// Returns instance of Job with no connection to a cluster yet.
		Job job = Job.getInstance(getConf());
		job.setJarByClass(Torture.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		// Set Combiner to optimize bandwidth usage of MapReduce job
		job.setCombinerClass(Reduce.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
		return 0;
	}

	public static class Map extends
			Mapper<LongWritable, Text, Text, IntWritable> {

		private Text word = new Text();
		// Static member variables for keeping track of line number
		private static IntWritable lineNum = new IntWritable();
		private static int val = 0;

		@Override
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			// split by carriage return/new line
			for (String token : value.toString().split("\\r?\\n")) {
				// increment line number every iteration
				val++;
				if (token.contains("torture")) {
					lineNum.set(val);
					word.set(token);
					context.write(word, lineNum);
				}
			}
		}
	}

	public static class Reduce extends
			Reducer<Text, IntWritable, Text, IntWritable> {

		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int lineNum = 0;
			// Get and write the line number. No sum/reduction necessary.
			for (IntWritable val : values) {
				lineNum = val.get();
			}
			context.write(key, new IntWritable(lineNum));
		}
	}
}
