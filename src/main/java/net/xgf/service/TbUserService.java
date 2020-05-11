package net.xgf.service;

import javax.servlet.http.HttpSession;

import net.xgf.utils.FjnyResult;

public interface TbUserService {
	FjnyResult doLogin(HttpSession session,String username,String password);
}
