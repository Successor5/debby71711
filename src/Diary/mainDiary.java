package Diary;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class mainDiary {
    private static final Diary diary = new Diary();

    public static void main(String[] args) {

        mainMenu();
    }
    public static void mainMenu(){
        String menu = """
                ===========================
                1 -> CREATE ENTRY
                2 -> VIEW ENTRY
                3 -> EDIT ENTRY
                4 -> COUNT ENTRY
                5 -> DELETE ENTRY'
                6 -> EXIT'
                
                ===========================
                """;


        String userInput = input(menu);
        if (userInput.equals("")){
            display(" Please enter a valid option ");
        mainMenu();}
        switch (userInput.charAt(0)){
            case '1' -> createEntry();
            case '2' -> viewEntry();
             case '3'-> editEntry();
             case '4'-> countEntry();
            case '5' -> deleteEntry();
            case '6'-> Exit();
            default -> mainMenu();
        }
    }

    public static void Exit() {
        System.exit(0);

    }

    private static void deleteEntry() {
        try {
            int ID=Integer.parseInt(input("enter id of entry"));
            diary.deleteEntry(ID);
        }
        catch (IndexOutOfBoundsException error){
            display(error.getMessage());
        }
        display("entry deleted successfully");
        mainMenu();
    }

    private static void countEntry() {
        display(String.format("you have %d entry available", diary.entries.size()));
        mainMenu();
    }
    private static void editEntry() {
        String editDropDown = input("""
                ---------------------------
                1 ->> Edit your title
                2 ->> Edit your body
                ---------------------------
                """);
        switch (editDropDown.charAt(0)){
            case '1' ->{
                int ID= Integer.parseInt(input("enter your id"));
                try {
                    String title=input("enter diary title");
                    diary.editEntryTitle(title,ID);
                    diary.viewEntry(ID);
                }
                catch (IndexOutOfBoundsException error){
                    display(error.getMessage());
                    mainMenu();
                }
            }
            case '2' -> {
                int ID= Integer.parseInt(input("enter your id"));
                try {
                    String body=input("enter diary body");
                    diary.editEntryBody(body,ID);
                    diary.viewEntry(ID);
                }
                catch (IndexOutOfBoundsException error){
                    display(error.getMessage());
                    mainMenu();
                }

            }
        }

        mainMenu();
    }

    private static void viewEntry() {
        int ID = Integer.parseInt(input("enter your id"));
        try {
            String entryPage =  diary.viewEntry(ID);
           display(entryPage);
        }
        catch (IndexOutOfBoundsException e){
            display(e.getMessage());
        }
        mainMenu();
    }

    private static void createEntry() {
        String title = input("enter diary title");
        String body = input("enter diary body");
        diary.createEntry(title,body);

        display("Entry created successfully...");
        mainMenu();
    }

    public static String  input(String prompt){

        return JOptionPane.showInputDialog( prompt) ;

        }

    private static void display(String prompt) {

        JOptionPane.showMessageDialog(null, prompt);
    }
}

