package com.dennisce.unittestdemo.Util;

import com.dennisce.unittestdemo.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dennis on 21/05/2017.
 * so.....
 */

public class LoginUtil {
    private Map<String,String> map=new HashMap<>();
    public LoginUtil() {
        map.put("dennis","123456");
        map.put("shell","123456");
        map.put("peach","123456");
    }

    public static LoginUtil newInstance(){
        return new LoginUtil();
    }
    public User login(String userName, String passWord){
      if (!map.containsKey(userName)){
          return null;
      }
      if (!map.get(userName).equals(passWord)){
          return null;
      }
      return User.newInstance(userName);

    }
}
