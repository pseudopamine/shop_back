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
  public void insertBook(BookDTO bookDTO,
                         @RequestParam(name = "mainImg", required = true) MultipartFile mainImg,
                         @RequestParam(name = "subImg", required = true) MultipartFile subImg
                         ){
    //첨부파일(도서이미지) : 단일 첨부 업로드 (파일 두개 받아옴)
    uploadUtil.fileUpload(mainImg);
    uploadUtil.fileUpload(subImg);

    //BOOK 테이블에 데이터 INSERT
    bookService.insertBook(bookDTO);

    //BOOK_IMG 테이블에 도서 이미지 정보 INSERT

  }

  //JOIN한 모든 카테고리 정보를 불러오는 기능 API
  @GetMapping("")
  public List<BookCategoryDTO> selectBookCategoryList(){
    return bookService.selectBookCategoryList();
  }

}
