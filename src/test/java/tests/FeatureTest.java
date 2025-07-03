package tests;

import Pageobjects.HrmHomePage;
import Pageobjects.LandingPage;
import Pageobjects.PimPage;
import Utility.JsonDataReader;
import com.fasterxml.jackson.core.type.TypeReference;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.util.List;
import java.util.Map;

public class FeatureTest extends BaseTest {

        @DataProvider(name = "UserData")
        public Object[][] productDataProvider() {
                String path = "C:\\Users\\CODECLOUDS-ARKA\\Downloads\\eclipse-workspace_Project_List\\orangeHRM_Test\\src\\main\\java\\Resources\\user.json";
                Object[][] data = JsonDataReader.readJsonAsDataProvider(path, new TypeReference<List<Map<String, Object>>>() {});
                System.out.println("Data provider returned " + data.length + " rows");
                return data;
        }


        @Test(dataProvider = "UserData")
        public void addEmployee(Map<String, Object> data) throws InterruptedException {
                String JsonFirstName = data.get("First_Name").toString();
                String JsonLastName = data.get("Last_Name").toString();
                String JsonEmpID = data.get("EmpId").toString();

                LandingPage landingPage = new LandingPage(driver);
                HrmHomePage hrmHomePage = landingPage.loginApp("Admin", "admin123");
                PimPage pimpage = hrmHomePage.GotoPimPage();
                pimpage.addEmp(JsonFirstName, JsonLastName, JsonEmpID);
                //hrmHomePage.logout();
        }

}
