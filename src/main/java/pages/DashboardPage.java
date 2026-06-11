package pages;

//import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {

    private Page page;

    public DashboardPage(Page page) {
        this.page = page;
      
      //  System.out.println("Page null? " + (this.page == null));
    }

    
 //   Locator dashboardText = page.locator("h6");
   // public String getDashboardTitle() {
       // return dashboardText.textContent();
        

        public String getDashboardTitle() {
               return page.locator("h6").textContent();

    }
}
