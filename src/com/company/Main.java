package com.company;
import java.io.File;


public class Main {



    public static void main(String[] args) {

        // test the database works
        System.out.println("Database");
        dataBase db = new dataBase("test.txt", 10);
       // db.appendRecord("1.ABCDEFGH");
       // db.appendRecord("2.ABCDEFGH");
       // db.appendRecord("3.ABCDEFGH");
       // db.appendRecord("4.ABCDEFGH");
       // System.out.println(db.getRecord(2));	 // should be "3.ABCDEFGH"
       // System.out.println(db.findRecord("EBCDEFGHIJ")); // false
       // System.out.println(db.findRecord("2.ABCDEFGH")); // true
       // System.out.println("count = " + db.getRecordCount()); // 4
        FileHandler.appendLine("test.txt", "sans");
        FileHandler.appendLine("test.txt", "jesus");
        FileHandler.writeLineAt("test.txt", "peor", 1);
    }
}
