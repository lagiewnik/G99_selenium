package test;

import org.testng.annotations.DataProvider;
public class DataproviderClass {
        @DataProvider(name="SearchProvider")
        public static Object[][] getDataFromDataprovider(){
            return new Object[][] {
                { "Guru99", "morele" },
                { "Krishna", "�liwowica przepis" },
                { "Bhupesh", "stek z grilla" }
            };  
}}