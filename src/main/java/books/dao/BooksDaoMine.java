package books.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import books.vo.BooksVO;

@Repository
public class BooksDaoMine implements BooksDao{
	private SqlSessionTemplate sqlSessionTemplate;
	public BooksDaoMine(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlMapping(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public List<BooksVO> list() {
		return this.sqlSessionTemplate.selectList("list");
	}

	@Override
	public void insert(BooksVO booksVO) {
		sqlSessionTemplate.insert("insert",booksVO);
		
	}

	@Override
	public BooksVO select(int seq) {
		BooksVO vo= (BooksVO) sqlSessionTemplate.selectOne("select",seq);
		return vo;
	}
	@Override
	public List<BooksVO> search(String search) {
		return sqlSessionTemplate.selectList("search",search); 
	}


	
}
