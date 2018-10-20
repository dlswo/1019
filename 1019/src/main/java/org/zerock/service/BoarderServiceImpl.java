package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoarderServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public List<Board> getList(PageParam param) {
		
		return mapper.getList(param);
	}

	@Override
	public int register(Board board) {
		
		return mapper.insert(board);
	}

	@Override
	public int getTotal() {
		
		return mapper.count();
	}

	@Override
	public Board get(PageParam param) {
		
		return mapper.get(param);
	}

	@Override
	public int remove(PageParam param) {
		
		return mapper.delete(param);
	}

	@Override
	public int modify(Board board) {

		return mapper.update(board);
	}
	
}
