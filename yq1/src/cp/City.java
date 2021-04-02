package cp;

public class City implements Comparable<Object>{
	private String provinceName;
	private String name;
	private int yqSum;
	
	public City() {}
	public City(String[] s) {
		provinceName = s[0]; name = s[1]; yqSum = Integer.parseInt(s[2]);
	}
	public City(String name, int sum) {
		this.name = name;
		this.yqSum = sum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYqSum() {
		return yqSum;
	}
	public void setYqSum(int yqSum) {
		this.yqSum = yqSum;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	//重写比较方法，用于排序
	@Override
	public int compareTo(Object o) {
		City c = (City)o;
		if(yqSum > c.getYqSum()) return -1;
		else if(yqSum < c.getYqSum()) return 1;
		else if(name.compareTo(c.getName()) < 1) return 1;
		else return -1;
	}
	
}
