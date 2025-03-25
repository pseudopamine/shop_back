package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;

import java.util.List;

public interface BookService {

  //책 정보를 등록하는 기능
  public void insertBook(BookDTO bookDTO);

  //JOIN한 카테고리 정보를 불러오는 기능
  public List<BookCategoryDTO> selectBookCategoryList();

  //도서 이미지 등록 기능
  public void insertImgs(BookDTO bookDTO);

  //다음에 들어갈 BOOK_CODE 조회
  public int getNextBookCode();
}
