//file 1

public class Food 
{
    private int foodNo;//주문번호
    private String foodName;//음식이름
    private int price;//가격

    public Food() {
    }

    public Food(int foodNo, String foodName, int price) {
        this.foodNo = foodNo;
        this.foodName = foodName;
        this.price = price;
    }

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print() {
        System.out.println(foodNo + ". " + foodName +", " + price);
    }
}


//file 2

import java.util.Scanner;

class Canteen 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String foodName;
		int foodNo,price,choice,counter=0,total=0;
		Food [] fArray=new Food [10000];


		while(true){
			System.out.println("===================");
			System.out.println("1.음식주문");
			System.out.println("2.주문전체출력");
			System.out.println("3.현재까지매출출력");
			System.out.println("4.주문초기화");
			System.out.println("===================");
			choice=sc.nextInt();

			switch(choice){
			case 1:
				System.out.println("주문번호입력 : ");
				foodNo=sc.nextInt();
				System.out.println("음식이름입력 : ");
				foodName=sc.next();
				System.out.println("가격입력 : ");
				price=sc.nextInt();

				fArray[counter++]=new Food(foodNo,foodName,price);

				break;
			case 2:

				for(int i=0;i<counter;i++){
					fArray[i].print();
				}

				break;
			case 3:
				total=0;
				for(int i=0;i<counter;i++){
					total+=fArray[i].getPrice();
				}
				System.out.println("현재까지 매출 : "+total);
				break;
			case 4:
				counter=0;
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}

		}
	

	}
}
