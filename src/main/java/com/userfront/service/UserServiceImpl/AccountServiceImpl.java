package com.userfront.service.UserServiceImpl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.PrimaryAccountDao;
import com.userfront.dao.SavingsAccountDao;
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.PrimaryTransaction;
import com.userfront.domain.SavingsAccount;
import com.userfront.domain.User;
import com.userfront.service.AccountService;
import com.userfront.service.UserService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;
    

    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }
    
    public void deposit(String accountType, double amount, Principal principal) {
    	User user = userService.findByUsername(principal.getName());
    	
    	if("Primary".equalsIgnoreCase(accountType)) {
    		PrimaryAccount primaryAccount = user.getPrimaryAccount();
    		primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
    		primaryAccountDao.save(primaryAccount);
    		
    		Date date = new Date();
    		PrimaryTransaction transaction = new PrimaryTransaction(date, "Deposit to primary account", accountType, "OK", amount, primaryAccount.getAccountBalance());
    		
    	} else if("Savings".equalsIgnoreCase(accountType)) {
    		SavingsAccount savingsAcc = user.getSavingsAccount();
    		savingsAcc.setAccountBalance(savingsAcc.getAccountBalance().add(new BigDecimal(amount)));
    		savingsAccountDao.save(savingsAcc);
    		
    		Date date = new Date();
    		PrimaryTransaction transaction = new PrimaryTransaction(date, "Deposit to savings account", accountType, "OK", amount, savingsAcc.getAccountBalance());
    		
    	}
    }
    
    private int accountGen() {
        return ++nextAccountNumber;
    }

}
