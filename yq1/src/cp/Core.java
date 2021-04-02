package cp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import io.YqReader;
import io.YqWriter;

/**
 * 
 * @author ZHL
 * 类名：省份信息管理者
 * 功能：封装了关于省份的各功能，如对城市，省份排序，获取给定省份的信息等
 */
public class Core {
	private YqReader yqReader;
	private YqWriter yqWriter;
	private ArrayList<Province> provinces;
	
	public Core() {
		yqReader = new YqReader();
		yqWriter = new YqWriter();
	}
	public Core(ArrayList<Province> p) {
		provinces = p;
		yqReader = new YqReader();
		yqWriter = new YqWriter();
	}
	
	//根据名称获得省份信息
	public Province getProvinceByName(String pname) {
		Province res = null;
		for(Province province : provinces) { //遍历当前已有的省份，查找目标省份
			if(province.getName().equals(pname)) {
				res = province;
				break;
			}
		}
		return res;
	}
	//获得所有省份信息s
	public ArrayList<Province> getAllProvinces(){
		return provinces;
	}
	//排序方法
	public void Sort() {
		Collections.sort(provinces);
		for(Province province : provinces) Collections.sort(province.getCities());
	}
	//读文件
	public void readFile(String path) throws IOException {
		provinces = yqReader.read(path);
	}
	//输出一个指定省份到控制台，用于测试程序使用
	public void writeOneProvinceToConsole(String name) {
		yqWriter.writeOneProvinceToConsole(getProvinceByName(name));
	}
	//输出所有省份到控制台
	public void writeAllProvinceToConsole() {
		yqWriter.writeAllProvinceToConsole(provinces);
	}
	//输出一个省份信息到指定文件
	public void writeOneProvinceToFile(String name, String filePath) throws IOException {
		yqWriter.setOutPath(filePath);
		yqWriter.writeOneProvinceToFile(getProvinceByName(name));
	}
	//输出所有省份信息到指定文件
	public void writeAllProvinceToFile(String filePath) throws IOException {
		yqWriter.setOutPath(filePath);
		yqWriter.writeAllProvinceToFile(provinces);
	}
}
