package net.xgf.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.xgf.pojo.EasyUIDataGridResult;
import net.xgf.pojo.TbStudent;
import net.xgf.service.TbStudentService;
import net.xgf.utils.ExcelUtils;
import net.xgf.utils.FjnyResult;

@Controller
@RequestMapping("/student")
public class TbStudentController {
	
	@Autowired
	private TbStudentService tbStudentService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getTbStudentList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows,String stuname,String examcode,String deparment) {
		return tbStudentService.getTbStudentList(page, rows,stuname,examcode,deparment);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public FjnyResult delete(@RequestParam(value = "ids") List<Integer> ids) {
		return tbStudentService.deleteTbStudent(ids);
	}
	@RequestMapping("/save")
	@ResponseBody
	public FjnyResult save(TbStudent student) {
		return  tbStudentService.addAndUpdateTbStudent(student);
	}
	
	
	@RequestMapping("/excepImport")
	@ResponseBody
	public FjnyResult excepImport(@RequestParam("uploadExcel") CommonsMultipartFile uploadExcel) {
		try {
			InputStream is = uploadExcel.getInputStream();
			List<TbStudent> list = ExcelUtils.excelImport(is);
			if(list != null && list.size() >0) {
				for (int i = 0; i < list.size(); i++) {
					tbStudentService.addAndUpdateTbStudent(list.get(i));
				}
				return FjnyResult.ok();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return FjnyResult.build(500, "导入失败");
	}
	
	@RequestMapping("/excepOut")
	@ResponseBody
	public FjnyResult excepOut() {
		String path = "/gsh/ksbm/0_uploadfiles/ksb.xls";
		List<TbStudent> list = tbStudentService.getAllTbStudentList();
		try {
			ExcelUtils.execlExport(list, path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("测试");
		}
		return FjnyResult.ok();
	}

}
