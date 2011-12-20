<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div>
	<form action="/tradutor" method="post">
		<div class="tradutor">
			<textarea name="documento">
			<%=((String) request.getAttribute("documento"))%>
			</textarea>
			<textarea name="wsml">
			<%=((String) request.getAttribute("compilacao"))%>
			</textarea>
		</div>
		<div>
			<input type="submit" value="Traduzir" />
		</div>
	</form>
</div>