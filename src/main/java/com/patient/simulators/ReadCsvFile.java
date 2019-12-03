package com.patient.simulators;

import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCsvFile {

    public static void main(String[] args) {
        SpringApplication.run(ReadCsvFile.class, args);
        System.out.println( "Read CSV running");
        readInCsv();
    }

    public static List<String> getColumnHeaders(String pathFile)
    {
        List<String>Headers = new ArrayList<>();
        String csvFile = pathFile;
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine();
            String[] data = line.split(cvsSplitBy);
            Headers.addAll(Arrays.asList(data));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Headers;
    }
    public static void readInCsv(){
        String csvFile = "./src/main/java/com/example/demo/csv/2019-10-28_1030_PhysiologicalDataLog.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                System.out.println(data[0] + data[3] + data[4] + data[5] + data[6] + data[7]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


