

public class SquareAges { 
public static final int START_YEAR=2017;
public static final int YEAR_MAX= 2140;
public static final int YEAR_MIN=1894;
public static final int MAX_AGE=123;
public static final int MIN_AGE=0;

    public static void main(String[] args) {
        int age;
        for (age=0; age<=MAX_AGE; age++)
        {
            int ageSquared = age*age;
        	int currentAge = age-(ageSquared-START_YEAR);
     
        	if (ageSquared>=YEAR_MIN && ageSquared<=YEAR_MAX && 
        		currentAge<=MAX_AGE && currentAge>MIN_AGE) 
        	{
        		System.out.print("If a person is " + age + 
        						" years old in the year " + ageSquared +
        						" they are alive today and are "+ currentAge +
        						" years old." );

        	}

        }
     }
}
   