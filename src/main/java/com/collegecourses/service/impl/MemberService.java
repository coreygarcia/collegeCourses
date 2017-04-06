package com.collegecourses.service.impl;

import com.collegecourses.dao.MemberDao;
import com.collegecourses.domain.Member;
import com.collegecourses.domain.MemberType;
import com.collegecourses.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements IMemberService {

    @Autowired
    MemberDao memberRepository;

    @Override
    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }

    @Override
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public List<Member> findByMemberType(MemberType memberType) {
        return (List) memberRepository.findByMemberType(memberType);
    }

    @Override
    public void delete(Long id) {
        memberRepository.delete(id);
    }

    @Override
    public List<Member> findAllSortedBy() {
        Sort sort = new Sort(Sort.Direction.ASC, "lastName")
                .and(new Sort(Sort.Direction.ASC, "firstName")
                .and(new Sort(Sort.Direction.ASC, "memberType")
                .and(new Sort(Sort.Direction.ASC, "age")
                .and(new Sort(Sort.Direction.ASC, "gender")))));
        return memberRepository.findAll(sort);
    }

}
