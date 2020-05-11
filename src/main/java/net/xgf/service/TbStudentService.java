package net.xgf.service;

import java.util.List;

import net.xgf.pojo.EasyUIDataGridResult;
import net.xgf.pojo.TbStudent;
import net.xgf.utils.FjnyResult;

public interface TbStudentService {
	EasyUIDataGridResult getTbStudentList(int page,int rows);
	List<TbStudent> getAllTbStudentList();
	FjnyResult addAndUpdateTbStudent(TbStudent student);
	FjnyResult deleteTbStudent(List<Integer> ids);
	EasyUIDataGridResult getTbStudentList(int page,int rows,String stuname,String examcode,String deparment);
}
