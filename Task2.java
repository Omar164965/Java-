package task2cw;
import java.util.Arrays;
public class task2 {
	
	public static void main(String[] args) {
		int set1[]= {1,3,6,7};
		int set2[]= {1,3,6,7};
		
		// this function compares the arrays
		boolean check= Arrays.equals(set1,set2);

		// this prints the results of comparison depending on array
		
		if (check==true)
		{
			System.out.println("Then arrays are equal");
		}
		else {
			System.out.println("Then arrays are  not equal");
		}
		
}
	


}	


}