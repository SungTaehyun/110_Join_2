<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <!-- 외부 스타일시트 링크 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" >

<script type="text/javascript">
	// 페이지가 로드될 때 실행되는 스크립트
	window.onload = function(e) {
		// 서버에서 전달된 메시지가 있는 경우
		var resultMsg = "${resultMsg}"";

		// 결과 메시지가 존재하면 경고창으로 출력
		if (resultMsg.length > 0) {
		    alert(resultMsg);
		}
	}
</script>
</head>
<body>
<div class="form">
      
      <ul class="tab-group">
        <!-- 탭 그룹 -->
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up for Free</h1>
          <!-- 회원가입 양식 -->
          <form action="<c:url value='/join.do'/>" method="post">
          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <input type="text" name="firstName" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
              <input type="text" name="lastName" required autocomplete="off"/>
            </div>
          </div>
          
           <div class="field-wrap">
            <label>
              MemberId<span class="req">*</span>
            </label>
            <input type="text" name="memberId" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Nickname<span class="req">*</span>
            </label>
            <input type="text" name="nickname" required autocomplete="off"/>
          </div>

          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="passwd" name="passwd" required autocomplete="off"/>
          </div>
          
          <button type="submit" class="button button-block">Get Started</button>
          
          </form>

        </div>
        
        <!-- 로그인 양식 -->
        <div id="login">   
          <h1>Welcome Back!</h1>
          <form action="<c:url value='/loginPage.do'/>" method="post">
          
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="passrd" name="passwd" required autocomplete="off"/>
          </div>
          
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          
          <button type="submit" class="button button-block">Log In</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->

  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <!-- 외부 자바스크립트 파일 링크 -->
  <script  src="${pageContext.request.contextPath}/resources/js/script.js"></script>

</body>
</html>
