package crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrawlingTest {
	// 필드
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\Users\\admin\\git\\java\\text\\src\\chromedriver.exe";
	public static WebDriver driver;
	// 메인
	public static void main(String[] args) throws InterruptedException {
		// 웹 드라이버가 설치된 경로에서 드라이버.exe 파일 실행
		System.setProperty(WEB_DRIVER_PATH, WEB_DRIVER_PATH);
		
		driver = new ChromeDriver();
		String url = "https://www.naver.com/";
		
		driver.get(url);
		List<WebElement> we = driver.findElements(By.className("issue"));
//		List<WebElement> we = driver.findElements(By.className("OXiLu"));
		System.out.println(we.size());
		for(WebElement e : we) {
			System.out.println(e.getAttribute("innerText"));
		}
	}

}
