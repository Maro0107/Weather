package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    private EntryController entryController = new EntryController();

    public void run() {
        System.out.println("Application is running");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Adding location");
            System.out.println("0. Close application");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewEntry();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void addNewEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide location:");
        String location = scanner.nextLine();
        String httpResponseBody = entryController.createNewEntry(location);
        System.out.println("Response from server: " + httpResponseBody);
        System.out.println();
    }
}
