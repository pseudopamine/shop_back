package com.green.book_shop.user.controller;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  //회원 가입 기능 API
  @PostMapping("")
  public boolean joinUserInfo(@RequestBody UserDTO userDTO){
    return userService.insertUserInfo(userDTO);
  }

  //회원 ID 등록 조회 기능 API
  @GetMapping("")
  public List<UserDTO> getUserId(){
    return userService.selectUserId();
  }

  //회원 로그인 기능 API
  //(get) ~/user/login
  //@PathVariable, @RequestParam으로 전달되는 데이터는
  //url이 노출됨 -> 아이디, 비번 유출 우려 심함
  @GetMapping("/login")
  public UserDTO login(UserDTO userDTO) {
    //조회된 데이터가 있으면 -> 로그인 가능 -> loginUser가 not null
    //조회된 데이터가 없으면 -> 로그인 불가능 -> loginUser가 null
    UserDTO loginUser = userService.login(userDTO);
    return loginUser;
  }
}

