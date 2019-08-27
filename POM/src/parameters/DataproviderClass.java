package parameters;

import org.testng.annotations.DataProvider;
public class DataproviderClass {
        @DataProvider(name="SearchProvider")
        public static Object[][] getDataFromDataprovider(){
            return new Object[][] {
                { "Guru99", "pranie tapicerek" },
                { "Krishna", "badminton" },
                { "Bhupesh", "plecak 30l" }
            };  
}}