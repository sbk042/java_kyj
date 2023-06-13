package day10.singleton;

public class SingleTonEx {

	public static void main(String[] args) {
		//SamsungCompany company  = new SamsungCompany();
		SamsunCompany company1 = SamsunCompany.getInstance();
		SamsunCompany company2 = SamsunCompany.getInstance();
		System.out.println(company1);
		System.out.println(company2);
	}

}

class SamsunCompany{
	
	private static SamsungCompany company = new SamsungCompany();
	
	private String name;
	private String address;
	
	private SamsungCompany() {
		name = "Samsung";
		address = "Korea";
	}
	public static SamsungCompany getInstance() {
		return company;
	}
}