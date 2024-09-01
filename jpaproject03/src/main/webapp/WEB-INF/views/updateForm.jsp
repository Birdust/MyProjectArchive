<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>학생 정보 수정</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
    <h3 class="text-center">Spring Data JPA Project I</h3>
    <hr>
    <br />
    <br />
    <div>
      <div class="panel-heading">
        <!-- 학생 정보 수정 페이지의 제목을 출력한다. -->
        <div class="fs-5">학생정보 수정</div>
      </div>
      <div class="panel-body">
        <!-- 학생 정보 수정을 위한 폼을 생성한다. -->
        <form:form action="updateStudent" cssClass="horizental" method="post" modelAttribute="student">
          <div class="form-group">
            <!-- 학생 ID 필드를 숨긴다. -->
            <form:hidden path="id" />
            <label for="name" class="col-md-4 control-label">이름</label>
            <div>
              <!-- 학생의 이름을 입력하는 입력 필드를 생성한다. -->
            <form:input path="name" class="form-control" />
            </div>
            <label for="email" class="col-md-4 control-label">이메일</label>
            <div>
              <!-- 학생의 이메일을 입력하는 입력 필드를 생성한다. -->
              <form:input path="email" class="form-control" />
            </div>
            <label for="address" class="col-md-4 control-label">주소</label>
            <div>
              <!-- 학생의 주소를 입력하는 입력 필드를 생성한다. -->
              <form:input path="address" class="form-control" />
            </div>
          </div>
          <br />
          <div>
            <!-- "수정" 버튼을 생성하여 학생 정보 수정을 서버에 제출한다. -->
            <form:button class="btn btn-primary">수정</form:button>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</div>
<br />
<br />
<div class="footer">
  <!-- 페이지 하단에 Semyung University를 출력한다. -->
  <p>🚀Semyung University</p>
</div>
</body>
</html>