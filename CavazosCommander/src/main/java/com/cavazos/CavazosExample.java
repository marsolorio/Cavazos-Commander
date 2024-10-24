package com.cavazos;

import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CavazosExample {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = "";

    // Command loop
    while (!input.equals("q")) {
      // Display the menu
      System.out.println("Cavazos Commander Menu:");
      System.out.println("i - Issue a command");
      System.out.println("l - List all commands");
      System.out.println("u - Undo last command");
      System.out.println("r - Redo last command");
      System.out.println("q - Quit");

      // Get user input
      input = scanner.nextLine();

      // Handle user input
      switch (input) {
        case "i":
          issueRandomCommand();
          break;
        case "l":
          listAllCommands();
          break;
        case "u":
          undoLastCommand();
          break;
        case "r":
          redoLastCommand();
          break;
        case "q":
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid input. Please try again.");
      }
    }

    scanner.close(); // Close the scanner to prevent resource leak
  }

  // Function to issue a random command from commands.json
  private static void issueRandomCommand() {
    try {
      JSONParser parser = new JSONParser();
      FileReader reader = new FileReader(CavazosExample.class.getClassLoader().getResource("commands.json").getFile());
      JSONArray commands = (JSONArray) parser.parse(reader);
      Random random = new Random();
      int randomIndex = random.nextInt(commands.size());
      System.out.println("Issued Command: " + commands.get(randomIndex));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Function to list all commands from commands.json
  private static void listAllCommands() {
    try {
      JSONParser parser = new JSONParser();
      FileReader reader = new FileReader(CavazosExample.class.getClassLoader().getResource("commands.json").getFile());
      JSONArray commands = (JSONArray) parser.parse(reader);
      System.out.println("List of Commands:");
      for (Object command : commands) {
        System.out.println(command);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Placeholder for undo command
  private static void undoLastCommand() {
    System.out.println("Undo functionality not implemented yet.");
  }

  // Placeholder for redo command
  private static void redoLastCommand() {
    System.out.println("Redo functionality not implemented yet.");
  }
}
