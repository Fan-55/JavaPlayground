package com.company.arrayListBank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            System.out.println("Customer details for branch " + branchName);
            ArrayList<Customer> customers = existingBranch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer currentCustomer = customers.get(i);
                System.out.println("Customer: " + currentCustomer.getName() + " [" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = currentCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String targetBranchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch checkedBranch = branches.get(i);
            if (checkedBranch.getName().equals(targetBranchName)) {
                return checkedBranch;
            }
        }
        return null;
    }
}
