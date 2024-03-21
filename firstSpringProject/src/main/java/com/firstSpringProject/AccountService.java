package com.firstSpringProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
	@Autowired
	private AccountDao accountdao;
	
	public void createAccount(AccountEntity account) {
		accountdao.createAccount(account);
	}
	public List<AccountEntity> getAllAccounts(){
		return accountdao.getAllAccounts();
	}
	public AccountEntity getAccountDetails(Long accNo){
		return accountdao.getAccountDetails(accNo);
	}
	
	public void updateAccount(AccountEntity account) {
		accountdao.updateAccount(account);
	}
	
	public void deleteAccount(Long accNo) {
		accountdao.deleteAccount(accNo);
	}
}
