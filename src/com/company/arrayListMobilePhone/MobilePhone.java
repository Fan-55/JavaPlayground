package com.company.arrayListMobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String phoneNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.myContacts = new ArrayList<>();
    }

    public void printContacts() {
        System.out.println("Contact list:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + "." +
                    myContacts.get(i).getName() + " -> " +
                    myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean addNewContact(Contact newContact) {
        if (findContact(newContact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(newContact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int oldContactPosition = findContact(oldContact);
        if (oldContactPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        if (findContact(newContact.getName()) >= 0) {
            System.out.println("New Contact " + newContact.getName() + " already exists. Update was not successful");
            return false;
        }
        myContacts.set(oldContactPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            myContacts.remove(position);
            System.out.println(contact.getName() + ", was not deleted.");
            return true;
        }
        System.out.println(contact.getName() + ", was not found.");
        return false;
    }

    public String queryContact(Contact targetContact) {
        if (findContact(targetContact) >= 0) {
            return targetContact.getName();
        }
        return null;
    }

    public Contact queryContact(String targetContactName) {
        int position = findContact(targetContactName);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    private int findContact(Contact targetContact) {
        return myContacts.indexOf(targetContact);
    }

    private int findContact(String targetContactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(targetContactName)) {
                return i;
            }
        }
        return -1;
    }
}
