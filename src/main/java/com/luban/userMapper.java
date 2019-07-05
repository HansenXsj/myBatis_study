package com.luban;

public interface userMapper {
    public Person findUserById(int id)throws Exception;
    public Person findUser()throws Exception;
}
