package com.xingxi.file;

import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * @author cc
 * @Date 2019-03-07 00:39:39 Thursday
 */
public class FileOperation extends TestCase {

    public void testInput() throws IOException {
        InputStream source = new FileInputStream("/Users/cc/Downloads/1.txt");
        OutputStream dest = new FileOutputStream("/Users/cc/Downloads/2.txt");
        byte[] data = new byte[1024];
        int length;
        while ((length = source.read(data)) != -1) {
            dest.write(data, 0, length);
        }
    }

    public void testReader() throws IOException {
        InputStream source = new FileInputStream("/Users/cc/Downloads/1.txt");
        OutputStream dest = new FileOutputStream("/Users/cc/Downloads/2.txt");
        Reader reader = new InputStreamReader(source,"UTF-8");
        Writer writer = new OutputStreamWriter(dest,"UTF-8");
        try(Reader input = reader;Writer output = writer){
            char[] data = new char[1024];
            int length;
            while ((length = input.read(data)) != -1) {
                output.write(data, 0, length);
            }
        }
    }

    //https://blog.csdn.net/houfeng30920/article/details/51997368
    public void testFileUtils() throws IOException {
        FileUtils.readFileToString(new File("/Users/cc/Downloads/1.txt"),"UTF-8");
        FileUtils.readLines(new File("/Users/cc/Downloads/1.txt"),"UTF-8");
    }

    public void testMoveFile() throws IOException {
        FileUtils.moveDirectory(new File("/Users/cc/Downloads/3.txt"),
                new File("/Users/cc/Downloads/4.txt"));
    }
}
