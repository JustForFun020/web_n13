<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<!-- Common CSS -->
<link rel="shortcut icon" href="/BTLWEB_N13/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="/BTLWEB_N13/css/styles.css" />
<link rel="stylesheet" href="/BTLWEB_N13/css/headerStyle.css" />
<link rel="stylesheet" href="/BTLWEB_N13/css/bodyStyle.css" />
<link rel="stylesheet" href="/BTLWEB_N13/css/footer.css" />
<link rel="stylesheet" href="/BTLWEB_N13/css/todolist.css" />
<!-- Report CSS -->
<link rel="stylesheet" href="/BTLWEB_N13/css/report/report.css" />
<link rel="stylesheet" href="/BTLWEB_N13/css/report/summary.css" />
<link rel="stylesheet" href="/BTLWEB_N13/css/report/ranking.css" />
<jsp:useBean id="u" class="org.btlweb.dao.UserDAOIMPL" scope="request"></jsp:useBean>
<jsp:useBean id="a" class="org.btlweb.dao.TodoListDAO" scope="request"></jsp:useBean>

</head>
<body class="baoboc__ungdung">
	<!-- Main -->
	<main class="ungdung">
		<!-- Header -->
		<jsp:include page="_headerUser.jsp"></jsp:include>
		<!-- Body -->
		<jsp:include page="_bodyUser.jsp"></jsp:include>
		<!-- Footer -->
		<jsp:include page="_footerUser.jsp"></jsp:include>
	</main>
	<!-- JavaScript -->
	<script src="/BTLWEB_N13/js/script.js"></script>
	<script src="/BTLWEB_N13/js/report.js"></script>
	<script src="/BTLWEB_N13/js/todolist.js"></script>
	<script src="/BTLWEB_N13/js/setting.js"></script>
	<!-- <canvas id="myChart" width="400" height="400"></canvas> -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script>
        function createChart(data) {
            const chartData = JSON.parse(data);
            const labels = chartData.map(entry => entry.label);
            const values = chartData.map(entry => entry.data);

            const ctx = document.getElementById('myChart').getContext('2d');
            const chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Thống Kê TodoList',
                        data: values,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        }

        function loadChartData() {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                        const data = xhr.responseText;
                        createChart(data);
                }
            };
            xhr.open("GET", "${pageContext.request.contextPath}/chart", true);
            xhr.send();
        }

        loadChartData();
    </script>
    <script>
    function getData() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var data = JSON.parse(this.responseText);
                document.getElementById("totalValue").innerHTML = data.total;
                document.getElementById("doneValue").innerHTML = data.done;
                document.getElementById("inProcessValue").innerHTML = data.process;
            }
        };
        xhttp.open("GET", "${pageContext.request.contextPath}/hilo", true);
        xhttp.send();
    }
    document.addEventListener("DOMContentLoaded", function() {
        getData();
    });
</script>
</body>
</html>