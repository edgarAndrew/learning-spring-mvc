<html>
	<head>
		<title>Add Todo</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
	</head>
	<style>
		.cont{
			margin:1rem 2rem;
			width:90vw;
		}
		body{
			display:flex;
			flex-direction:column;
			align-items:center;
		}
	</style>
	<body>
		<%@ include file="common/navigation.jspf"%>
		<div class="card cont">
		  <div class="card-body">
		   <h4>Add your todo <small class="text-muted">${email}</small>.</h4>
		  </div>
		</div>
		<div class="card cont cont2">
			<form class="card-body" method="post">
			
			<!-- Add the CSRF token as a hidden input field -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			  <div class="row mb-5">
			    <h4>Details</h4>
			  </div>
			  <div class="row mb-5">
			    <label for="desc" class="col-sm-2 col-form-label">Description</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" id="desc" rows="4" name="desc"></textarea>
			    </div>
			  </div>
			  <div class="row mb-5">
			    <label for="targetDate" class="col-sm-2 col-form-label">Target date</label>
			    <div class="col-sm-10">
			      <input type="date" class="form-control" id="targetDate" name="date">
			    </div>
			  </div>
			  
			  <fieldset class="row mb-5">
			    <legend class="col-form-label col-sm-2 pt-0">Status</legend>
			    <div class="col-sm-10">
			      <div class="form-check">
			        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
			        <label class="form-check-label" for="gridRadios1">
			          Pending
			        </label>
			      </div>
			      <div class="form-check disabled">
			        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
			        <label class="form-check-label" for="gridRadios3">
			          Complete
			        </label>
			      </div>
			    </div>
			  </fieldset>
			  <button type="submit" class="btn btn-primary">Done</button>
			</form>
		</div>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>