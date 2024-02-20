package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InitDataSetupTest {

//	@Autowired
//	private BoardRepository boardRepo; // 25개
//
//	@Autowired
//	private CmtRepository cmtRepo; // 한개당 2개씩
//
//	@Test
//	@DisplayName("데이터 준비")
//	public void dataSetup() {
//
//		for (int i = 0; i < 25; i++) {
//			boardRepo.save(Board.builder().title("더미 제목" + i).writer("더미 작성자" + i).content("더미 내용" + i).build());
//
//			for (int j = 0; j < 2; j++) {
//				cmtRepo.save(Comment.builder().Cmt_writer("더미 작성자" + i).cmt_content("더미 댓글 내용" + j).build());
//
//			}
//
//		}
//
//	}
	
	@Test
	void test() {
		System.out.println("test");
	}
	
	
}
