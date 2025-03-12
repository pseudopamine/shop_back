package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;

import java.util.List;

public interface UserService {

  //회원 가입 기능
  public boolean insertUserInfo(UserDTO userDTO);

  //회원 ID 조회 기능
  public List<UserDTO> selectUserId();

  //회원 로그인 기능
  public UserDTO login(UserDTO userDTO);
}
