package am.cs322;
import am.cs322.model.BankAccountDTO;
public interface BankService {
    BankAccountDTO createBankAccount(double balance);
    BankAccountDTO debit(Long accountID, double amount);
    BankAccountDTO credit(Long accountID, double amount);
}

