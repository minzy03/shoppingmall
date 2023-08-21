package com.example.demo.mypage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MemberVO;

@Mapper
@Repository("mypageDAO")
public interface MypageDAO {

	public List selectOrderList() throws DataAccessException;


	
	public MemberVO selectMypageList(String member_id) throws DataAccessException;
	
	
	//민아 프로필 편집
	public void mypageintroupdate(HashMap memberMap) throws DataAccessException;
	
	//민아 찜
	public List selectBookList() throws DataAccessException;
	
}
