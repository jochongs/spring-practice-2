package practice2.core.order;

import practice2.core.discount.DiscountPolicy;
import practice2.core.discount.FixDisountPolicy;
import practice2.core.member.Member;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDisountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
