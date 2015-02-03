package edu.ldzm.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsOperation {
	
    public static final String HDFS_PATH = "hdfs://sky:9000";
    public static final String DIR_PATH = "/home/sky/Desktop/hello.txt";
    public static final String FILE_PATH = "/d1000/f1000";
	
	public static void main(String[] args) throws IOException {
        FileSystem hdfsFileSystem = null;
        Configuration config = null;
        
        config = new Configuration();
        
        config.set("fs.default.name", HDFS_PATH);
        hdfsFileSystem = FileSystem.get(config);
        
        hdfsFileSystem.copyFromLocalFile(new Path(DIR_PATH), new Path(FILE_PATH));
	}
}
