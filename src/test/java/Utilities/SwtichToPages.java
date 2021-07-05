package Utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwtichToPages {
	
	public static String currentWindow;
	
	public static void switch_to_next_tab(WebDriver driver) 
	{
		currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String next_tab: windows) 
		{
			if(!next_tab.equalsIgnoreCase(currentWindow)) 
			{
				driver.switchTo().window(next_tab);
			}
		}
	}
	
	public static void switch_back(WebDriver driver) 
	{
		//driver.close();
		driver.switchTo().window(currentWindow);
	}
	public static void switch_to_next_tab1(WebDriver driver) 
	{
		currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String next_tab: windows) 
		{
			if(!next_tab.equalsIgnoreCase(currentWindow)) 
			{
				driver.close();
				driver.switchTo().window(next_tab);
				
			}
		}
		
	}

}
