package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQAActions {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://demoqa.com/buttons");

		WebElement doubleClickButton = driver.findElement(By.cssSelector("button#doubleClickBtn.btn.btn-primary"));
		WebElement rightClickButton = driver.findElement(By.cssSelector("button#rightClickBtn.btn.btn-primary"));
		WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

		Actions ac = new Actions(driver);

//		Click , double click and right click

		ac.moveToElement(rightClickButton).contextClick().build().perform();
		System.out.println(driver.findElement(By.cssSelector("p#rightClickMessage")).getText());
		ac.moveToElement(doubleClickButton).doubleClick().build().perform();
		System.out.println(driver.findElement(By.cssSelector("p#doubleClickMessage")).getText());
		ac.moveToElement(clickButton).click().build().perform();
		System.out.println(driver.findElement(By.cssSelector("p#dynamicClickMessage")).getText());

		Thread.sleep(2000);

//		Drag and Drop 

		driver.navigate().to("https://demoqa.com/droppable");

		WebElement draggableElement = driver.findElement(By.cssSelector("div#draggable"));
		WebElement droppableElement = driver.findElement(By.cssSelector("div#simpleDropContainer  div#droppable"));

		ac.dragAndDrop(draggableElement, droppableElement).build().perform();

		driver.navigate().refresh();
		Thread.sleep(2000);

		draggableElement = driver.findElement(By.cssSelector("div#draggable"));
		droppableElement = driver.findElement(By.cssSelector("div#simpleDropContainer  div#droppable"));

		int xOffset1 = draggableElement.getLocation().getX();
		int yOffset1 = draggableElement.getLocation().getY();

		System.out.println("draggable elemnt is at location: \n x = " + xOffset1 + "\n y = " + yOffset1);

		int xOffset2 = droppableElement.getLocation().getX();
		int yOffset2 = droppableElement.getLocation().getY();

		System.out.println("droppable element is at location: \n x = " + xOffset2 + "\n y = " + yOffset2);

		int xOffset = (xOffset2 - xOffset1) + 10;
		int yOffset = (yOffset2 - yOffset1) + 20;

		System.out.println("Element will be dragged by \n x = "+xOffset+"\n y = "+yOffset);
		
		
		ac.dragAndDropBy(draggableElement, xOffset, yOffset).build().perform();
		

		driver.close();
	}
}
