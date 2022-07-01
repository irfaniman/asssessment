package vttp2022.task1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TourPackages {

    private Map<String, List<List<String>>> dataSet = new HashMap<>(); 

    public void read(String data) {

        if ((null == data) || (data.trim().length() <= 0))
            return;

        String[] fields = data.split(",");
        String salutations = removeQuotes(fields[0]);
        String lastName = removeQuotes(fields[1]);
        String packageName = removeQuotes(fields[2]);
        String price = removeQuotes(fields[3]);

        //System.out.printf("%s: %s, %s, %s\n", salutations, lastName, packageName, price);
        
        addToReport(lastName, packageName, salutations, price);
    }

    private String removeQuotes(String s) {
        return s.replaceAll("\"", "");
    } 

    public void generateReport() {
        for (String name : dataSet.keySet()) {
            List<List<String>> entry = dataSet.get(name);
            System.out.printf("Dear %s. %s", entry.get(1).toString(), name);
            System.out.printf("\nThank you for your interest in our new %s package!\n", entry.get(0));
            System.out.printf("For the 2022 Spring promotion, you can sign up for the low low price of $%s\n", entry.get(2));
            System.out.println("Safe Travels!\n");      
        }
    }

    private void addToReport(String lastName, String packageName, String salutations, String price) {
        if (!dataSet.containsKey(lastName)) {
            dataSet.put(lastName, mkEntry());
        }
        List<List<String>> entry = dataSet.get(lastName);
        entry.get(0).add(packageName);
        entry.get(1).add(salutations);
        entry.get(2).add(price);
    }

   private List<List<String>> mkEntry() {
        List<List<String>> catList = new LinkedList<>();
        // 0 - package name, 1 - salutation , 2 - price
        for (int i = 0; i < 3; i++)
            catList.add(new LinkedList<String>());
        return catList; 

   }

}
