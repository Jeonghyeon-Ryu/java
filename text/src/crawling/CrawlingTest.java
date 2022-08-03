package crawling;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class CrawlingTest {
	// 필드
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = CrawlingTest.class.getResource("chromedriver.exe").getPath();
	private static WebDriver driver;
	private static List<String> searchUrlList = new ArrayList<>();
	// 메인
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, AWTException {
		// 지역 리스트 읽기
//		ReadSector rs = new ReadSector();
//		ReadStoreDivision rsd = new ReadStoreDivision();
//		List<String> searchSector = rs.getSectorOne("대구광역시");
//		List<String> searchStoreDivision = rsd.getStoreDivision();
		
		for(int i=1; i<60000; i++) {
				 searchUrlList.add("https://www.goodchoice.kr/product/detail?ano="+i);
		}
		// 웹 드라이버가 설치된 경로에서 드라이버.exe 파일 실행
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		
		
		
		// ******************************* 지도 좌표 Open
		for(int i=0; i<searchUrlList.size(); i++) { // alert_msg box_shadow
			Thread.sleep(1000);
			driver.get(searchUrlList.get(i));
			try {
				WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/h2"));
				String name = element.getAttribute("innerText");
				element = driver.findElement(By.className("call"));
				String phone = element.getAttribute("href");
				element = driver.findElement(By.className("address"));
				String address = element.getAttribute("innerText");
				element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div[1]/div/ul/li[1]/img"));
				String imgUrl = element.getAttribute("src");
				element = driver.findElement(By.xpath("//*[@id=\"product_filter_form\"]/article/div[2]/strong"));
				String roomName = element.getAttribute("innerText");
				element = driver.findElement(By.xpath("//*[@id=\"product_filter_form\"]/article/div[2]/div[3]/div[2]/div/div/p[2]/b"));
				String price = element.getAttribute("innerText");
				element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/button[2]"));
				element.click();
				Thread.sleep(1000);
				element = driver.findElement(By.className("default_info"));
				String defaultInfo = element.getAttribute("innerText");
				
				Accommodation acc = new Accommodation();
				Room room = new Room();
				AccommodationDAO aDAO = new AccommodationDAO();
				RoomDAO rDAO = new RoomDAO();
				
				acc.setAccId(i+500);
				acc.setName(name!=null?name:"");
				acc.setPhone(phone!=null?phone:"");
				acc.setAddress(address!=null?address:"");
				acc.setImgUrl(imgUrl!=null?imgUrl:"");
				room.setAccId(i+500);
				room.setRoomId(i+500);
				room.setPrice(price!=null?price:"");
				room.setName(roomName!=null?roomName:"");
				room.setInfo(defaultInfo!=null?defaultInfo:"");
				
//				System.out.println(acc);
//				System.out.println(room);
				aDAO.insert(acc);
				rDAO.insert(room);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("error");
			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("error");
			}
			// 가게 리스트 스크롤
//			driver.switchTo().frame(driver.findElement(By.id("searchIframe")));	// 가게 리스트 iframe 커서 이동
//			try{
//				scroll = driver.findElement(By.className("_1Az1K"));	// 가게 리스트 요소
//			} catch(Exception e) {
//				continue;
//			}
//			WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(scroll);
//			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
//			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
//			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
//			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
//			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
//			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 3000).perform();
			
//			driver.switchTo().defaultContent();
//			WebElement mainElement = driver.findElement(By.xpath("//*[@id=\"baseMap\"]/div[1]/div"));
//			mainElement.click();
//			Thread.sleep(2000);
			
			// ******************************* 페이지 가게 정보 GET
//			String preWebElement=null;
//			List<WebElement> we = null;
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

