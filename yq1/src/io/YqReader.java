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
 * ���ܣ�����һ��·��������һ����Ŷ���ʡ����Ϣ������
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
	
	//���ö����ļ���·��
	public void setFilePath(String s) throws FileNotFoundException{
		filePath = s;
		file = new File(filePath);
		bf = new BufferedReader(new FileReader(file));
	}
	//��ȡ�ļ�
	public ArrayList<Province> read(String path) throws IOException {
		setFilePath(path);
		City readCity;
		String temp;
		Province province = new Province("");
		ArrayList<Province> provinces = new ArrayList<Province>(); //��Ŷ�ȡ������ʡ����Ϣ
		while((temp = bf.readLine()) != null) { //���ж�ȡ��ÿ��һ������
			readCity = new City(temp.split("	"));
			if(province.getName().equals(readCity.getProvinceName())) {  
				province.getCities().add(readCity);
				province.addYqSum(readCity.getYqSum()); //������������
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
