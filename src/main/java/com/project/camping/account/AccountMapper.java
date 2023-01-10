package com.project.camping.account;

public interface AccountMapper {

	int accountRegDoIt(AccountDTO ac);

	AccountDTO getAccountById(AccountDTO a);

	String getIdCheck(String ac_id2);


}
