package day17.practice.vo;

import lombok.Data;
import lombok.Getter;

@Getter

@Data //getter setter 만들기
public class Product {
	//클래스 만들 때 3가지 멤버 면수, 생성자 , 메서드
	
	//멤버 변수 : 제품 판매와 관련된 제품 정보
	private String name;//제품명
	private String modelName;//모델명
	private int price;//가격
	private int amount;//수량(판매수량, 전체 제고량)
	private String category;//분류
	
	
	//생성자(마우스 우 클릭 -> source -> Generate Constructor using field사용)
	public Product(String name, String modelName, int price, int amount, String category) {
		this.name = name;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}
	
	
	// 복사 생성자 추가됨
	public Product(Product product) {
		this.name = product.name;
		this.modelName = product.modelName;
		this.price = product.price;
		this.amount = product.amount;
		this.category = product.category;
	}



	//메서드
	/** 제품 입고 기능 => 현재 수량에 주어진 수량을 누적
	 */
	public void store(int amount) {
		// 창고에 제품을 추가해야하는데 음수가 오면 안됨
		if(amount < 0 ) {
			return;
		}
		//this.amount += amount;
		accumulate(amount);
	}
	/** 제품 출고 가능 => 현주 수량에서 주어진 수량을 감소
	 * 제품 판매는 곧 수량이 감소하는 것과 같다
	 */
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		//this.amount -= amount;
		accumulate(-amount);
	}
	private void accumulate(int mount) {
		this.amount += amount;
	}



	public void print() {
		System.out.println("제품명 : " + name);
		System.out.println("모델명 : " + modelName);
		System.out.println("재고 : " + amount);
		System.out.println("가격 : " + price);

	}
}
