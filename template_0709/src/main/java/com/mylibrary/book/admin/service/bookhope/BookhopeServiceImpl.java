package com.mylibrary.book.admin.service.bookhope;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mylibrary.book.admin.mapper.BookhopeMapper;
import com.mylibrary.book.admin.vo.BookhopeVO;

@Service
public class BookhopeServiceImpl implements BookhopeService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BookhopeVO> showAll() {
		BookhopeMapper bookhopeMapper = sqlSession.getMapper(BookhopeMapper.class);
		System.out.println("북호프 서비스 임플 왔음");
		return bookhopeMapper.selectAll();
	}
	@Override
	public void deletebh(String bhid){
		System.out.println("삭제하러 왔음.");
		BookhopeMapper bookhopeMapper = sqlSession.getMapper(BookhopeMapper.class);
		bookhopeMapper.deletebh(bhid);
	}
	@Override
	public void insertbh(String btitle, String bauthor, String bpublisher, String bhid) throws Exception{
		System.out.println("insertbh로 북호프 서비스 임플 옴");
		AladinOpenAPI.addtolist(btitle, bauthor, bpublisher);
	}
}
