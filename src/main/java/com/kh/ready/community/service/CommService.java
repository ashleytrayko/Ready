package com.kh.ready.community.service;

import java.util.List;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.domain.CommReply;

public interface CommService {

	int registerBoard(Comm comm);

	int getTotalCount(String searchCondition, String searchValue);

	List<Comm> printAllBoard(int currentPage, int boardLimit);

	Comm printOneByNo(Integer boardNo);

	List<CommReply> printAllReply(Integer boardNo);

	int modifyBoard(Comm comm);

	int removeOneByNo(int boardNo);

	int registerReply(CommReply cReply);

	int deleteReply(Integer cReplyNo);

	int modifyReply(CommReply cReply);

	List<Comm> printAllByValue(String searchCondition, String searchValue, int currentPage, int boardLimit);

}
