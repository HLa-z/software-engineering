package yq;

import cp.Core;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length < 2 || args.length > 3) return;
		try {
			Core core = new Core();
			core.readFile(args[0]);
			core.Sort();
			//�������Ϊ2��������ʡ����Ϣд���ļ�
			if(args.length == 2) {
				core.writeAllProvinceToConsole();
				core.writeAllProvinceToFile(args[1]);
			}
			//�������Ϊ3����ָ��ʡ����Ϣд���ļ�
			else if(args.length == 3) {
				core.writeOneProvinceToConsole(args[2]);
				core.writeOneProvinceToFile(args[2], args[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
