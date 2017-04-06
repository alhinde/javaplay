//creating file and adding Data to a txt file, and printing result.

import java.io.*; //importing all java.io libraries

public class HelloApp {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "C:\\Users\\ahinde\\IdeaProjects\\HelloApp2\\src\\test.txt";
        int number = 1;
        int number2 = 35;
        try {

            FileWriter fw =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bw =
                    new BufferedWriter(fw);

            // Note that write() does not automatically
            // append a newline character.
            bw.write(Integer.toString(number));
            bw.newLine();
            bw.write(Integer.toString(number2));
            bw.newLine();
            bw.write(Integer.toString(number + number2));
            bw.newLine();
            bw.write("are you between the ABOVE ages");
            bw.write(" i bet are BRAH");
            bw.newLine();
            bw.write("if not you old YEH");

            bw.close();

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}

