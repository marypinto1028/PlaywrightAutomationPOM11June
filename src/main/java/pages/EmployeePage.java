package pages;


	import com.microsoft.playwright.Locator;
	import com.microsoft.playwright.Page;

	public class EmployeePage {

	private Page page;

	public EmployeePage(Page page) {
	    this.page = page;
	}

	// Locators
	private Locator pimMenu =
	        page.locator("//span[text()='PIM']");

	private Locator employeeName =
	        page.locator("(//input[@placeholder='Type for hints...'])[1]");

	private Locator searchButton =
	        page.locator("//button[@type='submit']");

	// Actions
	public void clickPIM() {
	    pimMenu.click();
	}

	public void enterEmployeeName(String name) {
	    employeeName.fill(name);
	}

	public void clickSearch() {
	    searchButton.click();
	}

	public void searchEmployee(String name) {

	    clickPIM();

	    enterEmployeeName(name);

	    clickSearch();
	}


	}
