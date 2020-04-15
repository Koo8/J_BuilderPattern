package InputOutput;

import java.io.*;
import java.util.Scanner;

public class MainInOut {
    public static void main(String[] args) {

        // input from system
//        Scanner scanner = new Scanner(System.in);
//
//        while(scanner.hasNextLine()) {
//            String input = scanner.nextLine();
//            String[] parts = input.split("\\*");
//            int firstNumber = Integer.parseInt(parts[0]);
//            int secondNumber = Integer.parseInt(parts[1]);
//            System.out.println(firstNumber + " * " + secondNumber + " =" + firstNumber*secondNumber);
//
//        }

        File file = new File("text.txt");
        writeFile();
        readFile(file);

        outputObject();
    }


    private static void writeFile() {
//        System.out.println("the file path is " + file.getAbsoluteFile());
        try {
            FileOutputStream outputStream = new FileOutputStream("text.txt");
            outputStream.write("Hello \n this is a great day \n to metion the honor \n of all the help we get".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("can't write on file");
        }
    }
    private static String readFile(File file) {
        String line = "";
        String output = "";
        // use try with resources approach, this will not need to close reader, and not need to use finally clause.
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){

            while((line = reader.readLine()) != null) { // VERY IMPORTANT: the (line=reader.readline()) has to be defined within the while(), if it is moved into the {}, all odd lines won't be copied.
                output += line;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);
        return output;
    }

    // Serializable from SimpleObject // if the class SimpleObject is not serializable, the "notserializableException" will occur
    private static void outputObject() {

        // try with  resources approach to avoid close(); // put outputstream and inputstream inside the same block
        try(ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(new File("obj.ser")))) {
            objOutputStream.writeObject(new SimpleObject("this is the conent", 3, 2, 11));

            try(ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("obj.ser"))){
                SimpleObject data = (SimpleObject) objInputStream.readObject();
                System.out.println(data);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
