package crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrawlingTest {
	// 필드
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\server\\libs\\chromedriver.exe";
	public static WebDriver driver;
	// 메인
	public static void main(String[] args) throws InterruptedException {
		// 웹 드라이버가 설치된 경로에서 드라이버.exe 파일 실행
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		driver = new ChromeDriver();
		String url = "https://map.naver.com/v5/search/%EB%A7%9B%EC%A7%91?c=14295028.7020736,4315225.3636339,15,0,0,0,dh";
		
		driver.get(url);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"searchIframe\"]")));
		List<WebElement> we = driver.findElements(By.className("OXiLu"));
		Thread.sleep(2000);
		we.get(0).click();
		
		List<WebElement> iframe = driver.findElements(By.id("entryIframe"));
		System.out.println("iframe 갯수 : " + iframe.size());
		
		driver.switchTo().frame(driver.findElement(By.id("entryIframe")));
		List<WebElement> listName = driver.findElements(By.className("_3XamX"));
		List<WebElement> listDiv = driver.findElements(By.className("_3ocDE"));
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("메뉴")).click();
				
		System.out.println(we.size()); 	
		for(WebElement e : we) {
			System.out.println(e.getAttribute("innerText"));
		}
//		
//		for(WebElement e : listName) {
//			System.out.println(e.getAttribute("innerText"));
//		}
//		for(WebElement e : listDiv) {
//			System.out.println(e.getAttribute("innerText"));
//		}
	}

}
