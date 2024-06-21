package com.codewithjay.blog.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithjay.blog.controller.employeeController;
import com.codewithjay.blog.dao.EmployeeDao;
import com.codewithjay.blog.entity.Country;
import com.codewithjay.blog.entity.Emploe;
import com.codewithjay.blog.entity.Employee;

@Service

public class EmployeeService {

	@Autowired
	EmployeeDao ed;

	public List<Employee> findAll() {

		return ed.findAll();
	}

	public List<Emploe> findAllemp() {

		return ed.getEmploeById();
	}
   
	public String addEmployee(Employee employee) {
		if(employee.getId()==0) {
			
		}
		return ed.addEmployee(employee);

	}

	public String addEmployee(Emploe employee) {

		return ed.addEmployee(employee);
	}

	public Employee updateSupplier(Employee employee) {

		return ed.updateSupplier(employee);
	}

	public Emploe updateEmploe(Emploe emploe) {

		return ed.updateEmploe(emploe);
	}

	public Employee getEmployeeById(int employeeId) {

		return ed.getEmployeeById(employeeId);
	}

	public Emploe getEmploeById(int emploeId) {

		return ed.getEmploeById(emploeId);
	}

	// UPLOAD EXCEL FILE INTO SERVER
	public String uploadSheet(MultipartFile myFile) {
		String fileName = myFile.getOriginalFilename();
		try {
			FileOutputStream fos = new FileOutputStream("src/main/resources/" + fileName);
			byte[] data;
			try {
				data = myFile.getBytes();
				fos.write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		// read excel data
		List<Employee> list = readExcel("src/main/resources/" + fileName);
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
		for (Employee employee : list) {
			addEmployee(employee);        //DAO KO DENA HAI
		}
		list.forEach(s->System.out.println(s));
		return null;
	}

	private List<Employee> readExcel(String filePath) {
		List<Employee> list = new ArrayList<Employee>();

		// FileInputStream fis=new FileInputStream(filePath);

		try {
			Workbook workbook = new XSSFWorkbook(filePath);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = (Row) rows.next();
				int rowNum = row.getRowNum();
                if(rowNum==0) {
                	continue;
                }
                Employee employee =new Employee();
                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
                employee.setId((int) Long.parseLong(timeStamp)+rowNum);
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						employee.setName(cell.getStringCellValue());
						break;

					case 1:
						employee.setStatus(cell.getStringCellValue());
						break;

					case 2:
						Country country = new Country();
						country.setCid((int)cell.getNumericCellValue());
//						country.setCname(cell.getStringCellValue());
						employee.setCountry(country);
						break;
					case 3:
						Country country1 = new Country();
						//country.setCid((int)cell.getNumericCellValue());
                        country1.setCname(cell.getStringCellValue());
						employee.setCountry(country1);
						break;
						
					}
//					CellType cellsType = cell.getCellType();
//
//					if (cellsType == CellType.STRING) {
//						System.out.println(cell.getStringCellValue() + "\t");
//					} else {
//						System.out.println(cell.getNumericCellValue() + "\t");
//					}
				}
			list.add(employee);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public Emploe updateProduct(Emploe emploe) {
		// TODO Auto-generated method stub
		return null;
	}
}
