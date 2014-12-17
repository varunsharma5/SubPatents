package com.hadoop.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SubpatentReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	protected void reduce(Text key, java.lang.Iterable<IntWritable> values, Context context) throws java.io.IOException ,InterruptedException {
		int subPatentCount = 0;
		for(IntWritable value : values) {
			subPatentCount+= value.get();
		}
		context.write(key, new IntWritable(subPatentCount));
	}
}
