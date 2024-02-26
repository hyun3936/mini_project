package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pnu.domain.Food;
import edu.pnu.service.FoodService;

@Controller
public class FoodContoller {

	@Autowired
	private FoodService foodServ;

	// 1. 데이터 목록 가져오기 /page 기능
	@GetMapping("/food")
	public ResponseEntity<?> getFoodInfos(@RequestParam(required = false, defaultValue = "1") Integer pageNo) {
		Page<Food> foodPage = foodServ.getFoodInfos(pageNo);		
		foodPage.forEach(f->{f.generate();});
		return ResponseEntity.ok(foodPage);
	}
	
	
	// 3. 게시글 키워드로 검색
	
	// 3-1. 가게 이름 title 검색
		// localhost:8080/boardSearch?keyword=제목
		@GetMapping("/foodSearch/Title")
		public ResponseEntity<?> getFoodKeywordTitle(String keyword){
			List<Food> list = foodServ.getFoodKeywordTitle(keyword);
			list.forEach(f->{f.generate();});
			return ResponseEntity.ok(list);
		}
		
		// 3-2. 상세 주소 addr1 검색
		@GetMapping("/foodSearch/Addr")
		public ResponseEntity<?> getFoodKeywordAddr(String keyword){
			List<Food> list = foodServ.getFoodKeywordAddr(keyword);
			list.forEach(f->{f.generate();});
			return ResponseEntity.ok(list);
		}
		
		
		// 3-3. 지역 구 검색
		@GetMapping("/foodSearch/Gu")
		public ResponseEntity<?> getFoodKeywordGu(String keyword){
			List<Food> list = foodServ.getFoodKeywordGu(keyword);
			list.forEach(f->{f.generate();});
			return ResponseEntity.ok(list);
		}
		
		
		// 3-4. 가게 소개글
		@GetMapping("/foodSearch/Content")
		public ResponseEntity<?> getFoodKeywordContent(String keyword){
			List<Food> list = foodServ.getFoodKeywordContent(keyword);
			list.forEach(f->{f.generate();});
			return ResponseEntity.ok(list);
		}
		
		// 3-5. 대표 메뉴로 검색
		@GetMapping("/foodSearch/Menu")
		public ResponseEntity<?> getFoodKeywordMenu(String keyword){
			List<Food> list = foodServ.getFoodKeywordMenu(keyword);
			list.forEach(f->{f.generate();});
			return ResponseEntity.ok(list);
		}
	
	
	
	
	
	
	
	
	
}