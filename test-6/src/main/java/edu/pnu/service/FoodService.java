package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Food;
import edu.pnu.persistence.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository foodRepo;
	
	
	// 데이터 포멧 -- "" 가 중복되는거 하나 빼주는 작업.
	public void generate() {
		List<Food> list = foodRepo.findAll();
		list.forEach(f-> { // 각 요소(f)에 대한 반복 처리를 함.
			f.generate();// f.generate()는 각 Food 객체(f)에 대해 generate() 메서드를 호출
			System.out.println(f); // 해당 객체의 문자열 표현을 표준 출력에 출력하는 것으로, 객체의 toString() 메서드가 호출됩니다
		});
	}
		
	
	
//	// 데이터 전부 불러오기  -- 오리지날 버전
//	public Page<Food> getFoodInfos(Integer pageNo) {
//		Pageable pageable = PageRequest.of(pageNo - 1, 10);		
//		return foodRepo.findAll(pageable);
//	}
//	
	
	// 데이터 전부 불러오기 -- 데이터 포맷 버전 "" 중복 뺸거
	public Page<Food> getFoodInfos(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 10);		
		return foodRepo.findAll(pageable);
	}
	
	
	
	
	// 키워드에 해당하는 게시글 가져오기
	
	// 3-1. 가게 이름 title 검색
	public List<Food> getFoodKeywordTitle(String keyword){
		// keyword가 비어있을 때 => 전체 게시글 
		if (keyword == null)
			return foodRepo.findAll();
		return foodRepo.foodSearchKeywordTitle(keyword);
	}
	
	// 3-2. 상세 주소 addr1 검색
	public List<Food> getFoodKeywordAddr(String keyword){
		// keyword가 비어있을 때 => 전체 게시글 
		if (keyword == null)
			return foodRepo.findAll();
		return foodRepo.foodSearchKeywordAddr(keyword);
	}
	
	// 3-3. 지역 구 검색
	public List<Food> getFoodKeywordGu(String keyword){
		// keyword가 비어있을 때 => 전체 게시글 
		if (keyword == null)
			return foodRepo.findAll();
		return foodRepo.foodSearchKeywordGugunNum(keyword);
	}

	// 3-4. 가게 소개글
	public List<Food> getFoodKeywordContent(String keyword){
		// keyword가 비어있을 때 => 전체 게시글 
		if (keyword == null)
			return foodRepo.findAll();
		return foodRepo.foodSearchKeywordDateItemCntnts(keyword);
	}
	
	
	// 3-5. 대표 메뉴로 검색
	public List<Food> getFoodKeywordMenu(String keyword){
		// keyword가 비어있을 때 => 전체 게시글 
		if (keyword == null)
			return foodRepo.findAll();
		return foodRepo.foodSearchKeywordRepresentMenu(keyword);
	}
	
}
