function insereExemplo1() {
	$("textarea#documento").val(
"wsmlVariant _http://www.wsmo.org/wsml/wsml-syntax/wsml-flight\n"+
"namespace { _\"http://www.gsmo.org/dip/travel/domainOntology#\",\n"+
"dc _\"http://purl .org/dc/elements/1.1#\",\n"+
"wsml _http://www.wsmo.org/wsml/wsml-syntax# }\n"+
"ontology TravelOntology\n"+
"concept Ticket\n"+
"annotations\n"+
"dc#description hasValue \"concept of a ticket \"\n"+
"endAnnotations\n"+
"from ofType Region\n"+
"to ofType Region\n"+
"vehicle ofType Vehicle\n"+
"concept Region\n"+
"concept Country subConceptOf Region\n"+
"name ofType _string\n"+
"concept City subConceptOf Region\n"+
"name ofType _string\n"+
"country ofType Country\n"+
"concept EUCity subConceptOf City\n"+
"concept GermanCity subConceptOf EUCity\n"+
"concept AustrianCity subConceptOf EUCity\n"+
"concept UKCity subConceptOf EUCity\n"+
"concept USCity subConceptOf City\n"+
"concept Vehicle\n"+
"seats ofType _integer\n"+
"concept Airplane subConceptOf Vehicle\n"+
"concept Train subConceptOf Vehicle\n"+
"axiom GermanCityDef\n"+
"definedBy\n"+
"?city memberOf GermanCity implies ?city[country hasValue Germany].\n"+
"axiom AustrianCityDef\n"+
"definedBy\n"+
"?city memberOf AustrianCity impliedBy ?city[name hasValue \"Austria\"] memberOf country.\n"+
"axiom UKCityDef\n"+
"definedBy\n"+
"?city memberOf UKCity implies ?city[country hasValue UK].\n"+
"instance Innsbruck memberOf AustrianCity\n"+
"instance Germany memberOf Country\n"+
"name hasValue \"Germany\"\n"+
"instance UK memberOf Country\n"+
"name hasValue \"United Kingdom\"\n"+
"instance Austria memberOf Country\n"+
"name hasValue \"Austria\"\n"+
"");
};

function insereExemplo2() {
	$("textarea#documento").val(
"wsmlVariant _http://www.wsmo.org/wsml/wsml-syntax/wsml-flight" + "\n" +
"namespace { _\"http://www.gsmo.org/dip/travel/goal#\"," + "\n" +
"dO _\"http://www.gsmo.org/dip/travel/domainOntology#\"," + "\n" +
"dc _http://purl.org/dc/elements/1.1# }" + "\n" +
"goal _\"http://www.gsmo.org/dip/travel/goal.wsml\"" + "\n" +
"importsOntology _\"http://www.gsmo.org/dip/travel/domainOntology#TravelOntology\"" + "\n" +
"capability goalCapability" + "\n" +
"postcondition" + "\n" +
"definedBy" + "\n" +
"?ticket [ dO#from hasValue ?from," + "\n" +
"dO#to hasValue ?to ] memberOf dO#Ticket and" + "\n" +
"?from memberOf dO#AustrianCity and" + "\n" +
"?to memberOf dO#UKCity." + "\n");
};

function insereExemplo3() {
	$("textarea#documento").html(
"wsmlVariant _\"http://www.wsmo.org/wsml/wsml-syntax/wsml-rule\"" + "\n" +
"" + "\n" +
"namespace { _\"http://lsirpeople.epfl.ch/lhvu/ontologies/TestFuncDisc/TestGoal.wsml#\"," + "\n" +
"            goalQoS _\"http://lsirpeople.epfl.ch/lhvu/ontologies/TestFuncDisc/TestGoalQoS.wsml#\"," + "\n" +
"            qos _\"http://lsirpeople.epfl.ch/lhvu/ontologies/QoSUpperOntology.wsml#\"," + "\n" +
"            dc _\"http://purl.org/dc/elements/1.1#\"," + "\n" +
"            dO _\"http://www.gsmo.org/dip/travel/domainOntology#\"," + "\n" +
"            wsml _\"http://www.wsmo.org/wsml/wsml-syntax#\"}" + "\n" +
"" + "\n" +
"" + "\n" +
"/********************************************************************************************************************************" + "\n" +
"Definition of a WSMO Goal with QoS specification" + "\n" +
"" + "\n" +
"The requested service should offer the capability of booking a ticket from Austria to UK  by air." + "\n" +
"" + "\n" +
"This requested service has one interface, namely TestGoalInterface." + "\n" +
"" + "\n" +
"This requested interface need to have the following QoS properties:" + "\n" +
"" + "\n" +
" - the average execution time is less than 15 second (mean <= 15 second)." + "\n" +
"" + "\n" +
"Expected return: the matched services in terms of only functional requirement should be Service1a.wsml and Service2a.wsml" + "\n" +
"                 the matched services in terms of both functional and QoS requirement should only be Service2a.wsml" + "\n" +
"                 the matched services in terms of only QoS requirement should be: Service1b.wsml, Service2a.wsml, and Service2b.wsml" + "\n" +
"********************************************************************************************************************************/" + "\n" +
"goal TestGoal" + "\n" +
"    importsOntology _\"http://www.gsmo.org/dip/travel/domainOntology.wsml\"" + "\n" +
"" + "\n" +
"capability TestGoalCapability" + "\n" +
"        postcondition" + "\n" +
"            definedBy" + "\n" +
"                ?ticket[" + "\n" +
"                    dO#from hasValue ?from," + "\n" +
"                    dO#to hasValue ?to," + "\n" +
"                    dO#vehicle hasValue ?vehicle" + "\n" +
"                ] memberOf dO#Ticket and" + "\n" +
"                ?from memberOf dO#AustrianCity and" + "\n" +
"                ?to memberOf dO#UKCity and" + "\n" +
"                ?vehicle memberOf dO#Airplane." + "\n" +
"" +
"interface   TestGoalInterface" + "\n" +
"   importsOntology {_\"http://lsirpeople.epfl.ch/lhvu/ontologies/TestFuncDisc/TestGoalQoS.wsml\"}" + "\n" +
"   nonFunctionalProperties" + "\n" +
"         dc#description hasValue \"Requested QoS properties of a booking web service a user is looking for.\"" + "\n" +
" "+ "\n" +
"         dc#relation    hasValue {" + "\n" +
"                                        goalQoS#satisfiesMyQoSRequirements" + "\n" +
"                                 }" + "\n" +
"   endNonFunctionalProperties" + "\n" +
"   choreography  requestedChoegraphy" + "\n" +
"   orchestration requestedOrchestration	" + "\n"
	
	);
};

function insereExemplo4() {
		$("textarea#documento").html(
"wsmlVariant _\"http://www.wsmo.org/wsml/wsml-syntax/wsml-flight\"" +"\n" +
"" +"\n" +
"namespace {_\"http://www.gsmo.org/dip/travel/goal#\"," +"\n" +
" 	dO _\"http://www.gsmo.org/dip/travel/domainOntology#\"," +"\n" +
"	dc _\"http://purl.org/dc/elements/1.1#\"}" +"\n" +
"/*" +"\n" +
" * Test Goal" +"\n" +
" */" +"\n" +
"goal _\"http://www.gsmo.org/dip/travel/goal.wsml\"" +"\n" +
"	nfp" +"\n" +
"		dc#title hasValue \"Goal\"" +"\n" +
"		dc#contributor hasValue \"Adina Sirbu\"" +"\n" +
 "               dc#description hasValue \"Express the goal of buying a plane ticket from Austria to UK\"" +"\n" +
"	endnfp" +"\n" +
"	importsOntology _\"http://www.gsmo.org/dip/travel/domainOntology.wsml\"" +"\n" +
"	capability goalCapability" +"\n" +
"		postcondition		" +"\n" +
"			definedBy " +"\n" +
"				?ticket[" +"\n" +
"					dO#from hasValue ?from," +"\n" +
"					dO#to hasValue ?to," +"\n" +
"					dO#vehicle hasValue ?vehicle" +"\n" +
"				] memberOf dO#Ticket and" +"\n" +
"				?from memberOf dO#AustrianCity and" +"\n" +
"				?to memberOf dO#UKCity and" +"\n" +
"				?vehicle memberOf dO#Airplane." +"\n"		
		);
};

