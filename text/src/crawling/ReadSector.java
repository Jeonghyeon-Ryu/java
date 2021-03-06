package crawling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadSector {
	// 필드 
	Set<String> sectorList = new HashSet<>();
	private File file = new File("C:\\server\\git\\java\\text\\src\\crawling\\SectorList.txt");
	// 생성자 ( 모든 Sector 읽기 )
	public ReadSector() {
		String line;
		String[] tmp = new String[3];
		try {
			if(!file.exists()) {
				file.createNewFile();
			} else {
				FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				while((line=br.readLine()) != null) {
					tmp = line.split("\t");
					if(tmp.length==3) {
						sectorList.add(tmp[0]+" "+tmp[1]+" "+tmp[2]);
					}
				}
				br.close();
			}
		} catch (Exception e) {
			System.out.println("Sector 파일 읽기 오류 : " + e.toString());
		}
	}
	// 메소드
	// 테스트용 전체 리스트 출력
	public void printSectorList() {
		List<String> list = new ArrayList<>(sectorList);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
	}
	
	public List<String> getSectorOne(String sector) {
		List<String> list = new ArrayList<>(sectorList);
		List<String> result = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).indexOf(sector)>=0) {
				result.add(list.get(i));
			}
		}
		return result;
	}
	public List<String> getSectorAll() {
		return new ArrayList<String>(sectorList);
	}
}
