package com.project.camping.account;

import java.util.HashMap;
import java.util.Map;

public interface AccountMapper {

	int accountRegDoIt(AccountDTO ac);

	AccountDTO getAccountById(AccountDTO a);

	String getIdCheck(String ac_id2);

	String GoFindId(Map<String, String> findId);

	AccountDTO selectAccount(String ac_id);


}
