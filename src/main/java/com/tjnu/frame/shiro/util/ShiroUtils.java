package com.tjnu.frame.shiro.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 *
 * @author bobo
 * @date 2021/04/15
 */
public class ShiroUtils {
    /**
     * 获得当前主体
     * @return
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    /**
     * 获得当前Session
     * @return
     */
    public static Session getSession(){
        return getSubject().getSession();
    }

    /**
     * 获得当前Session
     * @param flag
     * @return
     */
    public static Session getSession(Boolean flag){
        return getSubject().getSession(flag);
    }

    /**
     * 获得session保存的数据
     * @param key
     * @return
     */
    public static Object getSessionAttribute(String key){
        return getSession().getAttribute(key);
    }

    /**
     * 保存数据到session
     * @param key
     * @param value
     */
    public static void setSessionAttribute(String key,Object value){
        getSession().setAttribute(key,value);
    }

    /**
     * 删除 session 数据
     * @param key
     */
    public static void removeSessionAttribute(String key){
        getSession().removeAttribute(key);
    }

    /**
     * 获得当前用户
     * @return
     */
    public static Object getCurrentUser(){
        return getSubject().getPrincipal();
    }

    /**
     * 获得当前用户，以PrincipalCollection的形式
     * @return
     */
    public static PrincipalCollection getPrincipals(){
        return getSubject().getPrincipals();
    }

    /**
     * 获得盐值：用于密码加密作用
     * @return
     */
    public static String getRandomSalt(){
        return RandomStringUtils.random(32,true,true);
    }

    /**
     * 加密
     * @param password
     * @param salt
     * @return
     */
    public static String genPassword(String password,String salt){
        Md5Hash md5Hash = new Md5Hash(password,salt,2);
        return md5Hash.toString();
    }

}
