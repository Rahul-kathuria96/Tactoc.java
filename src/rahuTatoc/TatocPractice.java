package rahuTatoc;
import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class TatocPractice {
	public static void main(String args[]){
		WebDriver Way=new ChromeDriver();
		Way.get("http://10.0.1.86/tatoc");
		Way.findElement(By.linkText("Basic Course")).click();
		Way.findElement(By.className("greenbox")).click();
		Way.switchTo().frame("main");
	String Box1=Way.findElement(By.id("answer")).getAttribute("class");
  //the string we will get from get attribute  will be stored in box 1 variable
		int n=0;
		while(n==0) {
			Way.findElement(By.linkText("Repaint Box 2")).click();
			Way.switchTo().frame("child");
			String Box2=Way.findElement(By.id("answer")).getAttribute("class");
			Way.switchTo().parentFrame();
			if(Box1.equals(Box2))
			{
				n=1;//Way.switchTo().parentFrame();
				Way.findElement(By.linkText("Proceed")).click();
				
			}			
			
		}
			WebElement drag=Way.findElement(By.id("dragbox"));
			WebElement drop=Way.findElement(By.id("dropbox"));
			//we dont know what datatypes these belogs to ,so we will use web elemeant
			Actions act= new Actions(Way);
			act.dragAndDrop(drag, drop).build().perform();
			Way.findElement(By.linkText("Proceed")).click();
			
			Way.findElement(By.partialLinkText("Launch")).click();
			ArrayList windowsList= new ArrayList(Way.getWindowHandles());//because we dont know the type of window
			String windows1 =(String)windowsList.get(1);
			Way.switchTo().window(windows1);
			Way.findElement(By.id("name")).sendKeys("yolo");
			Way.findElement(By.id("submit")).click();
			String windows2=(String)windowsList.get(0);
			Way.switchTo().window(windows2);
			Way.findElement(By.linkText("Proceed")).click();
			
			Way.findElement(By.partialLinkText("Generate")).click();
			String token=Way.findElement(By.id("token")).getText();
			String token1=token.substring(7);
			Cookie cookie= new Cookie("Token", token1);
			Way.manage().addCookie(cookie);
			Way.findElement(By.linkText("Proceed")).click();
			
			
			


			
			
			
	}

}
