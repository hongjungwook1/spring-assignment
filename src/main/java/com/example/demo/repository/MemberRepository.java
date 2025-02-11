package com.example.demo.repository;

import com.example.demo.exception.MemberException;
import com.example.demo.repository.entity.Member;

import java.util.*;

public class MemberRepository implements IRepository<Member, Integer> {

    private final static Map<Integer, Member> members = new HashMap<>();
    private static Integer idCount = 0;

    private static int idG() {
        return ++idCount;
    }

    @Override
    public Member save(Member entity) {
        int idG = idG();
        entity.setId(idG);
        members.put(idG, entity);
        return entity;
    }

    @Override
    public Member findById(Integer id) {
        Optional<Member> member = Optional.ofNullable(members.get(id));
        return member.orElseThrow(() -> new MemberException(id));
    }

    @Override
    public List<Member> findByAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Member update(Integer id, Member entity) {
        Member findMember = findById(id);
        entity.setId(findMember.getId());
        members.replace(findMember.getId(), entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        Member findMember = findById(id);
        members.remove(findMember.getId());
    }
}
