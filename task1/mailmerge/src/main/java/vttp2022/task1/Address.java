package vttp2022.task1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Address {

    private Map<String, List<List<String>>> dataSet = new HashMap<>(); 

    public void read(String data) {

        if ((null == data) || (data.trim().length() <= 0))
            return;

        String[] fields = data.split(",");
        String firstName = removeQuotes(fields[0]);
        String lastName = removeQuotes(fields[1]);
        String addresses = removeQuotes(fields[2]);
        String years = removeQuotes(fields[3]);

        //System.out.printf("%s: %s, %s, %s\n", salutations, lastName, packageName, price);
        
        addToReport(firstName, lastName, addresses, years);
    }

    private String removeQuotes(String s) {
        return s.replaceAll("\"", "");
    } 

    public void generateReport() {
        for (String firstNames : dataSet.keySet()) {
            List<List<String>> entry = dataSet.get(firstNames);
            System.out.printf("%s\n\n", entry.get(1));
            System.out.printf("Dear %s,\n\n", firstNames);
            System.out.printf("Thank you for staying with us over these %s years.\n\n", entry.get(2));     
        }
    }

    private void addToReport(String firstName, String lastName, String addresses, String years) {
        if (!dataSet.containsKey(firstName)) {
            dataSet.put(firstName, mkEntry());
        }
        List<List<String>> entry = dataSet.get(firstName);
        entry.get(0).add(lastName);
        entry.get(1).add(addresses);
        entry.get(2).add(years);
    }

   private List<List<String>> mkEntry() {
        List<List<String>> catList = new LinkedList<>();
        // 0 - package name, 1 - salutation , 2 - price
        for (int i = 0; i < 3; i++)
            catList.add(new LinkedList<String>());
        return catList; 

   }

}
