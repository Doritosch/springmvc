package com.example.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() throws Exception {
        //given
        Member member = new Member("kim", 19);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() throws Exception {
        //given
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 11);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> findAll = memberRepository.findAll();
        //then
        Assertions.assertThat(findAll.size()).isEqualTo(2);
        Assertions.assertThat(findAll).contains(member1, member2);
    }
}