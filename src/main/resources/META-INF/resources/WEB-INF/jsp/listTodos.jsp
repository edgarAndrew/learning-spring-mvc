<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Welcome</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
		<style>
			#cont{
				margin:1rem 2rem;
			}
			.card{
				margin:1rem 1rem;
				padding:0.5rem 0.5rem;
			}
		</style>
	</head>
	<body>
		<%@ include file="common/navigation.jspf"%>
		<div class="card">
		  <div class="card-body">
		   <h4>Hello <small class="text-muted">${email}</small>.</h4>
		  </div>
		</div>
		<div class="card">
		  <div class="card-body d-flex justify-content-center">
		  	<a href="addTodo" class="btn btn-outline-primary">Add Todo</a>
		  </div>
		  <div id="cont">
			<h3>Your Todos</h3>
			<br/>
			<table class="table">
			  <thead>
			    <tr>
			      	<th scope="col">ID</th>
	                <th scope="col">Name</th>
	                <th scope="col">Description</th>
	                <th scope="col">Target Date</th>
	                <th scope="col">Complete</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${todos}" var="todo">
		                <tr>
		                    <td scope="row">${todo.id}</td>
		                    <td>${todo.username}</td>
		                    <td>${todo.description}</td>
		                    <td>${todo.targetDate}</td>
		                    <td>
		                    	<span class="badge rounded-pill
                            		<c:if test="${todo.done}">bg-success text-light</c:if>
                            		<c:if test="${!todo.done}">bg-warning text-dark</c:if>">
                    				${todo.done}
                    			</span>
		                    </td>
		                    <td>
                        		<a href="updateTodo?id=${todo.id}" class="btn btn-primary">Update</a>
								<a href="removeTodo?id=${todo.id}" class="btn btn-outline-danger">Remove</a>
							</td>
		                </tr>
		            </c:forEach>
			  </tbody>
			</table>
		</div>
		</div>
		

		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>