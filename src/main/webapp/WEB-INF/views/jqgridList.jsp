<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Potal</title>


<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui-1.9.2.custom.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/ui.jqgrid.css"/>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.9.2.custom.js"></script> 
<script type="text/javascript" src="resources/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.jqGrid.src.js"></script>
<script type="text/javascript" src="resources/js/i18n/grid.locale-en.js"></script>


<script type="text/javascript">
$(document).ready(function() {
	
	
/*  	$("#list2").jqGrid({
		datatype: "local",
		height: 250,
	   	colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
	   	colModel:[
	   		{name:'id',index:'id', width:60, sorttype:"int"},
	   		{name:'invdate',index:'invdate', width:90, sorttype:"date"},
	   		{name:'name',index:'name', width:100},
	   		{name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
	   		{name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},		
	   		{name:'total',index:'total', width:80,align:"right",sorttype:"float"},		
	   		{name:'note',index:'note', width:150, sortable:false}		
	   	],
	   	multiselect: true
	});
	var mydata = [
			{id:"1",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
			{id:"2",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
			{id:"3",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
			{id:"4",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
			{id:"5",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
			{id:"6",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
			{id:"7",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
			{id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
			{id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
			];
	for(var i=0;i<=mydata.length;i++)
		$("#list2").jqGrid('addRowData',i+1,mydata[i]); 
	
	 */
	//jsonList
	
	
	
	$("#list2").jqGrid({
	   	url:'/jsonList',
		datatype: "json",
	   	colNames:['name','email'],
	   	colModel:[
	   		{name:'NAME', index:'NAME', width:200},
	   		{name:'EMAIL', index:'EMAIL', width:400}	
	   	],
	   	rowNum:10,
	   	rowList:[1,5,10],
	   	pager: '#pager2',
	   	sortname: 'NAME',
	    viewrecords: true,
	    sortorder: "desc",
	    jsonReader: {
		repeatitems : false,
		id: "0"
	},
	    caption:"JSON Example"
	});
	$("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});

	 
});

</script>
</head>
<body>
<table id="list2"></table>
<div id="pager2"></div>
</body>
</html>