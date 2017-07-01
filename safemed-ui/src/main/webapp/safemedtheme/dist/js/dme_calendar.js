function dmeAgenda(url, calDivId) {
	var calendar = $(calDivId).fullCalendar({
		header : {
			left : 'prev,next,today',
			center : 'title',
			right : 'month,agendaWeek,agendaDay,listWeek'
		},
		defaultView : 'agendaWeek',
		allDaySlot : false,
		businessHours : {
			dow : [ 0, 1, 2, 3, 4, 5, 6 ],
			start : '08:00',
			end : '19:00'
		},
		minTime : "07:00:00",
		maxTime : "21:00:00",
		events : url,
		timezone : 'local',
		selectable : true,
		eventAllow : function(dropLocation, draggedEvent) {
			return true;
		},
		eventOverlap : function(stillEvent, movingEvent) {
			return stillEvent.id == 'DispoForRv';
		},
		select : function(start, end, jsEvent, view) {
			if (isValidEvent(start, end)) {
				newRv(start.format("DD/MM/YYYY HH:mm"), end.format("DD/MM/YYYY HH:mm"));
			}
			calendar.fullCalendar("unselect");
		},
		eventDrop : function(event, delta, revertFunc, jsEvent, ui, view) {
			if (!isValidEvent(event.start, event.end)) {
				revertFunc();
			}
		},
		eventResize : function(event, delta, revertFunc, jsEvent, ui, view) {
			if (!isValidEvent(event.start, event.end)) {
				revertFunc();
			}
		},
		eventClick : function(calEvent, jsEvent, view) {
			editRv('rvid : '+ calEvent.id, calEvent.title);
			
			$(".dme_event_submit").on("click", function() {
				calEvent.title = $("#seance_titre").val();

				calendar.fullCalendar('updateEvent', calEvent);
				$('.dme_event_close').click();
			});
			calendar.fullCalendar('unselect');
		}
	});
	var isValidEvent = function(start, end) {
		return calendar.fullCalendar('clientEvents', function(event) {
			return (event.rendering === "background"
					&& (start.isAfter(event.start) || start.isSame(event.start,
							'minute')) && (end.isBefore(event.end) || end.isSame(event.end, 'minute')));
		}).length > 0;
	};
}
