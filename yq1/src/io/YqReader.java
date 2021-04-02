package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import cp.City;
import cp.Province;
/**
 * @author ZHL
 * 功能：传入一个路径，返回一个存放读入省份信息的数组
 */
public class YqReader {
	private File file = null;
	private BufferedReader bf = null;
	private String filePath;
	
	public YqReader() {}
	public YqReader(String inPath) throws FileNotFoundException {
		filePath = inPath;
		file = new File(inPath);
		bf = new BufferedReader(new FileReader(file));
	}
	
	//设置读入文件的路径
	public void setFilePath(String s) throws FileNotFoundException{
		filePath = s;
		file = new File(filePath);
		bf = new BufferedReader(new FileReader(file));
	}
	//读取文件
	public ArrayList<Province> read(String path) throws IOException {
		setFilePath(path);
		City readCity;
		String temp;
		Province province = new Province("");
		ArrayList<Province> provinces = new ArrayList<Province>(); //存放读取的所有省份信息
		while((temp = bf.readLine()) != null) { //逐行读取，每行一个城市
			readCity = new City(temp.split("	"));
			if(province.getName().equals(readCity.getProvinceName())) {  
				province.getCities().add(readCity);
				province.addYqSum(readCity.getYqSum()); //计算疫情人数
			}
			else {
				if(province.getName().equals("") == false) provinces.add(province);
				province = new Province(readCity);
			}
		}
		provinces.add(province);
		return provinces;
	}
}
