package com.collegecourses.dao;

import com.collegecourses.domain.Member;
import com.collegecourses.domain.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberDao extends JpaRepository<Member, Long> {

    List<Member> findByMemberType(MemberType memberType);

}
