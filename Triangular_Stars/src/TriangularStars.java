
public class TriangularStars {
	public static final int MAX_VALUE= Integer.MAX_VALUE;
	public static final int MIN_VALUE=0;
	public static void main(String[] args) {
		int triangleNumber=0;
		int index=1;
		System.out.println("The Triangular Star numbers include: ");
		for (index = 1; determineStarNumber(index) < MAX_VALUE && triangleNumber >= MIN_VALUE ; index++)
		{
			triangleNumber=triangleNumber+index;
			if(isStarNumber(triangleNumber))
			{
				System.out.println(triangleNumber);
			}
		}	

	}
	public static boolean isStarNumber(int TriangleNumberToTest) 
	{
		int starToCompareTo = 0;
		int index = 1;
		int difference=0;
		boolean finished = false;
		while (!finished) 
		{
			starToCompareTo = determineStarNumber(index);
			index++;
			difference= TriangleNumberToTest-starToCompareTo;
			if (MIN_VALUE >= difference) 
			{
				finished = true;
			}
		}
		if (difference== MIN_VALUE) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int determineStarNumber(int starIndex){
		return (((6*starIndex)*(starIndex-1))+1);



	}

}
	
