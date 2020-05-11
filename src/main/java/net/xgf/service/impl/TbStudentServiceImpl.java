package net.xgf.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.xgf.mapper.TbDictMapper;
import net.xgf.mapper.TbExamMapper;
import net.xgf.mapper.TbStudentMapper;
import net.xgf.pojo.EasyUIDataGridResult;
import net.xgf.pojo.TbDict;
import net.xgf.pojo.TbDictExample;
import net.xgf.pojo.TbExam;
import net.xgf.pojo.TbExamExample;
import net.xgf.pojo.TbExamExample.Criteria;
import net.xgf.pojo.TbStudent;
import net.xgf.pojo.TbStudentExample;
import net.xgf.service.TbStudentService;
import net.xgf.utils.FjnyResult;

@Service
public class TbStudentServiceImpl implements TbStudentService {

	@Resource
	private TbStudentMapper tbStudentMapper;
	@Resource
	private TbExamMapper tbExamMapper;
	@Resource
	private TbDictMapper tbDictMapper;
	

	@Override
	public EasyUIDataGridResult getTbStudentList(int page, int rows) {
		PageHelper.startPage(page, rows);
		TbStudentExample tbStudentExample = new TbStudentExample();
		List<TbStudent> list = tbStudentMapper.selectByExample(tbStudentExample);

		for (int i = 0; i < list.size(); i++) {
			TbStudent tbStudent = list.get(i);
			
			TbExamExample tbExamExample = new TbExamExample();
			Criteria criteria = tbExamExample.createCriteria();
			if(null != tbStudent.getDeparment()&& null != tbStudent.getNumber()) {
			criteria.andDeparmentEqualTo(tbStudent.getDeparment());
			criteria.andNumberEqualTo(tbStudent.getNumber());
			List<TbExam> tbExams = tbExamMapper.selectByExample(tbExamExample);
			if (null != tbExams && tbExams.size() > 0) {
				TbExam tbExam = tbExams.get(0);
				tbStudent.setExamdate(tbExam.getExamdate());
				tbStudent.setExamtime(tbExam.getExamtime());
			}
			}
		}

		PageInfo<TbStudent> pageInfo = new PageInfo<TbStudent>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
		return easyUIDataGridResult;
	}

	@Override
	public FjnyResult addAndUpdateTbStudent(TbStudent student) {
		int i = -1;
		if (student.getId() != null) {
			 i = tbStudentMapper.updateByPrimaryKeySelective(student);
		}else {
				//存在数据 ,进行处理
				TbStudentExample studentExample = new TbStudentExample();
				studentExample.createCriteria().andStunameEqualTo(student.getStuname());
				studentExample.createCriteria().andExamcodeEqualTo(student.getExamcode());
				List<TbStudent> selectByExample = tbStudentMapper.selectByExample(studentExample);
				if(selectByExample != null && selectByExample.size() > 0) {
					return FjnyResult.build(500, "存在相同数据");
				}else {
					i = tbStudentMapper.insertSelective(student);
				}
		}
		if(i <= 0) {
			return FjnyResult.build(500, "添加或修改失败");
		}
		return FjnyResult.ok();
	}

	@Override
	public FjnyResult deleteTbStudent(List<Integer> ids) {
		
		if(ids != null && ids.size() > 0) {
			Integer integer = ids.get(0);
			TbStudent student = tbStudentMapper.selectByPrimaryKey(integer);
			
			TbDict tbDict = new TbDict();
			tbDict.setStatus("0");
			TbDictExample tbDictExample = new TbDictExample();
			net.xgf.pojo.TbDictExample.Criteria createCriteria = tbDictExample.createCriteria();
			createCriteria.andDeparmentEqualTo(student.getDeparment());
			createCriteria.andNumberEqualTo(student.getNumber());
			createCriteria.andSeatnumberEqualTo(student.getSeatnumber());
			tbDictMapper.updateByExampleSelective(tbDict , tbDictExample );
			
			student.setMobile(null);
			student.setDeparment(null);
			student.setNumber(null);
			student.setSeatnumber(0);
			student.setHeadurl(null);
			student.setHealthurl(null);
			student.setExamdate(null);
			student.setExamtime(null);
			student.setIdcard(null);
			tbStudentMapper.updateByPrimaryKey(student);
		
		}
		 return FjnyResult.ok();
	}

	@Override
	public EasyUIDataGridResult getTbStudentList(int page, int rows,String stuname,String examcode,String deparment) {
		PageHelper.startPage(page, rows);
		TbStudentExample tbStudentExample = new TbStudentExample();
		if(null != stuname && !"".equals(stuname)) {
		tbStudentExample.createCriteria().andStunameLike("%" + stuname + "%");
		}
		if(null != examcode && !"".equals(examcode)) {
			tbStudentExample.createCriteria().andExamcodeLike("%" +examcode  + "%");
		}
		if(null != deparment && "wbm".equals(deparment)) {
			tbStudentExample.createCriteria().andDeparmentIsNull();
		}
		if(null != deparment && "ybm".equals(deparment)) {
			tbStudentExample.createCriteria().andDeparmentIsNotNull();
		}
		List<TbStudent> list = tbStudentMapper.selectByExample(tbStudentExample);

		for (int i = 0; i < list.size(); i++) {
			TbStudent tbStudent = list.get(i);
			
			TbExamExample tbExamExample = new TbExamExample();
			Criteria criteria = tbExamExample.createCriteria();
			if(null != tbStudent.getDeparment()&& null != tbStudent.getNumber()) {
			criteria.andDeparmentEqualTo(tbStudent.getDeparment());
			criteria.andNumberEqualTo(tbStudent.getNumber());
			List<TbExam> tbExams = tbExamMapper.selectByExample(tbExamExample);
			if (null != tbExams && tbExams.size() > 0) {
				TbExam tbExam = tbExams.get(0);
				tbStudent.setExamdate(tbExam.getExamdate());
				tbStudent.setExamtime(tbExam.getExamtime());
			}
			}
		}

		PageInfo<TbStudent> pageInfo = new PageInfo<TbStudent>(list);
		long total = pageInfo.getTotal();
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total, list);
		return easyUIDataGridResult;
	}

	@Override
	public List<TbStudent> getAllTbStudentList() {
		TbStudentExample tbStudentExample = new TbStudentExample();
		List<TbStudent> list = tbStudentMapper.selectByExample(tbStudentExample);

		for (int i = 0; i < list.size(); i++) {
			TbStudent tbStudent = list.get(i);
			
			TbExamExample tbExamExample = new TbExamExample();
			Criteria criteria = tbExamExample.createCriteria();
			if(null != tbStudent.getDeparment()&& null != tbStudent.getNumber()) {
			criteria.andDeparmentEqualTo(tbStudent.getDeparment());
			criteria.andNumberEqualTo(tbStudent.getNumber());
			List<TbExam> tbExams = tbExamMapper.selectByExample(tbExamExample);
			if (null != tbExams && tbExams.size() > 0) {
				TbExam tbExam = tbExams.get(0);
				tbStudent.setExamdate(tbExam.getExamdate());
				tbStudent.setExamtime(tbExam.getExamtime());
			}
			}
		}
		
		return list;
	}
}
