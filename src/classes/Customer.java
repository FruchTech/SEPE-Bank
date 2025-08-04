package classes;

import util.IDGenerator;

public class Customer {

    private String id;
    private String name;
    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public Customer() {
        this("Name");
    }

    public Customer(String name) {
        IDGenerator idGenerator = new IDGenerator();
        this.id = idGenerator.calculateID();
        this.name = name;
//        this.account = account;
    }
}
