package practice2.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice2.core.AppConfig;

public class MemberServiceTest {

    private AppConfig appConfig;
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        appConfig = new AppConfig();

        memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("멤버 가입 테스트")
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(foundMember);
    }
}
