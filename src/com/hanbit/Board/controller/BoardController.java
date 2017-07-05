package com.hanbit.Board.controller;
import javax.swing.*;
import com.hanbit.Board.domain.BoardBean;
import com.hanbit.Board.service.BoardService;
import com.hanbit.Board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		BoardService service=new BoardServiceImpl();
		BoardBean bean=null;
		
		while(true){
			switch(JOptionPane.showInputDialog("0.stop \t\t 1. writeBoard \t\t 2. count " //로직은 리스트를 짜면서 카운트를 정의해준다.
					+ "\t\t 3. list \t\t 4. find By Seq \t\t 5. find By Writer "
					+ "	\t\t6.update Content \t\t 7. delete Content")
					){
			case "0":
				JOptionPane.showMessageDialog(null, "system close");
				return;
			case "1":
				bean=new BoardBean();
				String[] foo=JOptionPane.showInputDialog("등록일자/작성자/제목/내용").split("/");
				bean.setRegdate(foo[0]);
				bean.setWriter(foo[1]);
				bean.setTitle(foo[2]);
				bean.setContent(foo[3]);
				service.writeBoard(bean);
				JOptionPane.showMessageDialog(null, "게시글 작성 완료!");
				break;
			case "2": 
				JOptionPane.showMessageDialog(null, service.countBoard());
				break;
			case "3":
				BoardBean[] list = service.list();
				String aList="";
				for(int i=0;i<service.countBoard();i++){
					aList+= list[i]+"\t".toString()+"	\n	";
				}
				JOptionPane.showMessageDialog(null, "리스트:  \n"+aList);
				break;
			case "4":
				JOptionPane.showMessageDialog(null, service.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("찾을 게시글의 게시글번호 입력").toString())));
				break;
			case "5":
				BoardBean[] writers= service.findByWriter(JOptionPane.showInputDialog("찾을 게시글의 작성자 입력: "));
				String result="";
				if(writers.length==0){
					result="Not Found any writer";
				}else{
					for(int i=0;i<writers.length;i++){
						result+= writers[i].toString();
					}
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			case "6": 
				bean = new BoardBean();
				String bar[]=JOptionPane.showInputDialog("게시글 번호 / 바뀔 내용").split("/");
				bean.setSeq(Integer.parseInt(bar[0]));
				bean.setContent(bar[1]);
				service.updateContent(bean);
				JOptionPane.showMessageDialog(null, "게시글 수정 완료");
				break;
			case "7": 
				service.deleteContent(Integer.parseInt(JOptionPane.showInputDialog("삭제할 게시글 번호 입력: ")));
				JOptionPane.showMessageDialog(null, "Sucess deleting");
				break;
			}
		}
	}
}
