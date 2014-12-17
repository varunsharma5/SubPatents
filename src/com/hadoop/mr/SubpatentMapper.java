package com.hadoop.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SubpatentMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
	
	protected void map(LongWritable key, Text value, Context context) throws java.io.IOException ,InterruptedException {
		String line = value.toString();
		String[] tokens = line.split(" ");
	
		context.write(new Text(tokens[0]), one);
	}
}
