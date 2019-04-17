//file 1

public class Food 
{
	private int foodNo;//주문번호
	private String foodName;//음식이름
	private int price;//가격
	
	public Food() 
	{
	}
	
	public Food(int foodNo, String foodName, int price) 
	{
		this.foodNo = foodNo;
        	this.foodName = foodName;
        	this.price = price;
    	}

    	public int getFoodNo() 
	{
        	return foodNo;
    	}
	
	public void setFoodNo(int foodNo) 
	{
        	this.foodNo = foodNo;
    	}
	
	public String getFoodName() 
	{
        	return foodName;
    	}

    	public void setFoodName(String foodName) 
	{
        	this.foodName = foodName;
    	}

    	public int getPrice() 
	{
        	return price;
    	}

    	public void setPrice(int price) 
	{
       		this.price = price;
    	}

    	public void print() 
	{
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


		while(true)
		{
			System.out.println("===================");
			System.out.println("1.음식주문");
			System.out.println("2.주문전체출력");
			System.out.println("3.현재까지매출출력");
			System.out.println("4.주문초기화");
			System.out.println("5.주문삭제");
			System.out.println("===================");
			choice=sc.nextInt();

			switch(choice)
			{
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

				for(int i=0;i<counter;i++)
				{
					fArray[i].print();
				}
				break;
			case 3:
				total=0;
				for(int i=0;i<counter;i++)
				{
					total+=fArray[i].getPrice();
				}
				System.out.println("현재까지 매출 : "+total);
				break;
			case 4:
				counter=0;
				break;
			case 5:
				System.out.println("삭제하려는 주문의 번호를 입력하세요");
				foodNo = sc.nextInt();
					
				for (int i = 0; i < counter; i++)
				{
					if (foodNo == fArray[i].getFoodno())
					{
						for (int j = 0; j < counter-1; j++)
						{//그래서 counter를 -1을 
							fArray[j] = fArray[j+1]; //counter가 다 차게되면 array index out of bound가 일어남
						}
						counter--;
					}
				}					
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}
}

/*Delete Algorithm
 사실살 삭제라기보다 값을 null로 만들고 뒤의 값을 앞으로 땡겨온후 counter를 줄인다.
 바깥 for문으로 삭제하고 싶은 부분을 찾아 삭제하고 안족 for문으로 값을 땡겨온다.*/
