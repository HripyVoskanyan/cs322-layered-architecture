package am.cs322;

import am.cs322.model.BankAccountDTO;
import am.cs322.model.CreateBankAccountRequest;
import am.cs322.model.CreateTransactionRequest;

public interface BankAccountController {
    BankAccountDTO createBankAccount(CreateBankAccountRequest request);
    BankAccountDTO debitAccount(CreateTransactionRequest request);
    BankAccountDTO creditAccount(CreateTransactionRequest request);
}
