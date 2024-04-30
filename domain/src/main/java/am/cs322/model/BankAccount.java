package am.cs322.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Represents a bank account with an ID and a balance.
 */
@Entity
@Table(name = "\"account\"")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    private double balance;

    /**
     * Constructs a new BankAccount with a specified balance.
     *
     * @param balance the initial balance of the account
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Default constructor for JPA.
     */
    public BankAccount() {
        // Default constructor is needed for JPA.
    }

    /**
     * Checks if this BankAccount is equal to another object.
     *
     * @param o the object to compare with this BankAccount
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(accountID, that.accountID);
    }

    /**
     * Generates a hash code for this BankAccount.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountID, balance);
    }

    // Getters and setters

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
