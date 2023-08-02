<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
<title>Calendar</title>
</head>
<body>
	<h1>Curso JSP - Calendar</h1>
	<div id='calendar'></div>
</body>
<script>

  document.addEventListener('DOMContentLoaded', function() {
	$.get("calendar", function(response) {
		let eventsData = response;
		console.log(eventsData);
		  
	    var calendarEl = document.getElementById('calendar');
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      	initialView: 'dayGridMonth',
	      	navLinks: true,
	    	editable: true,
	    	eventLimit: true,
	      	headerToolbar: {
	          	left: 'prev,next today',
	          	center: 'title',
	          	right: 'dayGridMonth,timeGridWeek,timeGridDay'
	        },
	        events: [eventsData]
	    });
	    calendar.render();
	});
  });

</script>
</html>