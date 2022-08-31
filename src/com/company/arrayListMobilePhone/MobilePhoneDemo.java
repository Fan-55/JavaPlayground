package com.company.arrayListMobilePhone;

import java.util.Scanner;

public class MobilePhoneDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {
        startPhone();
        printActions();
        boolean quite = false;
        while (!quite) {
            System.out.println("\nEnter action:");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    quite = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new contact phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone number = " + phoneNumber);
            return;
        }
        System.out.println("Cannot add, " + name + " already on file");
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newContactName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newContactNumber = scanner.nextLine();
        if (mobilePhone.updateContact(existingContact, Contact.createContact(newContactName, newContactNumber))) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Successfully removed record");
        } else {
            System.out.println("Error removing record");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContact.getName());
        System.out.println("Number: " + existingContact.getPhoneNumber());
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void printActions() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add existing contact\n" +
                "3 - to update existing contact\n" +
                "4 - to remove existing contact\n" +
                "5 - to query if and existing contact exists\n" +
                "6 - to list available actions\n");
    }

    private static void startPhone() {
        System.out.println("Starting phone ...");
    }
}
