package com.sparta.eng68.traineetracker.utilities;

import com.sparta.eng68.traineetracker.entities.CSVUser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVLoginWriter {

    String fileName;
    BufferedWriter bufferedWriter;

    //Constructor which sets the filePath to write to
    public CSVLoginWriter (String fileName) throws IOException {
        this.fileName = fileName;
        bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));
    }

    public void addNewUser(String username) {

        CSVUser user = new CSVUser(username, PasswordGenerator.generatePassword(), Role.FIRST_TIME_USER);


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
