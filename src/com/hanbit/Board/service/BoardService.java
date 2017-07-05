package com.hanbit.Board.service;

import com.hanbit.Board.domain.BoardBean;

public interface BoardService {
	//setter, create
	public void writeBoard(BoardBean bean);		
	//getter, read
	public BoardBean[] list();		
	public int countBoard();
	public BoardBean findBySeq(int seq);
	public BoardBean[] findByWriter(String writer);
	// update
	public void updateContent(BoardBean bean);
	// delete
	public void deleteContent(int seq);
}
