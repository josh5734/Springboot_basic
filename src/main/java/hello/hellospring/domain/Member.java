package hello.hellospring.domain;

// 도메인: 비즈니스 도메인 객체, 예)회원, 주문 등 DB에 저장하고 관리

import javax.persistence.*;

/**
 * Object relational object
 */
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
