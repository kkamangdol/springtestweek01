package com.sparta.week01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
//id long입력값 = CommentRepository도

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String memo_id;


    public Comment(String contents, String memo_id) {
        this.contents = contents;
        this.memo_id = memo_id;
    }

    public Comment(CommentRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.memo_id = requestDto.getMemo_id();
    }

    public void update(CommentRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.memo_id = requestDto.getMemo_id();
    }
}