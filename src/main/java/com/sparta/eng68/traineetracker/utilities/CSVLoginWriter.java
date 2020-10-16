package com.sparta.mc.CSVHandler;

import com.sparta.mc.DataVerification.EmployeeTracker;
import com.sparta.mc.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVLoginWriter {

    String fileName;
    BufferedWriter bufferedWriter;

    //Constructor which sets the filePath to write to
    public CSVLoginWriter (String fileName) throws IOException {
        this.fileName = fileName;
        bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));
    }



    //Writes the csv String straight to the file
    public void writeStringRecordToFile(String record) throws IOException {
        bufferedWriter.write(record);
    }

    //Close the writer object
    public void close() throws IOException {
        bufferedWriter.close();
    }

}
