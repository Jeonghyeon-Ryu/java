package crawling;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class CrawlingTest {
	// 필드
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "C:\\Users\\admin\\git\\java\\text\\src\\chromedriver.exe";
	private static WebDriver driver;
	private static List<String> searchUrlList = new ArrayList<>();
	// 메인
	public static void main(String[] args) throws InterruptedException, AWTException {
		// 지역 리스트 읽기
		ReadSector rs = new ReadSector();
		ReadStoreDivision rsd = new ReadStoreDivision();
		List<String> searchSector = rs.getSectorOne("대구광역시");
		List<String> searchStoreDivision = rsd.getStoreDivision();
		
		for(int i=0; i<searchSector.size(); i++) {
			for(int j=0; j<searchStoreDivision.size(); j++ ) {
				 searchUrlList.add("https://map.naver.com/v5/search/"+searchSector.get(i)+" "+searchStoreDivision.get(j)+" 맛집");
			}
		}
		// 웹 드라이버가 설치된 경로에서 드라이버.exe 파일 실행
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
//		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		
		
		
		// ******************************* 지도 좌표 Open
		for(int i=0; i<searchUrlList.size(); i++) {
			driver.get(searchUrlList.get(i));
			Thread.sleep(2000);
			// 가게 리스트 스크롤
			driver.switchTo().frame(driver.findElement(By.id("searchIframe")));	// 가게 리스트 iframe 커서 이동
			WebElement scroll;
			try{
				scroll = driver.findElement(By.className("_1Az1K"));	// 가게 리스트 요소
			} catch(Exception e) {
				continue;
			}
			WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(scroll);
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			
//			driver.switchTo().defaultContent();
//			WebElement mainElement = driver.findElement(By.xpath("//*[@id=\"baseMap\"]/div[1]/div"));
//			mainElement.click();
//			Thread.sleep(2000);
//			Robot robot = new Robot();
//			
//			robot.keyPress(39);
//			Thread.sleep(800);
//			robot.keyRelease(39);
		
			// ******************************* 페이지 가게 정보 GET
			String preWebElement=null;
			List<WebElement> we = null;
//			while(true) {
//				we = driver.findElements(By.className("OXiLu"));
//				
//				if(we.size()==0) {
//					break;
//				}
//				if(we.get(0).getAttribute("innerText").equals(preWebElement)) {
//					break;
//				}
//				// 세부 가게정보 Get 들어갈곳
//				for(WebElement s : we) {
//					try {
//						s.click();
//					} catch(ElementClickInterceptedException e) {
//						System.out.println("클릭오류 발생");
//					}
//					driver.switchTo().defaultContent();
//					Thread.sleep(2000);
//					driver.switchTo().frame(driver.findElement(By.xpath("/html/body/app/layout/div[3]/div[2]/shrinkable-layout/div/app-base/search-layout/div[2]/entry-layout/entry-place-bridge/div/nm-external-frame-bridge/nm-iframe/iframe")));
//							
//					WebElement storeName = driver.findElement(By.xpath("//*[@id=\"_title\"]/span[1]"));
//					System.out.println("가게 이름 : " + storeName.getAttribute("innerText"));
//					driver.switchTo().defaultContent();
//					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"searchIframe\"]")));
//				}
//				
//				preWebElement = we.get(0).getAttribute("innerText");
//				driver.findElements(By.className("_2bgjK")).get(1).click();
//				Thread.sleep(2000);
//				we.clear();
//			}
		}

		// ******************************* 세부 가게 정보 GET
//		for(WebElement s : we) {
//			s.click();
//			driver.switchTo().defaultContent();
//			Thread.sleep(2000);
//			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/app/layout/div[3]/div[2]/shrinkable-layout/div/app-base/search-layout/div[2]/entry-layout/entry-place-bridge/div/nm-external-frame-bridge/nm-iframe/iframe")));
//					
//			WebElement storeName = driver.findElement(By.xpath("//*[@id=\"_title\"]/span[1]"));
//			System.out.println("가게 이름 : " + storeName.getAttribute("innerText"));
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"searchIframe\"]")));
//			
//			WebElement storeDiv = driver.findElement(By.className("_3ocDE"));
//			System.out.println("가게 분류 : " + storeDiv.getAttribute("innerText"));
//			
//			WebElement storeAddress = driver.findElement(By.className("_2yqUQ"));
//			System.out.println("가게 주소 : " + storeAddress.getAttribute("innerText"));
//			
//			WebElement storePhone = driver.findElement(By.className("_3ZA0S"));
//			System.out.println("가게 전화번호 : " + storePhone.getAttribute("innerText"));
//			
//			List<WebElement> temp = driver.findElements(By.className("_2RG_o"));
//			for(WebElement e : temp) {
//				if(e.getAttribute("innerText").equals("메뉴")) {
//					e.click();
//					break;
//				}
//			}
//			
//			List<WebElement> listMenu = driver.findElements(By.className("_3yfZ1"));
//					
//			for(WebElement e : listMenu) {
//				System.out.println("메뉴 : " + e.getAttribute("innerText"));
//			}
//		}
		// ********************************************************************************
		
		
//		driver.close();
	}

}
