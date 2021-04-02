package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cp.City;
import cp.Province;

public class YqWriter {
	private String outPath;
	
	public YqWriter() {};
	public YqWriter(String out) {
		this.outPath = out;
	}
	public String getOutPath() {
		return outPath;
	}
	public void setOutPath(String outPath) {
		this.outPath = outPath;
	}
	
	//输出一个指定省份到控制台，用于测试程序使用
	public void writeOneProvinceToConsole(Province province) {
		System.out.println(province.getName() + " " + province.getYq_sum());
		for(City city : province.getCities()) {
			System.out.println(city.getName() + " " + city.getYqSum());
		} System.out.println();
	}
	//输出所有省份到控制台
	public void writeAllProvinceToConsole(ArrayList<Province> provinces) {
		for(Province province : provinces) {
			System.out.println(province.getName() + " " + province.getYq_sum());
			for(City city : province.getCities()) {
				System.out.println(city.getName() + " " + city.getYqSum());
			} System.out.println();
		}
	}
	//输出一个省份信息到指定文件
	public void writeOneProvinceToFile(Province province) throws IOException {
		File file = new File(outPath);
		FileWriter fWriter = new FileWriter(file);
		fWriter.write(province.getName() + " " + province.getYq_sum() + "\n");
		for(City city : province.getCities()) {
			fWriter.write(city.getName() + " " + city.getYqSum() + "\n");
		} fWriter.write("\n");
		fWriter.close();
	}
	//输出所有省份信息到指定文件
	public void writeAllProvinceToFile(ArrayList<Province> provinces) throws IOException {
		File file = new File(outPath);
		FileWriter fWriter = new FileWriter(file);
		for(Province province : provinces) {
			fWriter.write(province.getName() + " " + province.getYq_sum() + "\n");
			for(City city : province.getCities()) {
				fWriter.write(city.getName() + " " + city.getYqSum() + "\n");
			} fWriter.write("\n");
		}
		fWriter.close();
	}
}
