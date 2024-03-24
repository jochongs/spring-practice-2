package practice2.core.discount;

import practice2.core.member.Member;

public interface DiscountPolicy {

    /**
     * 할인 받는 대상과 금액을 입력받아 할인된 가격을 반환하는 메서드
     * @param member 할인받는 대상
     * @param price 금액
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
