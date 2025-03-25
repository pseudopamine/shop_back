package com.green.book_shop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//첨부 파일 기능 모음 클래스
@Component //객체 생성
public class UploadUtil {
  //application.properties 파일에 정의한
  //file.upload.dir 값을 가져와서 uploadPath 변수에 저장
  @Value("${file.upload.dir}")
  private String uploadPath;

  //단일 파일 업로드
  public String fileUpload(MultipartFile file){
    //파일을 첨부했을 때만 실행
    if(file != null) {
      //첨부기능 실행
      //화면에서 선택한 원본 파일명
      String originFileName = file.getOriginalFilename();

      //첨부할 파일명
      String attachFileName = getAttachedFileName(originFileName);

      //업로드 경로와 파일명을 연결 -> 완성본 ex) D:\01-STUDY\devel\ShopProject\backEnd\.....
      //File class
      File f = new File(uploadPath + attachFileName);

      try {
        //파일 첨부
        //첨부한 file을 실제 업로드 할 경로(f)로 옮긴다
        file.transferTo(f);  //실제 업로드 기능을 가진 코드. file을 f로 옮긴다.
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return attachFileName;
    }
    return null;
  }

  //다중 파일 업로드
  public void multiFileUpload(MultipartFile[] files){
    for(MultipartFile eachFile : files){
      fileUpload(eachFile);
    }
  }

  //원본 파일명에서 첨부할 파일명을 생성하는 메서드
  public String getAttachedFileName(String originFileName){

    //첨부할 파일명 (랜덤한 문자열 생성)
    String uuid = UUID.randomUUID().toString();
    //abc.jpg  -> iowesf-dfsosg-sfdjkl 로 랜덤하게 변경되면 확장자도 사라지기 때문에 확장자는 그대로 가져와야 함

    //화면에서 선택한 파일의 확장자 추출
    //abc.jpg
    //노란줄 : 파일명에 확장자가 없을 때 생기는 오류를 고려해줌
    String[] result = originFileName.split("\\."); //"aa.bb.cc" -> ["aa", "bb", "cc"]
    String extension = result[result.length - 1]; //끝의 확장자만 추출하겠다
    //["abc", "jpg"]
    //abc.test.jpg -> ["abc", "test", "jpg"]

    //첨부할 파일명
    String attachFileName = uuid + "." + extension;
    return attachFileName;
  }

}

