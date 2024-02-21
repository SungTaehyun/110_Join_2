package com.feb.test.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.test.dao.MemberDao;
import com.feb.test.util.Sha512Encoder;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	public int join(HashMap<String, String> params) {//HashMap은 사용자 정보와 관련된 여러 매개변수를 포함, 입력으로 HashMap인 params받음
		System.out.println("params 222222222222222222222222222222: "  + params);
		
		String passwd = params.get("passwd");//params, HashMap에서 비밀번호를 검색
		System.out.println("params33333333333333: "  + passwd);
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		System.out.println("params 44444444444444422: "  + encoder);
		String encodeTxt = Sha512Encoder.getInstance().getSecurePassword(passwd);
		System.out.println("params 5555555555555552: "  + encodeTxt);
		 params.put("password", encodeTxt); // 매개변수에서 원래의 비밀번호를 인코딩된 비밀번호로 교체
		 System.out.println("params5555555555555555555552: "  + params);
		 return memberDao.join(params); // 업데이트된 params HashMap을 매개변수로 전달하여 memberDao 객체주소에 있는 join 메소드를 호출
	}
	
}

