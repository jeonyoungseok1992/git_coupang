package coupang;

interface DrinkInterface {
	
	abstract void insertDrink(String name, int price, String company);
	
	Boolean checkDrink(String name, String company);
	
	void inputDrink(String name, String company, int count);
	
	
	void deleteDrink(String name, String company);
	
	
	//원래는 메서드 매개변수 없었는데 필요해서 매개변수 추가하고 수정하니 인터페이스 만든 의미가 없어짐....
	

}
