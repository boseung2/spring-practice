package org.turtlechain.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turtlechain.springpractice.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
