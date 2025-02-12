package com.example.demo.controller;

import com.example.demo.controller.dto.MemberCreateRequestDto;
import com.example.demo.controller.dto.MemberResponseDto;
import com.example.demo.exception.CustomException;
import com.example.demo.service.MemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MemberController {

    MemberService memberService;

    @PostMapping("")
    public ResponseEntity<MemberResponseDto> create(@RequestBody MemberCreateRequestDto dto) {
        MemberResponseDto newDto = memberService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newDto);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<MemberResponseDto> read(@PathVariable Integer id) {
        try {
            MemberResponseDto newDto = memberService.findById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(newDto);
        } catch (CustomException e) {
            log.warn(e.getMessage(), e);
            return ResponseEntity
                    .status(e.getType().getStatus())
                    .body(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/readAll")
    public List<MemberResponseDto> readAll() {
        return memberService.findAll();
    }

    @PutMapping("/update/{id}")
    public MemberResponseDto update(@PathVariable Integer id, @ModelAttribute MemberCreateRequestDto dto) {
        return memberService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        memberService.delete(id);
    }

}
