package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("Java test");
		board.setContent("Java Content");
		board.setWriter("user01");
		
		log.info(mapper.insert(board));
	}
	
	@Test
	public void testAll() {
		
		PageParam param = new PageParam();
		param.setPage(3);
		
		log.info(mapper.getList(param));
		
		mapper.getList(param).forEach(board -> log.info(board));
		
	}
	
	
}
