package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // 각 필드 값을 조회할 수 있는 GETTER 메서드 자동 생성
@Setter
@ToString // 모든 필드를 출력할 수 있는 toString 메서드 자동 생성
@Builder
@AllArgsConstructor	// 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 아예 없는 기본 생성자 자동 생성
@Entity
@Table(name="matzip") // getfoodkr 테이블과 연동
public class Food {
    @Id   
	private int ucSeq; // 고유 코드
    private String main_title; // 가게 이름
    private String gugun_nm; // 지역 구
    private double lat; // 
    private double lng;
    private String place;
    private String title;
    private String subtitle;
    private String addr1; // 상세 주소
    private String addr2;
    private String cntct_tel;   
    private String homepage_url;
    private String usage_day_week_and_time;
    private String rprsntv_menu; // 대표 메뉴
    private String main_img_normal;
    private String main_img_thumb;    
    private String itemcntnts; // 가게 소개글   
    
    
    // 따옴표("")가  ""data"" 이런식으로 중복 되어있는 문제를 해결하기 위해 형식 재지정 
    public void generate() {
		main_title = main_title.replace("\"", "");
	    gugun_nm = gugun_nm.replace("\"", "");
	    place = place.replace("\"", "");
	    title = title.replace("\"", "");
	    subtitle = subtitle.replace("\"", "");
	    addr1 = addr1.replace("\"", "");
	    addr2 = addr2.replace("\"", "");
	    cntct_tel = cntct_tel.replace("\"", "");   
	    homepage_url = homepage_url.replace("\"", "");
	    usage_day_week_and_time = usage_day_week_and_time.replace("\"", "");
	    rprsntv_menu = rprsntv_menu.replace("\"", "");
	    main_img_normal = main_img_normal.replace("\"", "");
	    main_img_thumb = main_img_thumb.replace("\"", "");
	    itemcntnts = itemcntnts.replace("\"", "");
	}
    
    
}