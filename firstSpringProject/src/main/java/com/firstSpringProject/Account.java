package com.firstSpringProject;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/account")
public class Account {

	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping("/msg")
	public String displayMsg() 
	{
		return "home";
	}
	@PostMapping("/accounts")
	@ResponseBody
	public String createAccount(@RequestBody AccountEntity account) {
		accountService.createAccount(account);
		return "succes";
	}
	@GetMapping("/accounts")
	@ResponseBody
	public List<AccountEntity> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	@GetMapping("/accounts/{accNo}")
	@ResponseBody
	public AccountEntity getAccountDetails(@PathVariable Long accNo){
		return accountService.getAccountDetails(accNo);
	}
	@PutMapping("/accounts/{accNo}")
	@ResponseBody
	public String updateAccount(@RequestBody AccountEntity account) {
		accountService.updateAccount(account);
		return "succes";
	}
	
	@DeleteMapping("/accounts/{accNo}")
	@ResponseBody
	public String deleteAccount(@PathVariable Long accNo) {
		accountService.deleteAccount(accNo);
		return "succes";
	}
	
	
	
	 

}
