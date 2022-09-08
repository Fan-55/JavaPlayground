package com.company.abstractClassChallenge;

public class abstractClassDemo {
    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList(null);
//        myLinkedList.traverse();
//
//        String citiesString = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
//        String[] citiesArray = citiesString.split(" ");
//        for (String city : citiesArray) {
//            myLinkedList.addItem(new Node(city));
//        }
//        myLinkedList.traverse();

//        String numbersString = "5 7 3 9 8 2 1 0 4 6";
//        String[] numbersArray = numbersString.split(" ");
//        for (String number : numbersArray) {
//            myLinkedList.addItem(new Node(number));
//        }
//        myLinkedList.traverse(myLinkedList.getRoot());
//        myLinkedList.removeItem(new Node("3"));
//        myLinkedList.traverse(myLinkedList.getRoot());

        SearchTree tree = new SearchTree(null);
        String citiesString = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] citiesArray = citiesString.split(" ");
        for (String city : citiesArray) {
            tree.addItem(new Node(city));
        }
        tree.traverse(tree.getRoot());
    }
}
