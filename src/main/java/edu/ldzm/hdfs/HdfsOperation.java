package edu.ldzm.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HdfsOperation {
	
	public boolean putFile2Hdfs(FileSystem fileSystem, File from, Path to) {
		
        FileInputStream in = null;
        try {
            in = new FileInputStream(from.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        FSDataOutputStream out = null;
        try {
            out = fileSystem.create(to);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            IOUtils.copyBytes(in, out, 1024, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return true;
	}
}
