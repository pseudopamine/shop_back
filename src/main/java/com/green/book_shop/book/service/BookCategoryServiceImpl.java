package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.mapper.BookCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService {
  private final BookCategoryMapper bookCategoryMapper;


  @Override
  public List<BookCategoryDTO> getBookCategoryList() {
    return bookCategoryMapper.getBookCategoryList();
  }

  //카테고리 등록
  @Override
  public int insertCate(String cateName) {
    int result = 0;
    //카테고리명이 중복인지 확인한다.
    //cateName이 null이면 사용가능한 카테고리명
    //cateName이 null이 아니면 사용 불가능한 카테고리명
    String selectedCateName = bookCategoryMapper.isUsableCateName(cateName);
    //만약 중복이 아니면 카테고리를 등록한다.
    if(selectedCateName == null){
      //카테고리 등록 실행
     result =  bookCategoryMapper.insertCate(cateName);
    }
    return result;
  }

  @Override
  public void deleteCateInfo(int cateCode) {
    bookCategoryMapper.deleteCateInfo(cateCode);
  }


}
