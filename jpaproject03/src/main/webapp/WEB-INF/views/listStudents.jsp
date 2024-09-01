<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
  <title>전체 학생 정보 조회 </title>
  <!-- Bootstrap  -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
    <h3 class="text-center">Spring Data JPA Project III</h3>
    <hr />
    <!-- "학생등록" 버튼을 생성하고 클릭시 'showForm' 페이지로 이동한다. -->
    <input type="button" value="학생등록" onclick="window.location.href='showForm'; return false;" class="btn btn-primary" />
    <br />
    <br />
    <div class="text-center">
      <div class="panel-heading">
        <!-- "학생 목록" 제목을 출력한다. -->
        <div class="fs-4">학생 목록</div>
      </div>
      <div class="panel-body">
        <!-- 학생 정보를 표시하는 테이블을 생성한다. -->
        <table class="table table-striped table-bordered">
          <hr />
          <tr>
            <!-- 테이블의 각 열(칼럼) 제목을 지정한다. -->
            <th>번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>주소</th>
            <th>비고</th>
          </tr>
          <!-- 학생 목록 데이터를 순회하면서 테이블 행을 생성한다. -->
          <c:forEach var="tempStudent" items="${students}">
            <%--update url --%>
            <c:url var="updateLink" value="/student/updateForm">
              <c:param name="studentId" value="${tempStudent.id}" />
            </c:url>
            <%--delete url --%>
            <c:url var="deleteLink" value="/student/delete">
              <c:param name="studentId" value="${tempStudent.id}" />
            </c:url>
            <!-- 학생 정보를 테이블 행에 출력한다. -->
            <tr>
              <td>${tempStudent.id}</td>
              <td>${tempStudent.name}</td>
              <td>${tempStudent.email}</td>
              <td>${tempStudent.address}</td>
              <td>
                <!-- 학생 정보 수정을 위한 링크를 출력하고 수정 페이지로 이동한다. -->
                <a href="${updateLink}">수정</a> |
                <!-- 학생 정보 삭제를 위한 링크를 출력하고, 삭제 여부를 확인하는 메시지를 표시한다. -->
                <a href="${deleteLink}"onclick="if( !(confirm('선택한 학생을 삭제하시겠습니까?')))return false;">삭제</a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>

    </div>

  </div>

</div>

</body>
</html>