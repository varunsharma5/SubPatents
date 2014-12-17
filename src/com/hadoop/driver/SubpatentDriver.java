package com.hadoop.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.hadoop.mr.SubpatentMapper;
import com.hadoop.mr.SubpatentReducer;

public class SubpatentDriver {
	public static void main(String[] args) throws Exception{

		//Creating an object of Configuration class, which loads the
		//configuration parameters
		Configuration conf = new Configuration();
		//Creating the object of Job class and passing the conf object
		//and Job name as arguments. The Job class allows the user
		//to configure the job, submit it and control its execution.
		Job job = new Job(conf, "subpatent");
		//Setting the jar by finding where a given class came from
		job.setJarByClass(SubpatentDriver.class);
		//Setting the key class for job output data
		job.setOutputKeyClass(Text.class);
		//Setting the value class for job output data
		job.setOutputValueClass(IntWritable.class);
		//Setting the mapper for the job
		job.setMapperClass(SubpatentMapper.class);
		//Setting the reducer for the job
		job.setReducerClass(SubpatentReducer.class);
		//Setting the Input Format for the job
		job.setInputFormatClass(TextInputFormat.class);
		//Setting the Output Format for the job
		job.setOutputFormatClass(TextOutputFormat.class);
		//Adding a path which will act as a input for MR job. args[0]
		//means it will use the first argument written on terminal
		//as input path
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
//		Setting the path to a directory where MR job will dump the
//		output. args[1] means it will use the second argument written on terminal as
//		output path
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		//Submitting the job to the cluster and waiting for its
		//completion
		job.waitForCompletion(true);
	
	}
}
