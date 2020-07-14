<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="smenu.jsp" %>

	<!-- 右边页面部分 -->
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
	  <div class="header"> 
					<h1 class="page-header">
						 Charts <small>Show up your stats</small>
					</h1>
					<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li><a href="#">Charts</a></li>
				  <li class="active">Data</li>
				</ol> 
								
	</div>
		<div id="page-inner"> 
		 
			<div class="row"> 
				
				  
						   <div class="col-md-6 col-sm-12 col-xs-12">                     
				<div class="panel panel-default">
					<div class="panel-heading">
						Bar Chart
					</div>
					<div class="panel-body">
						<div id="morris-bar-chart"></div>
					</div>
				</div>            
			</div>
				  <div class="col-md-6 col-sm-12 col-xs-12">                     
				<div class="panel panel-default">
					<div class="panel-heading">
						Area Chart
					</div>
					<div class="panel-body">
						<div id="morris-area-chart"></div>
					</div>
				</div>            
			</div> 
			
	   </div>
			 <!-- /. ROW  -->
			<div class="row">                     
				  
						   <div class="col-md-6 col-sm-12 col-xs-12">                     
				<div class="panel panel-default">
					<div class="panel-heading">
						Line Chart
					</div>
					<div class="panel-body">
						<div id="morris-line-chart"></div>
					</div>
				</div>            
			</div>
				  <div class="col-md-6 col-sm-12 col-xs-12">                     
				<div class="panel panel-default">
					<div class="panel-heading">
						Donut Chart
					</div>
					<div class="panel-body">                            
						<div id="morris-donut-chart"></div>
					</div>
				</div>            
			</div> 
			
	   </div>
			 <!-- /. ROW  -->
			 <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://www.freemoban.com/">www.freemoban.com</a></p></footer>
			</div>
		 <!-- /. PAGE INNER  -->
		</div>
	 <!-- /. PAGE WRAPPER  -->
	</div>
 <!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>
  <!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="assets/js/jquery.metisMenu.js"></script>
 <!-- Morris Chart Js -->
 <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="assets/js/morris/morris.js"></script>
  <!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>
