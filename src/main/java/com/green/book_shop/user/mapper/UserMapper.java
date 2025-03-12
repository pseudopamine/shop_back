package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

  //회원 가입 쿼리
  public boolean insertUserInfo(UserDTO userDTO);

  //회원 ID 조회 쿼리
  public List<UserDTO> selectUserId();

  //회원 ID 중복 확인 쿼리
  public String isUsableUserId(String userId);

  //회원 로그인 쿼리
  public UserDTO login(UserDTO userDTO);



}
