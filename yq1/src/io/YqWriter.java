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
	
	//���һ��ָ��ʡ�ݵ�����̨�����ڲ��Գ���ʹ��
	public void writeOneProvinceToConsole(Province province) {
		System.out.println(province.getName() + " " + province.getYq_sum());
		for(City city : province.getCities()) {
			System.out.println(city.getName() + " " + city.getYqSum());
		} System.out.println();
	}
	//�������ʡ�ݵ�����̨
	public void writeAllProvinceToConsole(ArrayList<Province> provinces) {
		for(Province province : provinces) {
			System.out.println(province.getName() + " " + province.getYq_sum());
			for(City city : province.getCities()) {
				System.out.println(city.getName() + " " + city.getYqSum());
			} System.out.println();
		}
	}
	//���һ��ʡ����Ϣ��ָ���ļ�
	public void writeOneProvinceToFile(Province province) throws IOException {
		File file = new File(outPath);
		FileWriter fWriter = new FileWriter(file);
		fWriter.write(province.getName() + " " + province.getYq_sum() + "\n");
		for(City city : province.getCities()) {
			fWriter.write(city.getName() + " " + city.getYqSum() + "\n");
		} fWriter.write("\n");
		fWriter.close();
	}
	//�������ʡ����Ϣ��ָ���ļ�
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
