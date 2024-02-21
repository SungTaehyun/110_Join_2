package com.feb.test.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

// dao --> memberservice --> memberController 

//@Repository 애너테이션을 추가하여 Spring의 빈으로 등록 // @Repository 사용하면 Spring 컨테이너가 MemberDao를 찾아서 인스턴스화하고 필요한 곳에 주입할 수 있따.
@Repository
public interface MemberDao { //MemberService를 사용하기 위해서는 MemberDao가 필요하므로
	//먼저 MemberDao를 구현하고 빈으로 등록해야 한다.

	public int join(HashMap<String, String> params);//params 매개변수를 사용하여 회원 정보를 데이터베이스에 저장
	//params 매개변수 : 사용자의 아이디, 비밀번호, 이메일 등의 회원 정보를 담고 있다.
}