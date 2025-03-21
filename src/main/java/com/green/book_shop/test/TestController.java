package com.green.book_shop.test;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
  private final UploadUtil uploadUtil;

  @GetMapping("/1")
  public int test1(){
    return 5;
  }

  //첨부파일 연습1
  //첨부파일을 받기 위해서 formData 객체를 사용,
  //전달되는 데이터의 형태도 multipart/form-data 형식으로 변환해서 전달
  //이렇게 전달되는 데이터를 받기 위한 코드를 변경했기 때문에 다르게 데이터를 전달받아야 한다.
  //DTO 객체로 전달된 데이터를 받되, @RequestBody 어노테이션은 사용하지 않는다.
  //그렇다고 DTO 객체로 첨부파일 정보도 받는 것은 아님
  //첨부파일 데이터를 받을 때는 MultipartFile 인터페이스를 사용해서 따로 따로 받아야 한다.
  @PostMapping("/upload1")
  public void upload1(BookDTO bookDTO,
                      @RequestParam(name = "firstFile", required = false) MultipartFile file){
    //단일 첨부 파일 업로드
    uploadUtil.fileUpload(file);
  }

  //다중 첨부 파일
  //첨부할 파일이 여러 개 들어오면 MultipartFile[] 형태로 데이터를 받는다
  @PostMapping("/upload2")
  public void upload2(@RequestParam(name = "files", required = false) MultipartFile[] files){
    //다중 파일 업로드
    uploadUtil.multiFileUpload(files);
    }

  }


