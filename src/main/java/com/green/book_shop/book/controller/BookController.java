package com.green.book_shop.book.controller;


import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    //첨부된 파일명은 fileUpload() 메서드에서 만들어짐
    String mainAttachedFileName = uploadUtil.fileUpload(mainImg);
    String subAttachedFileName = uploadUtil.fileUpload(subImg);

    //다음에 들어갈 BOOK_CODE 조회
    int nextBookCode = bookService.getNextBookCode();

    //BOOK 테이블에 데이터 INSERT
    bookDTO.setBookCode(nextBookCode);
    bookService.insertBook(bookDTO);

    //bookDTO에 이미지 데이터 저장
    //실제 데이터가 들어갈 통을 생성
    List<ImgDTO> imgList = new ArrayList<>();
    ImgDTO mainImgDTO = new ImgDTO();
    mainImgDTO.setOriginFileName(mainImg.getOriginalFilename());
    mainImgDTO.setAttachedFileName(mainAttachedFileName);
    mainImgDTO.setIsMain("Y");
    mainImgDTO.setBookCode(nextBookCode);

    ImgDTO subImgDTO = new ImgDTO();
    subImgDTO.setOriginFileName(subImg.getOriginalFilename());
    subImgDTO.setAttachedFileName(subAttachedFileName);
    subImgDTO.setIsMain("N");
    subImgDTO.setBookCode(nextBookCode);

    imgList.add(mainImgDTO);
    imgList.add(subImgDTO);
    bookDTO.setImgList(imgList);


    //BOOK_IMG 테이블에 도서 이미지 정보 INSERT
    bookService.insertImgs(bookDTO); //bookDTO
  }

  //JOIN한 모든 카테고리 정보를 불러오는 기능 API
  @GetMapping("")
  public List<BookCategoryDTO> selectBookCategoryList(){
    return bookService.selectBookCategoryList();
  }

}
