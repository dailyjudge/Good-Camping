package com.project.camping.account;

import java.util.Map;

public interface AccountMapper {

	int accountRegDoIt(AccountDTO ac);

	AccountDTO getAccountById(AccountDTO a);

	int getIdCheck(String ac_id2);

	String GoFindId(Map<String, String> findId);

	AccountDTO selectAccount(String ac_id);

	int updatePw(Map<String, String> findPw);

	AccountDTO getAccountByEmail(String email);


}
