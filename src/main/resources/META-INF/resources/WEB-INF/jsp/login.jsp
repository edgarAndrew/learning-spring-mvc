<html>
	<head>
		<title>Login</title>
		<style type="text/css">
			body{
				margin:0px;
				padding:0px;
				position:relative
			}
			#cont{
				position:absolute;
				top:35%;
				left:35%;
				display:flex;
				flex-direction:column;
				row-gap:2rem;
				align-items:center;
				padding:3rem 4rem;
				border: 1px solid black
			}
			#cont > div {
				width:100%;
				display:flex;
				column-gap:2rem;
				justify-content:space-between;
			}
			button{
				padding:0.5rem 0.9rem;
			}
			input{
				padding:0.3rem 0.5rem;
				border-radius:20px;
			}
		</style>
	</head>
	<body>
		<form id="cont" method="POST">
			<div>
				<label>Email</label>
				<input type="text" name="email"/>
			</div>
			<div>
				<label>Password</label>
				<input type="password" name="password"/>
			</div>
			<button type="submit">Login</button>
		</form>
	</body>
</html>