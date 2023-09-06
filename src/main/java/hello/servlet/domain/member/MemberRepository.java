package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HashMap은 동시성 문제가 고려되어 있지 않음. 실무에서는 대신 ConcurrentHashMap, AtomicLong 사용을 고려해야 함
 */
public class MemberRepository {

    //인스턴스가 여러 개 생성돼도 아래 변수들은 static으로 단 하나만 생성되도록 함
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 1L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member){
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
