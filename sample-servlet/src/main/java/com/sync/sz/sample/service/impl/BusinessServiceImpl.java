package com.sync.sz.sample.service.impl;

import com.sync.sz.sample.dao.UserDao;
import com.sync.sz.sample.dao.impl.UserDaoImpl;
import com.sync.sz.sample.domain.User;
import com.sync.sz.sample.exception.UserExistException;
import com.sync.sz.sample.utils.ServiceUtils;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class BusinessServiceImpl {

  private UserDao dao = new UserDaoImpl();

  public void regiester(User user) throws UserExistException {
    boolean b = dao.find(user.getUsername());
    if (b) {
      throw new UserExistException(); // 注册用户已存在
    } else {
      user.setPassword(ServiceUtils.md5(user.getPassword()));
      dao.add(user);
    }
  }

  public User login(String username, String password) {

    return null;
  }
}
