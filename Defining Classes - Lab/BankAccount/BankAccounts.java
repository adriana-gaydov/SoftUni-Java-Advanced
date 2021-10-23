package BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccounts {
    private Map<Integer, BankAccount> users;

    public BankAccounts() {
        this.users = new LinkedHashMap<Integer, BankAccount>();
    }

    public void addNewBankAccount(BankAccount b) {
        users.putIfAbsent(b.getId(), b);
        System.out.println("Account ID" + b.getId() + " created");
    }

    public Map<Integer, BankAccount> getUsers() {
        return users;
    }

    public boolean isExist(int id) {
        if (!users.containsKey(id)) {
            System.out.println("Account does not exist");
        }
        return users.containsKey(id);
    }

    public void setUser(BankAccount b) {
        if (users.containsKey(b.getId())) {
            users.put(b.getId(), b);
        }
    }

    public BankAccount getUser(int id) {
        return users.get(id);
    }


}
