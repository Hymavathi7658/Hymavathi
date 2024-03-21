package com.firstSpringProject;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class AccountDao {
	@Autowired
	
	public HibernateTemplate hibernateTemplate;
	@Transactional
	public void createAccount(AccountEntity account) {
		hibernateTemplate.save(account);
	}
	public List<AccountEntity> getAllAccounts(){
		return hibernateTemplate.loadAll(AccountEntity.class);
		
	}
	public AccountEntity getAccountDetails(Long accNo){
		return hibernateTemplate.get(AccountEntity.class,accNo );
	}
	@Transactional
	public void updateAccount(AccountEntity account) {
		hibernateTemplate.update(account);
	}
	
	@Transactional
	public void deleteAccount(Long accNo) {
		AccountEntity ac=	hibernateTemplate.get(AccountEntity.class,accNo);
		hibernateTemplate.delete(ac);
	}
}
