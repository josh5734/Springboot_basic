package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

/**
 * Domain: Member -> Type
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //Null 처리
    Optional<Member> findByName(String name); //Null 처리
    List<Member> findAll();

}
