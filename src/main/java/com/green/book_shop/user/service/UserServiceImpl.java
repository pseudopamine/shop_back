package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  private final UserMapper userMapper;

  //회원 가입
  @Override
  public boolean insertUserInfo(UserDTO userDTO) {
    boolean isJoin = false;
    //회원 ID가 중복인지 확인
    //userId가 null이면 사용 가능 (중복아님)
    //userId가 null이 아니면 사용 불가 (중복)
    String selectedUserId = userMapper.isUsableUserId(userDTO.getUserId());
    //만약 중복이 아니면 회원 등록 실행
    if(selectedUserId == null){
      userMapper.insertUserInfo(userDTO);
      isJoin = true;
    }
    return isJoin;
  }

  //회원 ID 조회
  @Override
  public List<UserDTO> selectUserId() {
    return userMapper.selectUserId();
  }

  //로그인하기
  @Override
  public UserDTO login(UserDTO userDTO) {
    return userMapper.login(userDTO);
  }
}
