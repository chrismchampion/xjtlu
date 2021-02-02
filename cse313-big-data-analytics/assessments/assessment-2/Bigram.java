package edu.xjtlu.cse313.bigram;

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

public class Bigram extends Configured implements Tool {
	
   public static void main(String[] args) throws Exception {
      System.out.println(Arrays.toString(args));
      int res = ToolRunner.run(new Configuration(), new Bigram(), args);
      System.exit(res);
   }

   @Override
   public int run(String[] args) throws Exception {
      System.out.println(Arrays.toString(args));
      // Returns instance of Job with no connection to a cluster yet.
      Job job = Job.getInstance(getConf());
      job.setJarByClass(Bigram.class);
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

   public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
	   
      private final static IntWritable COUNT = new IntWritable(1);
      private Text word = new Text();
      // Static member variable for keeping track of previous word value between lines
  	  private static String prevWord = null;
      
      @Override
      public void map(LongWritable key, Text value, Context context)
              throws IOException, InterruptedException {
    	  // split by one or more blank spaces
    	  for (String token: value.toString().split("\\s+")) {
    		  // Current word initialized with token string value
    		  String curWord = token;
    		  // Previous word initialized with null for start of document
    		  if (prevWord != null) {  
    			  word.set(prevWord + " " + curWord);
    			  context.write(word, COUNT);
    		  }
    		  // Current word becomes previous word after writing to Mapper context
    		  prevWord = curWord;
    	  }
      }
   }

   public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
      @Override
      public void reduce(Text key, Iterable<IntWritable> values, Context context)
              throws IOException, InterruptedException {
         int sum = 0;
         // SUM and write instances of COUNT
         for (IntWritable val : values) {
            sum += val.get();
         }
         context.write(key, new IntWritable(sum));
      }
   }
}

