package com.company;

import java.io.*;
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
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "r")) {
            rf.seek(start);
            String read = rf.readLine();
            return read;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readLine(String fileName, int lineStart){
        String read = "";
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "r")) {
            for(int i=0; i<lineStart; i++){
                rf.readLine();
            }
            return rf.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void readTheWholeThing(String fileName) {
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

        //ArrayList<String> data = FileHandler.makeArray(fileName);
        //data.add(start, toAdd);

        boolean append = false;

        int lines = countLines(fileName);
        String[] Data = new String[lines + 1];


        for (int i=0; i<start; i++){
            if (readLine(fileName, i)!=null) {
                Data[i] = readLine(fileName, i);
            }else{
                Data[i] = "";
            }
        }
        Data[start] = toAdd;
        for (int i=start+1; i<=lines; i++){
            if (readLine(fileName, i)!=null) {
                Data[i] = readLine(fileName, i-1);
            }else{
                Data[i] = "";
            }
        }

        for (int i=0; i< Data.length; i++){
            System.out.println(Data[i]);
        }



        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
                //RandomAccessFile rf = new RandomAccessFile(fileName, "rws");



            for (int i=0; i< Data.length; i++){

                if (Data[i]!=null){
                    bw.write(Data[i]);
                    bw.newLine();
                }
            }



            bw.close();
            fw.close();



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


