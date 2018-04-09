package kr.or.blog.visitors.dao;

import java.util.List;

import kr.or.blog.visitors.domain.GuestBook;

public interface GuestBookDao {

	/**
	 * 방명록 생성
	 * @param guestBook
	 */
	public void create(GuestBook guestBook);
	/**
	 * 방명록 리스트 조회
	 * @return
	 */
	public List<GuestBook> listAll();
}
