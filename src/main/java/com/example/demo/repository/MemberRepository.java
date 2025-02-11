package com.example.demo.repository;

import com.example.demo.controller.dto.JobType;
import com.example.demo.repository.entity.Member;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MemberRepository implements IRepository<Member, Integer> {

    private final static Map<Integer, Member> members;

    static {
        members = new HashMap<>();
        members.put(1, new Member("Aaron", 10, JobType.DEVELOPER, "Backend", LocalDateTime.now().plusMinutes(10)));
        members.put(2, new Member("Baron", 20, JobType.DEVELOPER, "Frontend", LocalDateTime.now().plusMinutes(20)));
        members.put(3, new Member("Caron", 30, JobType.ENGINEER, "DevOps/SRE", LocalDateTime.now().plusMinutes(30)));
    }

    private static Integer idCount = 3;

    private static int idG() {
        return ++idCount;
    }

    @Override
    public Member save(Member entity) {
        int idG = idG();
        entity.setId(idG);
        entity.setCreatedAt(LocalDateTime.now());
        members.put(idG, entity);
        return entity;
    }

    @Override
    public Member findById(Integer id) {
        Optional<Member> member = Optional.ofNullable(members.get(id));
        return member.orElseThrow(() -> new IllegalArgumentException("유저가 존재 하지 않습니다. id : " + id));
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
