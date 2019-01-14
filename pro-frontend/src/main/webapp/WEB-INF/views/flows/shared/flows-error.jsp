<%@include file="flows-header.jsp" %>
<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h1>Please contact your administrator!</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
								${flowExecutionException}
							
							</blockquote>						

							<blockquote style="word-wrap:break-word">
								
								${rootCauseException}
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
<%@include file="flows-footer.jsp" %>