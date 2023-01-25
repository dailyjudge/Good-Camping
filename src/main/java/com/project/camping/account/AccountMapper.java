package com.project.camping.account;

import java.util.Map;

public interface AccountMapper {

	int accountRegDoIt(AccountDTO ac);

	AccountDTO getAccountById(AccountDTO a);

	int getIdCheck(String ac_id2);

	String GoFindId(Map<String, String> findId);

	AccountDTO selectAccount(String ac_id);

	int updatePw(AccountDTO a);

	AccountDTO getAccountByEmail(String email);

	int addUserSession(AccountDTO a2);

	AccountDTO getAccountByCookie(AccountDTO loginDTO);

	String doubleCheckPw(String ac_id);



}
