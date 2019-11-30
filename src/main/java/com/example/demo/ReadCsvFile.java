package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@SpringBootApplication
public class ReadCsvFile {

    public static void main(String[] args) {
        SpringApplication.run(ReadCsvFile.class, args);
        System.out.println( "Read CSV running");
        readInCsv();
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


