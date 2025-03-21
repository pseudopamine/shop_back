package com.green.book_shop.book.controller;


import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtil uploadUtil;


  //책 정보를 등록하는 기능 API
  @PostMapping("")
  public void insertBook(@RequestBody BookDTO bookDTO,
                         @RequestParam(name = "firstFile", required = false) MultipartFile file){
    //첨부파일(도서이미지) : 단일 첨부 업로드
    uploadUtil.fileUpload(file);
    //BOOK 테이블에 데이터 INSERT
    bookService.insertBook(bookDTO);
  }

  //JOIN한 모든 카테고리 정보를 불러오는 기능 API
  @GetMapping("")
  public List<BookCategoryDTO> selectBookCategoryList(){
    return bookService.selectBookCategoryList();
  }

}
