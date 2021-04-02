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
			//如果参数为2，则将所有省份信息写入文件
			if(args.length == 2) {
				core.writeAllProvinceToConsole();
				core.writeAllProvinceToFile(args[1]);
			}
			//如果参数为3，则将指定省份信息写入文件
			else if(args.length == 3) {
				core.writeOneProvinceToConsole(args[2]);
				core.writeOneProvinceToFile(args[2], args[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
