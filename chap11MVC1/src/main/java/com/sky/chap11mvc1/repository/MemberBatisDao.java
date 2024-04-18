package com.sky.chap11mvc1.repository;

import com.sky.chap11mvc1.entity.MemberEntity;
import com.sky.chap11mvc1.spring.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberBatisDao {

    @Insert("insert into member (email, password, name, regdate) values (#{member.email}, #{member.password}, #{member.name}, #{member.regdate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(@Param("member") Member member);
    void insertMember(MemberEntity member);
    Member selectByEmail(String email);
    Integer countDao();

    // 멤버 목록 조회
    List<MemberEntity> listDao();

    // 특정 멤버 조회
    MemberEntity viewDao(Long id);

    // 멤버 추가
    void writeDao(MemberEntity member);

    // 멤버 삭제
    void deleteDao(Long id);
}
