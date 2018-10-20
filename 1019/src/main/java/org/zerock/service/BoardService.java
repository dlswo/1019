package org.zerock.service;

import java.util.List;

import org.zerock.domain.Board;
import org.zerock.domain.PageParam;

public interface BoardService {
	
	public List<Board> getList(PageParam param);
	
	public int register(Board board);

	public int getTotal();
	
	public Board get(PageParam param);
	
	public int remove(PageParam param);
	
	public int modify(Board board);

}
