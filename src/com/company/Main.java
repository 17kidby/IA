package com.company;
import java.io.File;
import java.util.Scanner;


public class Main {

    public static void addToPlant(){
        Scanner user = new Scanner(System.in);

        System.out.println("Name: ");
        FileHandler.appendLine("name.txt", user.nextLine());

        System.out.println("Location: ");
        FileHandler.appendLine("location.txt", user.nextLine());

        System.out.println("Period of flowering (write the months): ");
        FileHandler.appendLine("time.txt", user.nextLine());


        System.out.println("Main colour: ");
        FileHandler.appendLine("colours.txt", user.nextLine());

    }

    public static void viewPlants(){
        System.out.println("List of plants: ");

        for (int i=0; i<FileHandler.countLines("name.txt"); i++){
            System.out.print((i+1) + ") " + FileHandler.readLine("name.txt", i) + ", ");
            System.out.print(FileHandler.readLine("location.txt", i) + ", ");
            System.out.print(FileHandler.readLine("time.txt", i) + ", ");
            System.out.print(FileHandler.readLine("colours.txt", i) + ", ");
            System.out.println(" ");
        }
        System.out.println("    ");
        System.out.println("    ");
    }

    public static void removePlants(){
        viewPlants();
        System.out.println("Which line do you want to delete? ");

    }



    public static void main(String[] args) {

        // test the database works
        System.out.println("Database (type 'end' to end)");
        dataBase db = new dataBase("test.txt");
       // dataBase names = new dataBase("name.txt", 10);
        //dataBase location = new dataBase("location.txt", 10);
        //dataBase time = new dataBase("time.txt", 10);
        //dataBase colours = new dataBase("colours.txt", 10);
       // db.appendRecord("1.ABCDEFGH");
       // db.appendRecord("2.ABCDEFGH");
       // db.appendRecord("3.ABCDEFGH");
       // db.appendRecord("4.ABCDEFGH");
       // System.out.println(db.getRecord(2));	 // should be "3.ABCDEFGH"
       // System.out.println(db.findRecord("EBCDEFGHIJ")); // false
       // System.out.println(db.findRecord("2.ABCDEFGH")); // true
       // System.out.println("count = " + db.getRecordCount()); // 4
        //db.appendRecord("sans");
        //db.appendRecord("jesus");
        FileHandler.appendLine("test.txt", "osadifj");
        System.out.println(FileHandler.countLines("test.txt"));
        System.out.println(FileHandler.readLine("test.txt", 0));
        System.out.println(FileHandler.readLine("test.txt", 1));
        System.out.println(FileHandler.readLine("test.txt", 2));
        FileHandler.writeLineAt("test.txt", "qweqw", 1);
        FileHandler.writeLineAt("test.txt", "qweqw", 0);
        System.out.println(FileHandler.countLines("test.txt"));

        Scanner user = new Scanner(System.in);
        String option = "";

        while (!option.equals("end")) {
            System.out.println("1. Add ");
            System.out.println("2. Edit");
            System.out.println("3. View");
            System.out.println("4. Delete");
            option = user.next();

            if (option.equals("1")) {
                addToPlant();
            }

            if (option.equals("3")) {
                viewPlants();
            }

            if (option.equals("4")){
                removePlants();
            }

        }











    }
}
