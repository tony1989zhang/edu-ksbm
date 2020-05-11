package net.xgf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import net.xgf.mapper.TbUserMapper;
import net.xgf.pojo.TbUser;
import net.xgf.pojo.TbUserExample;
import net.xgf.pojo.TbUserExample.Criteria;
import net.xgf.service.TbUserService;
import net.xgf.utils.FjnyResult;

@Service
public class TbUserServiceImpl implements TbUserService {
	@Resource
	private TbUserMapper tbUserMapper;
	
	
	@Override
	public FjnyResult doLogin(HttpSession session,String username, String password) {
		
		
		TbUserExample userExample = new TbUserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andAccountEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<TbUser> list = tbUserMapper.selectByExample(userExample);
		if(null != list && list.size()>0) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("username", username);
			map.put("password", password);
			session.setAttribute("userInfo", map);
			return FjnyResult.ok(map);
		}
		
		
		return FjnyResult.build(500, "账号或密码不对");
	}
}
