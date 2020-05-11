package net.xgf.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.xgf.pojo.TbStudent;

public class ExcelUtils {
	public static void execlExport(List<TbStudent> list, String path) throws Exception {
		WritableWorkbook book = null;
		try {
			// 创建一个Excel文件对象
			book = Workbook.createWorkbook(new FileOutputStream(new File(path)));
			// 创建Excel第一个选项卡对象
			WritableSheet sheet = book.createSheet("Sheet1", 0);
			// 设置表头，第一行内容
			// Label参数说明：第一个是列，第二个是行，第三个是要写入的数据值，索引值都是从0开始
			sheet.addCell(new Label(0, 0, "id号"));
			sheet.addCell(new Label(1, 0, "考生姓名"));
			sheet.addCell(new Label(2, 0, "考试号"));
			sheet.addCell(new Label(3, 0, "身份证号"));
			sheet.addCell(new Label(4, 0, "系别(00-农林类  01-畜牧类)"));
			sheet.addCell(new Label(5, 0, "考场编号"));
			sheet.addCell(new Label(6, 0, "座位号"));
			sheet.addCell(new Label(7, 0, "考试日期"));
			sheet.addCell(new Label(8, 0, "考试时间"));
			sheet.addCell(new Label(9, 0, "头像"));
			sheet.addCell(new Label(10, 0, "健康码"));
			// 遍历集合并添加数据到行，每行对应一个对象
			for (int i = 0; i < list.size(); i++) {
				TbStudent tbStudent = list.get(i);
				// 表头占据第一行，所以下面行数是索引值+1
				// 跟上面添加表头一样添加单元格数据，这里为了方便直接使用链式编程
				sheet.addCell(new Label(0, i + 1, "" + tbStudent.getId()));
				sheet.addCell(new Label(1, i + 1, "" + tbStudent.getStuname()));
				sheet.addCell(new Label(2, i + 1, "" + tbStudent.getExamcode()));
				sheet.addCell(new Label(3, i + 1, "" + tbStudent.getIdcard()));
				sheet.addCell(new Label(4, i + 1, "" + tbStudent.getDeparment()));
				sheet.addCell(new Label(5, i + 1, "" + tbStudent.getNumber()));
				sheet.addCell(new Label(6, i + 1, "" + tbStudent.getSeatnumber()));
				sheet.addCell(new Label(7, i + 1, "" + tbStudent.getExamdate()));
				sheet.addCell(new Label(8, i + 1, "" + tbStudent.getExamtime()));
				sheet.addCell(new Label(9, i + 1, "" + tbStudent.getHeadurl()));
				sheet.addCell(new Label(10, i + 1, "" +  tbStudent.getHealthurl()));
			}
			// 写入数据到目标文件
			book.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<TbStudent> excelImport(InputStream is) {
		List<TbStudent> list = new ArrayList<>();
		Workbook book = null;
		try {
			// 获取Excel对象 文件路径形式
			//book = book.getWorkbook(new File(path));
			book = book.getWorkbook(is);
			// 获取Excel第一个选项卡对象
			Sheet sheet = book.getSheet(0);
			// 遍历选项卡，第一行是表头，所以索引数-1
			for (int i = 0; i < sheet.getRows() - 1; i++) {
				TbStudent tbStudent = new TbStudent();
				// 获取第二行第一列单元格对象
				Cell cell = sheet.getCell(0, i + 1);
				tbStudent.setStuname(cell.getContents());
				// 获取第二行第二列
				tbStudent.setExamcode(sheet.getCell(1, i + 1).getContents());
				// 获取第二行第三列
				tbStudent.setHeadurl(sheet.getCell(2, i + 1).getContents());
				list.add(tbStudent);
			}
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			// 返回导入的数据集合
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		List<TbStudent> list = new ArrayList<>(); // 创建数据
		for (int i = 0; i < 65535; i++) {
			TbStudent tbStudent = new TbStudent();
			tbStudent.setStuname("张三");
			tbStudent.setExamcode("12321332");
			list.add(tbStudent);
		}

		String path = "D:\\2.xls";
		System.out.println("开始导出...");
		long s1 = new Date().getTime(); // 开始导出

		execlExport(list, path);
		long s2 = new Date().getTime();
		long time = s2 - s1;
		System.out.println("导出完成！消耗时间：" + time + "毫秒");
	}

	/*
	 * public static void main(String[] args) { String path = "D:\\1.xls";
	 * 
	 * String path = "D:\\eclelTest\\xs.xls"; List<TbStudent> list =
	 * excelImport(path); for (TbStudent s : list) { System.out.println(s); } }
	 */
}
