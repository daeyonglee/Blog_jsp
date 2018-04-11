package kr.or.blog.article.dao;

import java.util.List;

import kr.or.blog.article.domain.Article;
import kr.or.blog.article.domain.Params;

/**
 * 게시글 Dao 인터페이스
 * @author 이대용
 *
 */
public interface ArticleDao {

	/** 게시글 생성 */
	public void create(Article article);
	/** 게시글 조회 */
	public Article read(int articleId);
	/** 게시글 수정 */
	public void update(Article article);
	/** 게시글 삭제 */
	public void delete(int articleId);
	/** 게시글 전체 조회 */
	public List<Article> listAll();
	/** 해당 페이지의 게시글 조회 */
	public List<Article> listPage(int page);
	public List<Article> listPage(int page, String... searchOptions);
	public List<Article> listPage(Params params);
	/** 페이지 수 조회 */
	public int pageCount(Params params);
	/** Hit 수 증가 */
	public void updateHitCount(int articleId);
}
