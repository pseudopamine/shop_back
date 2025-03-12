package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookCategoryMapper {

  //모든 카테고리 정보를 불러오는 쿼리
  public List<BookCategoryDTO> getBookCategoryList();

  //카테고리 등록 쿼리
  public int insertCate(String cateName);

  //카테고리명 중복 확인 쿼리
  public String isUsableCateName(String cateName);

  //선택된 카테고리 삭제 쿼리
  public void deleteCateInfo(int cateCode);

}
