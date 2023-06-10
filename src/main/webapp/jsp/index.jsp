<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pomodoro Timer Online - Pomofocus</title>
    <!-- Font -->
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <!-- Common CSS -->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="stylesheet" href="../css/headerStyle.css" />
    <link rel="stylesheet" href="../css/bodyStyle.css" />
    <link rel="stylesheet" href="../css/footer.css" />
    <link rel="stylesheet" href="../css/todolist.css" />
    <!-- Report CSS -->
    <link rel="stylesheet" href="../css/report/report.css" />
    <link rel="stylesheet" href="../css/report/summary.css" />
    <link rel="stylesheet" href="../css/report/ranking.css" />
    <jsp:useBean id="a" class="org.btlweb.dao.TodoListDAO" scope="request"></jsp:useBean>
  
</head>
<body class="baoboc__ungdung">
    <!-- Main -->
    <main class="ungdung">
      <!-- Header -->
      <jsp:include page="_header.jsp"></jsp:include>
      <!-- Body -->
      <jsp:include page="_body.jsp"></jsp:include>
      <!-- Footer -->
      <jsp:include page="_footer.jsp"></jsp:include>
    </main>
    <!-- JavaScript -->
    <script src="../js/script.js"></script>
    <script src="../js/report.js"></script>
    <script src="../js/todolist.js"></script>
    <script src="../js/setting.js"></script>
  </body>
</html>