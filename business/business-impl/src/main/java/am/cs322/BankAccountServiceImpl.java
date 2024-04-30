package am.cs322;

import am.cs322.model.BankAccount;
import am.cs322.model.BankAccountDTO;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Service implementation for bank account operations.
 */
@Service
public class BankAccountServiceImpl implements BankService {

    private final BankAccountRepository bankAccountRepository;

    /**
     * Constructs a BankAccountServiceImpl with a bank account repository.
     *
     * @param bankAccountRepository the repository used for bank account data access
     */
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    /**
     * Creates a new bank account with the given balance.
     *
     * @param balance the initial balance for the new account
     * @return the data transfer object representing the newly created bank account
     */
    @Override
    public BankAccountDTO createBankAccount(double balance) {
        BankAccount account = new BankAccount(balance);
        BankAccount savedAccount = bankAccountRepository.save(account);
        return new BankAccountDTO(savedAccount.getAccountID(), savedAccount.getBalance());
    }

    /**
     * Debits a specified amount from a bank account.
     *
     * @param accountID the ID of the account to debit
     * @param amount the amount to debit
     * @return the updated account information after the debit operation
     * @throws RuntimeException if the account is not found or balance is insufficient
     */
    @Override
    public BankAccountDTO credit(Long accountID, double amount) {
        Optional<BankAccount> accountOptional = bankAccountRepository.findById(accountID);
        BankAccount account = accountOptional.orElseThrow(() -> new RuntimeException("Account is not found"));

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            bankAccountRepository.save(account);
            return new BankAccountDTO(account.getAccountID(), account.getBalance());
        } else {
            throw new RuntimeException("Balance is not sufficient");
        }
    }

    /**
     * Credits a specified amount to a bank account.
     *
     * @param accountID the ID of the account to credit
     * @param amount the amount to credit
     * @return the updated account information after the credit operation
     * @throws RuntimeException if the account is not found
     */
    @Override
    public BankAccountDTO debit(Long accountID, double amount) {
        Optional<BankAccount> accountOptional = bankAccountRepository.findById(accountID);
        BankAccount account = accountOptional.orElseThrow(() -> new RuntimeException("Account is not found"));

        account.setBalance(account.getBalance() + amount);
        bankAccountRepository.save(account);
        return new BankAccountDTO(account.getAccountID(), account.getBalance());
    }
}
