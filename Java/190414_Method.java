public class ex6_1 
{
  public static void main(String[] args) 
  {
    addHap2(1, 2);
    addHap2(3, 4);

    int hap = addHap(1 ,2); 

    System.out.println(hap);
	}

    int  addHap (int a, int b) 
    {     
     int hap = a + b;
     return hap;

             } 


              void addHap2 (int a, int b) {
                      int hap  =  a  +  b;

                      System.out.println(a+" 와 "+b+"의 합은" + hap + "입니다.");

             } 



 
}
