package com.green.book_shop.book.controller;


import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;


  //책 정보를 등록하는 기능 API
  @PostMapping("")
  public void insertBook(@RequestBody BookDTO bookDTO){
    bookService.insertBook(bookDTO);
  }

  //JOIN한 모든 카테고리 정보를 불러오는 기능 API
  @GetMapping("")
  public List<BookCategoryDTO> selectBookCategoryList(){
    return bookService.selectBookCategoryList();
  }

}
