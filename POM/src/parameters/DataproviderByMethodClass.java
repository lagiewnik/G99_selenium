package parameters;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
public class DataproviderByMethodClass {
        @DataProvider(name="SearchProvider")
        public static Object[][] getDataFromDataprovider(Method m){
            if (m.getName().equalsIgnoreCase("testMethodA")){
            	return new Object[][] {
                    { "Guru99", "pranie tapicerek" },
                    { "Krishna", "badminton" },
                    { "Bhupesh", "plecak 30l" }
                };  
            }
            else {
            	return new Object[][] {
                    {  "omaha" },
                    {  "holdem" },
                    {  "szlaki tatry" }
                }; 
            }
        	
}}