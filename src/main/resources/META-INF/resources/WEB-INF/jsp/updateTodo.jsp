<html>
<head>
    <title>Update Todo</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
</head>
<style>
    .cont {
        margin: 1rem 2rem;
        width: 90vw;
    }

    body {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>

<body>
<%@ include file="common/navigation.jspf" %>
<div class="card cont">
    <div class="card-body">
        <h4>Update your todo <small class="text-muted">${email}</small>.</h4>
    </div>
</div>
<div class="card cont">
    <form class="card-body" method="post" action="/updateTodo">
        <!-- Add the CSRF token as a hidden input field -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<input type="hidden" name="id" value="${todo.id}"/>
        <div class="row mb-5">
            <h4>Details</h4>
        </div>
        <div class="row mb-5">
            <label for="desc" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="desc" rows="4" name="desc">${todo.description}</textarea>
            </div>
        </div>
        <div class="row mb-5">
            <label for="targetDate" class="col-sm-2 col-form-label">Target date</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="targetDate" name="date" value="${todo.targetDate}">
            </div>
        </div>

        <fieldset class="row mb-5" myattr="${todo.done}" id="status">
            <legend class="col-form-label col-sm-2 pt-0">Status</legend>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="pendingRadio" value="false" name="status"
                           checked>
                    <label class="form-check-label" for="pendingRadio">
                        Pending
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="completeRadio" value="true" name="status">
                    <label class="form-check-label" for="completeRadio">
                        Complete
                    </label>
                </div>
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">Done</button>
    </form>
</div>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" defer>
    jQuery(function () {
        var todoDone = $("#status").attr("myattr");
        console.log(todoDone)
        if (todoDone === 'true') {
            $('#completeRadio').prop('checked', true);
        } else {
            $('#pendingRadio').prop('checked', true);
        }
    });
</script>
</body>
</html>
