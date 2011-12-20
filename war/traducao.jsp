<div class="tradutor">
	<form action="/tradutor" method="post">
		<div>
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