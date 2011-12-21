<div class="tradutor">
	<form action="/tradutor" method="post">
		<div>
			<textarea id="documento" name="documento">
			<%=((String) request.getAttribute("documento"))%>
			</textarea>
			<textarea id="wsml" name="wsml">
			<%=((String) request.getAttribute("compilacao"))%>
			</textarea>
		</div>
		<div>
			<input type="submit" value="Traduzir" />
		</div>
	</form>
<br>
	<div>
		<p class="title">Exemplos de objetos para tradução</p>
		<p><a href="javascript:;" onclick="insereExemplo1();">Modelo de ontologia proposto por Fensel (2001): Ontolgia de viagem aérea</a></p>
		<p><a href="javascript:;" onclick="insereExemplo2();">Modelo de goal proposto por Fensal (2011): Goal de agendamento de viagem</a></p>
		<p><a href="javascript:;" onclick="insereExemplo3();">http://lsirpeople.epfl.ch/lhvu/ontologies/TestFuncDisc/TestGoal.wsml</a></p>
		<p><a href="javascript:;" onclick="insereExemplo4();">http://wiki.wsmx.org/index.php?title=Discovery_Tutorial</a></p>
	</div>
</div>