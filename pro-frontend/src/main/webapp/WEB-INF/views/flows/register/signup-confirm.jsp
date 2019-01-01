<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

				<div class="row">
				
					<!-- column to display personal details -->
					<div class="col-sm-6">
					
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Personal Details</h4>
							</div>
							
							<div class="panel-body">
								<!-- code to display personal details -->
								
							</div>
							
							<div class="panel-footer">
								<!-- anchor to move to the edit of personal details -->
								<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
							</div>
						</div>
					</div>
					
					<!-- column to display address -->
					<div class="col-sm-6">
					
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Billing Address</h4>
							</div>
							
							<div class="panel-body">
								<!-- code to display communication address -->
								
							</div>
							
							<div class="panel-footer">
								<!-- anchor to move to the edit of address -->
								<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
							</div>
						</div>
					</div>
				</div>
				
				<!-- to provide confirm button after displaying details -->
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<div class="text-center">
							<!-- anchor to move to the success page -->
							<a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">Confirm</a>
						</div>
					</div>
				</div>
<%@include file="../shared/flows-footer.jsp" %>