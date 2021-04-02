package cp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import io.YqReader;
import io.YqWriter;

/**
 * 
 * @author ZHL
 * ������ʡ����Ϣ������
 * ���ܣ���װ�˹���ʡ�ݵĸ����ܣ���Գ��У�ʡ�����򣬻�ȡ����ʡ�ݵ���Ϣ��
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
	
	//�������ƻ��ʡ����Ϣ
	public Province getProvinceByName(String pname) {
		Province res = null;
		for(Province province : provinces) { //������ǰ���е�ʡ�ݣ�����Ŀ��ʡ��
			if(province.getName().equals(pname)) {
				res = province;
				break;
			}
		}
		return res;
	}
	//�������ʡ����Ϣs
	public ArrayList<Province> getAllProvinces(){
		return provinces;
	}
	//���򷽷�
	public void Sort() {
		Collections.sort(provinces);
		for(Province province : provinces) Collections.sort(province.getCities());
	}
	//���ļ�
	public void readFile(String path) throws IOException {
		provinces = yqReader.read(path);
	}
	//���һ��ָ��ʡ�ݵ�����̨�����ڲ��Գ���ʹ��
	public void writeOneProvinceToConsole(String name) {
		yqWriter.writeOneProvinceToConsole(getProvinceByName(name));
	}
	//�������ʡ�ݵ�����̨
	public void writeAllProvinceToConsole() {
		yqWriter.writeAllProvinceToConsole(provinces);
	}
	//���һ��ʡ����Ϣ��ָ���ļ�
	public void writeOneProvinceToFile(String name, String filePath) throws IOException {
		yqWriter.setOutPath(filePath);
		yqWriter.writeOneProvinceToFile(getProvinceByName(name));
	}
	//�������ʡ����Ϣ��ָ���ļ�
	public void writeAllProvinceToFile(String filePath) throws IOException {
		yqWriter.setOutPath(filePath);
		yqWriter.writeAllProvinceToFile(provinces);
	}
}
