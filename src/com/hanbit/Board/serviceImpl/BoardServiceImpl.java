package com.hanbit.Board.serviceImpl;

import com.hanbit.Board.domain.BoardBean;
import com.hanbit.Board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	int count;
	int seqCount;
	BoardBean bean;
	BoardBean[] list;
	
	public BoardServiceImpl(){
		count=0;
		seqCount=0;
		bean= new BoardBean();
		list= new BoardBean[count];
	}
	
	@Override
	public void writeBoard(BoardBean bean) {
		seqCount++;
		bean.setSeq(seqCount);
		if(count==list.length){
			BoardBean[] temp= new BoardBean[count+1];
			System.arraycopy(list, 0, temp, 0, count);
			list=temp;
		}
			list[count++]=bean;
			System.out.println(bean.toString());
	}

	@Override
	public BoardBean[] list() {
		System.out.println("list" + list.toString());
		return list;
	}
	
	@Override
	public int countBoard() {
		return count;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		bean= new BoardBean();
		for(int i=0;i<count;i++){
			if(seq==list[i].getSeq()){
				bean=list[i];
			}
		}
		return bean;
	}

	@Override
	public BoardBean[] findByWriter(String writer) {
		int sameNameCount=0;
		for(int i=0;i<count;i++){
			if(writer.equals(list[i].getWriter())){
				sameNameCount++;
			}
		}
		BoardBean[] sameNames= new BoardBean[sameNameCount];
		int j=0;
		for(int i=0;i<count;i++){
			if(writer.equals(list[i].getWriter())){
				sameNames[j]=list[i];
				j++;
			}
			if(j==sameNameCount){
				break;
			}	
		}
		return sameNames;
	}

	@Override
	public void updateContent(BoardBean param) {
		bean=findBySeq(param.getSeq());
		bean.setContent(param.getContent());
	}

	@Override
	public void deleteContent(int seq) {
		for(int i=0;i<count;i++){
			if(seq==list[i].getSeq()){
			list[i] = list[count-1];
			list[count-1] = null;
			count--;
			break;
			}
		}
	}
}
