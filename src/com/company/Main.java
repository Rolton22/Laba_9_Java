package com.company;

import Classes.JSONGetter;
import Classes.Quote;
import Classes.Quotes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        Quotes quotes1 = new Quotes();

        if (quotes1.downloadQuotes()) {


            System.out.println("Quotes for ID:\n" + quotes1);


            System.out.println("\n-------------------Sorting----------------------\n");

            quotes1.getQuotes().sort(Quote.byIDValueAsc);
            System.out.println("After sorting by ID ascending:\n" + quotes1);
            quotes1.getQuotes().sort(Quote.byIDValueDesc);
            System.out.println("After sorting by ID descending:\n" + quotes1);

            quotes1.getQuotes().sort(Quote.byTextLengthAsc);
            System.out.println("After sorting by Text Length ascending:\n" + quotes1);

            quotes1.getQuotes().sort(Quote.byTextLengthDesc);
            System.out.println("After sorting by Text Length descending:\n" + quotes1);

            quotes1.getQuotes().sort(Quote.byTextAsc);
            System.out.println("After sorting by first letter ascending:\n" + quotes1);

            quotes1.getQuotes().sort(Quote.byTextDesc);
            System.out.println("After sorting by first letter descending:\n" + quotes1);

            System.out.println("To search for identical word input desired word:");
            // String str = scanner.nextLine();
//            System.out.println("Identical Words"+quotes1.getList("is"));
//            System.out.println(quotes1.getList("the"));

        } else {

            System.out.println("No data received");
        }
    }

}
