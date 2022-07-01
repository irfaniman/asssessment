package vttp2022.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) 
            throws IOException {

        String csv = args[0]; //for inputting csv file
        String template = args[1]; //for inputting template file

        TourPackages packages = new TourPackages();
        Address thankYou = new Address();

        Reader rcsv = new FileReader(csv);
        BufferedReader brcsv = new BufferedReader(rcsv);

        Reader rtemp = new FileReader(template);
        BufferedReader brtemp = new BufferedReader(rtemp);


        // Remove the first line
        String datacsv = brcsv.readLine();

        //Remove the first line
        String datatemp = brtemp.readLine();

        while (null != datacsv) {
            datacsv = brcsv.readLine();
            packages.read(datacsv);
        }

        packages.generateReport();

        while (null != datatemp) {
            datatemp = brtemp.readLine();
            thankYou.read(datatemp);
        }

        thankYou.generateReport();
    } 
} 