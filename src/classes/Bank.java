package classes;

import util.MessageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private List<Customer> customerList = new ArrayList<>();
    private List<Account> accountList = new ArrayList<>();

    private final MessageManager messager = new MessageManager();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customers) {
        this.customerList = customers;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accounts) {
        this.accountList = accounts;
    }

    public Bank() {
        startMainMenu();
    }

    public Bank(List<Customer> customers, List<Account> accounts) {
        this.customerList = new ArrayList<>(customers);
        this.accountList = new ArrayList<>(accounts);
        startMainMenu();
    }


    public void startMainMenu() {

        Scanner scanner = new Scanner(System.in);

        messager.sendBankHomeMessage();

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "R":
                    System.out.println("Register selected.");
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter your PIN: ");
                    int pin = Integer.parseInt(scanner.nextLine().trim());
                    registerNewCustomer(name, pin);
                    break;

                case "L":
                    System.out.println("Login selected.");
                    break;
                case "E":
                    System.out.println("You were logged out of your current session. Goodbye! \n");
                    messager.sendBankHomeMessage();
                    break;
                default:
                    System.out.println("Invalid input, please attempt again!");
            }
        }
    }

    private void registerNewCustomer(String name, int pin) {
        Customer customer = new Customer(name);
        Account account = new Account(pin, customer, 0);

        customerList.add(customer);
        accountList.add(account);

        System.out.println("Customer " + name + " registered successfully.");
        System.out.println(getCustomerList());
        System.out.println(getAccountList());
    }

}
