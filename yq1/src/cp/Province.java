package cp;

import java.util.ArrayList;

import cp.City;

public class Province implements Comparable<Object>{
	String name;
	int yq_sum = 0;
	ArrayList<City> cities;
	
	public Province() {
		cities = new ArrayList<City>();
	}
	public Province(String name) {
		this.name = name;
		cities = new ArrayList<City>();
	}
	public Province(City c) {
		this.name = c.getProvinceName();
		cities = new ArrayList<City>();
		cities.add(c);
	}
	public Province(String name, int sum, ArrayList<City> c) {
		this.name = name;
		this.yq_sum = sum;
		this.cities = c;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYq_sum() {
		return yq_sum;
	}
	public void setYq_sum(int yq_sum) {
		this.yq_sum = yq_sum;
	}
	public ArrayList<City> getCities() {
		return cities;
	}
	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}
	public void addYqSum(int sum) {
		yq_sum += sum;
	}
	//重写比较方法，用于排序
	@Override
	public int compareTo(Object o) {
		Province p = (Province)o;
		if(yq_sum > p.getYq_sum()) return -1;
		else if(yq_sum < p.getYq_sum()) return 1;
		else if(name.compareTo(p.getName()) < 1) return 1;
		else return -1;
	}
	
}
