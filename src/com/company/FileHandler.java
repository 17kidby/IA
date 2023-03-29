package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;


public class FileHandler {

    public static void appendLine(String fileName, String data) {
        // write text to end of the file
        boolean append = true;
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLineAt(String fileName, int start) {
        // grab the line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            return rf.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void readTheWholeThing(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList makeArray(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
            ArrayList<String> data = new ArrayList<>();
            String line = br.readLine();
            while (line != null){
                data.add(line);
                line = br.readLine();
            }
            return data;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeLineAt(String fileName, String toAdd, int start) {
        // overwrite a line from position "start" in the file
        // doesn't check that the start position is actually
        // the beginning of the file. This will not behave well
        // unless every line is the same length

        // use random file access instead of buffered reader

        ArrayList<String> data = FileHandler.makeArray(fileName);
        data.add(start, toAdd);


        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
                //RandomAccessFile rf = new RandomAccessFile(fileName, "rws");



            for (int i =0; i<data.size(); i++)
                pw.println(data.get(i));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int countLines(String fileName) {
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            while (line != null){
                count++;
                line = br.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        // return the number of lines in the file
        return count;
    }


}


