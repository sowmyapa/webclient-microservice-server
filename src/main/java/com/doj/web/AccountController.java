/**
 * 
 */
package com.doj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *
 */
@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	@RequestMapping("/accountList")
	public List<Account> accountList(Model model) {
		model.addAttribute("accounts", accountRepository.getAllAccounts());
		return accountRepository.getAllAccounts();
	}
	
	@RequestMapping("/accountDetails")
	public Account accountDetails(@RequestParam("number") String id, Model model) {
		model.addAttribute("account", accountRepository.getAccount(id));
		return accountRepository.getAccount(id);
	}
}
