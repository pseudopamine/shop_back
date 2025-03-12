package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
  private final BookMapper bookMapper;


  @Override
  public void insertBook(BookDTO bookDTO) {
    bookMapper.insertBook(bookDTO);
  }

  @Override
  public List<BookCategoryDTO> selectBookCategoryList() {
    return bookMapper.selectBookCategoryList();
  }
}
