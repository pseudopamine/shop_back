package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

  //책 정보를 등록하는 쿼리
  public void insertBook(BookDTO bookDTO);

  //JOIN한 카테고리 정보를 불러오는 쿼리
  public List<BookCategoryDTO> selectBookCategoryList();

  //도서 이미지 등록
  //BookDTO에 List<ImgDTO> 변수를 만들어뒀기 때문에 BookDTO를 매개변수로 사용하면 됨
  //public void insertImgs(List<ImgDTO> imgList);
  public void insertImgs(BookDTO bookDTO);

  //다음에 들어갈 BOOK_CODE 조회
  public int getNextBookCode();

}
