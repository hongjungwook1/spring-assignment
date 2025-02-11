package com.example.demo.service;

import com.example.demo.controller.dto.MemberCreateRequestDto;
import com.example.demo.controller.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.entity.Member;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class MemberService {

    MemberRepository memberRepository;

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
