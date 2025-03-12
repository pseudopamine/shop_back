package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

  //책 정보를 등록하는 쿼리
  public void insertBook(BookDTO bookDTO);

  //JOIN한 카테고리 정보를 불러오는 쿼리
  public List<BookCategoryDTO> selectBookCategoryList();
}
