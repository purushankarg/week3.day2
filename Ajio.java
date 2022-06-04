package week3.day2;
//1. Launch the URL https://www.ajio.com/
//2. In the search box, type as "bags" and press enter
//3. To the left  of the screen under " Gender" click the "Men"
//4. Under "Category" click "Fashion Bags"
//5. Print the count of the items Found. 
//6. Get the list of brand of the products displayed in the page and print the list.
//7. Get the list of names of the bags and print

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch the URL https://www.ajio.com/
		driver.get("https://www.ajio.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div/input[contains(@class,'react-autosuggest__input')]")).sendKeys("Bags",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='facet-linkhead']//label)[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[contains(@class,'facet-linkname facet-linkname-l1l3nestedcategory')])[2]")).click();
		Thread.sleep(5000);
		String count = driver.findElement(By.xpath("//div[@class=\"length\"]")).getText();
		System.out.println("Total Count of the Bag is "+ count);
		List<WebElement> brands = driver.findElements(By.className("brand"));
		System.out.println(brands.size());
		for(int i=0; i<brands.size(); i++) {
			System.out.println(brands.get(i).getText());
		}
		System.out.println("Bag Name Lists ");
		List<WebElement> bgname = driver.findElements(By.className("nameCls"));
		System.out.println(bgname.size());
		for(int i=0; i<bgname.size(); i++) {
			System.out.println(bgname.get(i).getText());
			
		}
		
		

	}

}
