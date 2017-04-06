// created initial file with 20 numbers, this reads file sorts numbers and enters into new file.
//then completes a binary search to find index of number entered in function.

import java.io.*; //import java.io libraries
import java.util.*; //import java.util libraries


public class FileTasks {
    public static void main(String [] args) {
        String fileName = "C:\\Users\\ahinde\\IdeaProjects\\HelloApp2\\src\\text2.txt";
        //read initial file and print out data
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        List<Integer> dataList = new ArrayList<Integer>(); // declare ArrayList to add data to.
        List<Integer> sortedDataList = new ArrayList<Integer>(); // declare ArrayList to add data to.


        try {
            String line = null;
            while ((line = br.readLine()) != null) { // read the file.
                System.out.println(line); // print the result.
                dataList.add(Integer.valueOf(line)); //Add each line to ArrayList.
            }

            Collections.sort(dataList); //sort the data.
            System.out.println(dataList.toString()); // print the result of sorted list.

            //Write the result to a file.
            FileWriter fw = new FileWriter("C:\\Users\\ahinde\\IdeaProjects\\HelloApp2\\src\\newtext.txt");
            for (int x = 0; x < dataList.size(); x++)
            {
                fw.write(Integer.toString(dataList.get(x)));
                fw.write("\n");
            }
            fw.close();

            //Search for a specific integer within the array.
            FileReader rf = new FileReader("C:\\Users\\ahinde\\IdeaProjects\\HelloApp2\\src\\newtext.txt");
            BufferedReader rb = new BufferedReader(rf);
            while ((line = rb.readLine()) != null) { // read the file.
                sortedDataList.add(Integer.valueOf(line));
                System.out.println(line);
            }
            binarySearch(21, sortedDataList);
            }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static int binarySearch(int numberToSearch, List<Integer> sortedDataList) {
        int low = 0;
        int high = sortedDataList.size() - 1;
        int indexValue = -2;
        System.out.println("Current data list size is " + sortedDataList.size());
         while(high >= low) {
             int middle = (low + high) / 2;

             if(sortedDataList.get(middle) == numberToSearch) {
                  indexValue = sortedDataList.indexOf(middle);
                  System.out.println("The data was found at index " + middle);
                  break;
                }
               if(sortedDataList.get(middle) < numberToSearch) {
                      low = middle + 1;
                   }
              if(sortedDataList.get(middle) > numberToSearch) {
                       high = middle - 1;
              }
           }
           return indexValue;
    }
}

