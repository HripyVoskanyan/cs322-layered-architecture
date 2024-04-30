package am.cs322;

import am.cs322.model.CreateTransactionRequest;
import am.cs322.model.BankAccountDTO;
import am.cs322.model.CreateBankAccountRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/v1/accounts")

public class BankAccountControllerImpl implements BankAccountController {

    private final BankService accountService;

    public BankAccountControllerImpl(BankService accountService) {
        this.accountService = accountService;
    }

    @Override

    @PostMapping("/create")
    public BankAccountDTO createBankAccount(@RequestBody CreateBankAccountRequest request) {
        return accountService.createBankAccount(request.balance());
    }

    @Override
    @PostMapping("/debit")
    public BankAccountDTO debitAccount(@RequestBody CreateTransactionRequest request) {
        return accountService.debit(request.accountID(), request.amount());
    }

    @Override
    @PostMapping("/credit")
    public BankAccountDTO creditAccount(@RequestBody CreateTransactionRequest request) {
        return accountService.credit(request.accountID(), request.amount());
    }
}