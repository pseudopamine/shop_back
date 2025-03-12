package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;

import java.util.List;

public interface BookCategoryService {

  //모든 카테고리 정보를 불러오는 기능
  public List<BookCategoryDTO> getBookCategoryList();

  //카테고리 등록 기능
  public int insertCate(String cateName);

  //선택된 카테고리 삭제 기능
  public void deleteCateInfo(int cateCode);


}
