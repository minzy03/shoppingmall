package com.example.demo.mypage.service;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.functions.GeneralFunctions;
import com.example.demo.mypage.dao.MypageDAO;
import com.example.demo.vo.BookmarkVO;
import com.example.demo.vo.CouponVO;
import com.example.demo.vo.DeliveryAddressVO;
import com.example.demo.vo.MemberVO;
import com.example.demo.vo.OrderVO;
import com.example.demo.vo.PointHistoryVO;
import com.example.demo.vo.ReviewVO;

@Service("mypageService")
public class MypageServiceImpl implements MypageService {
	@Autowired
	private MypageDAO mypageDAO;

	@Override
	public void deleteMember(MemberVO member) {
		mypageDAO.deleteMember(member);
	}
	
	@Override
	public List<OrderVO> selectOrderList() throws DataAccessException {
		return mypageDAO.selectOrderList();
	}

	@Override
	public List<OrderVO> selectOrderByMemberNo(int memberNo) {
		return mypageDAO.selectOrderByMemberNo(memberNo);
	}

	@Override
	public List<OrderVO> selectOrderByOrderNo(int orderNo) throws Exception {
		return mypageDAO.selectOrderByOrderNo(orderNo);
	}

	@Override
	public List<CouponVO> selectCouponByMemberNo(int memberNo) throws Exception {
		return mypageDAO.selectCouponByMemberNo(memberNo);
	}

	@Override
	public CouponVO couponNull(CouponVO result) {
		CouponVO couponNull = mypageDAO.couponNull(result);
		return couponNull;
	}

	@Override
	public void insertOrderList(List<OrderVO> orderList) {
		mypageDAO.insertOrderList(orderList);
	}

	@Override
	public int selectNewOrderNo() {
		return mypageDAO.selectNewOrderNo();
	}

	@Override
	public int[] selectSeqNoByOrderNo(int orderNo) {
		return mypageDAO.selectSeqNoByOrderNo(orderNo);
	}

	@Override
	public void updateDeliveryStatusToCancel(int order_seqNo) {
		mypageDAO.updateDeliveryStatusToCancel(order_seqNo);
	}

	@Override
	public List<Map> selectOrderBySearchType(Map<String, Object> map) {
		return mypageDAO.selectOrderBySearchType(map);
	}

	@Override
	public MemberVO listMyPage(String member_id) throws Exception {
		System.out.println("listMyPageService");
		return mypageDAO.selectMypageList(member_id);
	}

	// 민아 프로필편집
	@Override
	public void mypageintro(HashMap memberMap) {
		System.out.println("mypageintroService");
		mypageDAO.mypageintroupdate(memberMap);

	}

	// 민아 찜
	@Override
	public List selectBookList(MemberVO memberInfo) throws DataAccessException {
		System.out.println("selectBookList Service");
		List bookList = null;
		bookList = mypageDAO.selectBookList(memberInfo);
		return bookList;
	}

	@Override
	public int removeBookMark(int goodsNo) throws DataAccessException {
		return mypageDAO.deleteBookMark(goodsNo);
	}
	@Override
	public List<PointHistoryVO> selectPointListWithPagingMap(Map pagingMap){
		List<PointHistoryVO> pointList = mypageDAO.selectPointListWithPagingMap(pagingMap);
		return pointList;
	}
	@Override
	public CouponVO couponNum(String couponCode) {
		CouponVO result = mypageDAO.couponNum(couponCode);
		return result;
	}
	@Override
	public int selectPointListTotalNum(int memberNo) {
		int num = mypageDAO.selectPointListTotalNum(memberNo);
		return num;
	}

	@Override
	public void couponInsert(CouponVO result) {
		mypageDAO.couponInsert(result);
	}

	@Override
	public List<DeliveryAddressVO> myAddress(int memberNo) throws DataAccessException {
		List<DeliveryAddressVO> myAddressVO = mypageDAO.myAddress(memberNo);
		return myAddressVO;
	}
	@Override
	public void deleteAddress(int deliveryNo) {
		mypageDAO.deleteAddress(deliveryNo);
	}

	// 민아 회원정보 수정2
	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		mypageDAO.updateMemberInfo(memberVO);
	}

	// 민아 리뷰1
	@Override
	public List<OrderVO> reviewList(int memberNo) throws DataAccessException {
		List<OrderVO> reviewList = mypageDAO.reviewList(memberNo);
		return reviewList;
	}

	// 민아 리뷰2
		@Override
		public List<OrderVO> writeReview(int memberNo) throws DataAccessException {
			List<OrderVO> writeReview = mypageDAO.writeReview(memberNo);
			return writeReview;

		}

	@Override
	public void insertTempOrderList(List<OrderVO> orderList) {
		mypageDAO.insertTempOrderList(orderList);

	}

	@Override
	@Transactional
	public void updateTempOrderList(Map payInfoMap) throws Exception{
		mypageDAO.updateTempOrderList(payInfoMap);
		int used_point = (int) payInfoMap.get("used_point");
		if (used_point >0) {
			mypageDAO.insertPointHistory(payInfoMap);
			payInfoMap.put("point", -used_point);
			mypageDAO.updateMemberPoint(payInfoMap);
		}
		mypageDAO.insertTossApi(payInfoMap);
		
	}

	@Override
	public void insertAddressWithMap(Map condMap) {
		mypageDAO.insertAddressWithMap(condMap);
	}

	@Override
	public void updateDeliveryAddressWithMap(Map condMap) {
		mypageDAO.updateDeliveryAddressWithMap(condMap);
	}

	@Override
	@Transactional
	public void swapDeliveryAddress(Map condMap, DeliveryAddressVO targetDeliveryAddress) {
		mypageDAO.updateDeliveryAddressWithMap(condMap);
		mypageDAO.updateDeliveryAddress(targetDeliveryAddress);
		mypageDAO.updateMemberAddressWithMap(condMap);
	}
	
	@Override
	public void updateMemberAddressWithMap(Map condMap) {
		mypageDAO.updateMemberAddressWithMap(condMap);
	}

	@Override
	public void deleteDeliveryAddressWithMap(Map condMap) {
		mypageDAO.deleteDeliveryAddressWithMap(condMap);
	}

	@Override
	public OrderVO selectTempOrder(Map condMap) {
		
		return mypageDAO.selectTempOrder(condMap);
	}

	@Override
	public String selectTossApiByOrderNo(int orderNo) {
		
		return mypageDAO.selectTossApiByOrderNo(orderNo);
	}

	@Override
	public boolean isSNSMember(MemberVO memberInfo) {
		String sns_id = mypageDAO.isSNSMember(memberInfo);
		if (sns_id == null || sns_id.trim().length()<1) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * @Override public List<CouponVO> couponSearch(MemberVO memberInfo) throws
	 * DataAccessException { List<CouponVO> couponVO =
	 * mypageDAO.couponSearch(memberInfo); return couponVO; }
	 * 
	 * @Override public List<PointHistoryVO> pointSearch(MemberVO memberInfo) throws
	 * DataAccessException { List<PointHistoryVO> pointHistoryVO =
	 * mypageDAO.pointSearch(memberInfo); return pointHistoryVO; }
	 */

	@Override
	public List<BookmarkVO> selectBookListWithPagingMap(Map pagingMap) {
		 List<BookmarkVO> booklist = mypageDAO.selectBookListWithPagingMap(pagingMap);
		return booklist;
	}

	@Override
	public int selectBookListTotalNum(int memberNo) {
		int num = mypageDAO.selectBookListTotalNum(memberNo);
		return num;
	}

	@Override
	public List<CouponVO> selectCouponListWithPagingMap(Map pagingMap){
		List<CouponVO> couponList = mypageDAO.selectCouponListWithPagingMap(pagingMap);
		return couponList;
	}
	@Override
	public int selectCouponListTotalNum(int memberNo) {
		int num = mypageDAO.selectCouponListTotalNum(memberNo);
		return num;
	}
	
	

}
