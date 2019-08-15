package com.bit.pet.model.dao;

import java.util.List;

import com.bit.pet.model.dto.JournalBoardBean;

public interface JournalBoardMapper {
	List<JournalBoardBean> jMainBoard();
	JournalBoardBean jSelectBoard(int jBoard);
	JournalBoardBean jSelectBoard(JournalBoardBean jBoard);
	void jWriteBoard(JournalBoardBean jBoard);
	void jModifyBoard(JournalBoardBean jBoard);
	void jDeleteBoard(JournalBoardBean jBoard);
	void jBoardHit(JournalBoardBean jBoard);
	void jBoardLike(JournalBoardBean jBoard);
	
	void jReplyBoardReply(JournalBoardBean jBoard);
	void jReplyBoardIndent(JournalBoardBean jBoard);
}
