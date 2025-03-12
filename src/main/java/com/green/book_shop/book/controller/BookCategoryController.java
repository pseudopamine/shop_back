package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class BookCategoryController {
  private final BookCategoryService bookCategoryService;

  //모든 카테고리 정보를 불러오는 기능 API
  @GetMapping("")
  public List<BookCategoryDTO> getBookCategoryList(){
    return bookCategoryService.getBookCategoryList();
  }

  //카테고리 정보를 등록하는 기능 API
  @PostMapping("")
  public int insertCate(@RequestBody BookCategoryDTO bookCategoryDTO){
    //RequestBody : 넘어오는 객체의 키와 매개변수에 작성한 DTO 클래스의 변수가 일치
    //등록 성공 -> 1 리턴
    //등록 안했으면 -> 0 리턴
    return bookCategoryService.insertCate(bookCategoryDTO.getCateName());
  }

  //선택된 카테고리 정보를 삭제하는 기능 API
  @DeleteMapping("/{cateCode}")
  public void deleteCateInfo(@PathVariable("cateCode") int cateCode){
    bookCategoryService.deleteCateInfo(cateCode);
  }
}
