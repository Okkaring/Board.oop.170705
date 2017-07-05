package com.hanbit.Board.domain;

public class BoardBean {
	private int seq;
	private String regdate, writer,title,content;
	
	public void setSeq(int seq){
		this.seq=seq;
	}
	public int getSeq(){
		return seq;
	}
	public void setRegdate(String regdate){
		this.regdate=regdate;
	}
	public String getRegdate(){
		return regdate;
	}
	public void setWriter(String writer){
		this.writer=writer;
	}
	public String getWriter(){
		return writer;
		
	}public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
		
	}public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public String toString(){
		return "sequence: "+seq+" / "+"regdate:"+regdate+" / "+"writer : "+writer+" / "+"title: "+title+" / "+"content: "+content+"\n";
	}
}
