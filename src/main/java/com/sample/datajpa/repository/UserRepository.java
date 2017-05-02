package com.sample.datajpa.repository;

import com.sample.datajpa.model.User;
import com.sample.datajpa.to.UserAdminsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.comment = :comment, u.mark=:mark, u.bonus=:bonus WHERE u.email=:email")
    int saveAdminInfo(@Param("email") String email, @Param("mark") String mark, @Param("bonus") Integer bonus, @Param("comment") String comment);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.comment = :#{#uaInfo.comment}, u.mark = :#{#uaInfo.mark}, u.bonus = :#{#uaInfo.bonus}")
    int saveAdminInfoBind(@Param("uaInfo") UserAdminsInfo uaInfo);

    //    https://jira.spring.io/browse/DATAJPA-1103
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.comment = :#{#uaInfo.comment}, u.mark = :#{#uaInfo.mark}, u.bonus = :#{#uaInfo.bonus} WHERE u.email=:email")
    int saveAdminInfoMixBind(@Param("email") String email, @Param("uaInfo") UserAdminsInfo uaInfo);
}