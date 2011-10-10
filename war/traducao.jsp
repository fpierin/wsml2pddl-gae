<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Tradutor wsml para web-pddl</title>
  </head>

  <body>
    <h1>Tradutor wsml -> web-pddl</h1>
	<form action="/tradutor" method="post">
		<div>
		<textarea name="documento" rows="20" cols="100">
			<%= 
				((String) request.getAttribute("documento"))
			%>		
		</textarea>
		</div>
		<div><input type="submit" value="Traduzir" /></div>
	</form>
		<br><b>Tradução em PDDL</b><br><br>
			<%= 
				((String) request.getAttribute("compilacao"))
			%>
		<br><br>					
  </body>
</html>
