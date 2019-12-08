package com.patient.simulators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class ReadCsvFile extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ReadCsvFile.class, args);
        System.out.println( "Read CSV running");
        System.out.println(System.getProperty("user.dir"));
        readInCsv();
    }

    public static List<String> getColumnHeaders(String pathFile)
    {
        List<String>Headers = new ArrayList<>();
        String csvFile = pathFile;
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine();
            String[] data = line.split(csvSplitBy);
            Headers.addAll(Arrays.asList(data));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Headers;
    }
    public static void readInCsv(){
        String csvFile = "./src/main/java/com/patient/simulators/csv/2019-10-28_1030_PhysiologicalDataLog.csv";
        //String csvFile = "./csv/2019-10-28_1030_PhysiologicalDataLog.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println(data[0] + data[3] + data[4] + data[5] + data[6] + data[7]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


