package com.example.demo.service;

import com.example.demo.controller.dto.MemberCreateRequestDto;
import com.example.demo.controller.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

public class MemberService {

    MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public MemberResponseDto create(MemberCreateRequestDto dto) {
        Member created = memberRepository.save(dto.toEntity());
        return MemberResponseDto.of(created);
    }

    public MemberResponseDto findById(Integer id) {
        Member member = memberRepository.findById(id);
        return MemberResponseDto.of(member);
    }

    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findByAll();
        return members.stream().map(MemberResponseDto::of).toList();
    }

    public MemberResponseDto update(Integer id, MemberCreateRequestDto dto) {
        Member updateMember = memberRepository.update(id, dto.toEntity());
        return MemberResponseDto.of(updateMember);
    }

    public void delete(Integer id) {
        memberRepository.delete(id);
    }
}
