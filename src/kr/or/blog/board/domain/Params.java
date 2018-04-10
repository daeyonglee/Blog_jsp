package kr.or.blog.board.domain;

/**
 * 게시글 조회 시 파라미터에 해당하는 속성값의 클래스
 * @author 이대용
 *
 */
public class Params {
	private int selectedPage;
	private String searchType;
	private String searchValue;
	private int pageSize = 10;
	private int pageNum;
	
	public Params() {}

	public Params(int selectedPage, String searchType, String searchValue, int pageSize, int pageNum) {
		super();
		this.selectedPage = selectedPage;
		this.searchType = searchType;
		this.searchValue = searchValue;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public int getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(int selectedPage) {
		this.selectedPage = selectedPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "Params [selectedPage=" + selectedPage + ", searchType=" + searchType + ", searchValue=" + searchValue
				+ ", pageSize=" + pageSize + ", pageNum=" + pageNum + "]";
	}
}
