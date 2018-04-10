package kr.or.blog.board.domain;

public class Board {
	
	private Integer boardId;
	private Integer category;
	private String title;
	private String description;
	
	public Board() {}

	public Board(Integer boardId, Integer category, String title, String description) {
		super();
		this.boardId = boardId;
		this.category = category;
		this.title = title;
		this.description = description;
	}



	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", category=" + category + ", title=" + title + ", description="
				+ description + "]";
	}
}
