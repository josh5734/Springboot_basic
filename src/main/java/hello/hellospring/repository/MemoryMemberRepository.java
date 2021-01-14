package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
// repository: DB에 접근, 도메인 객체를 DB에 저장하고 관리한다.
/**
 * 동시성 문제가 고려되지 않음, 실무에서는 ConcurrentHashMap, AutomicLong 사용 고려
 */

public class MemoryMemberRepository implements MemberRepository{
    
    // 구현체로 가벼운 메모리 기반의 데이터 저장소 사용
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); // HashMap에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();

    }
}
