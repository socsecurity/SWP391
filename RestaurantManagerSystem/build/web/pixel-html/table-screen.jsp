<%-- 
    Document   : table-screen
    Created on : Oct 27, 2021, 6:28:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="noindex,nofollow">
    <title>Table Management</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16"
        href="https://wrappixel.com/demos/free-admin-templates/all-lite-landing-pages/assets/images/logos/pixel-favicon.png">
    <!-- Bootstrap Core CSS -->
    <link href="pixel-html/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="./plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="pixel-html/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="pixel-html/css/colors/green-dark.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
<![endif]-->

<script src="pixel-html/js/sweetalert2.min.js"></script>
<script>
    function deleteConfirm(params) {
        Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
                )
            }
        }) 
    }
    
</script>
</head>

<body>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg "
                    href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i class="fa fa-bars
"></i></a>
                <div class="top-left-part"><a class="logo" href="#"><b><img src="./plugins/images/pixeladmin-logo.png"
                                alt="home" /></b><span class="hidden-xs"><img
                                src="./plugins/images/pixeladmin-text.png" alt="home" /></span></a>
                </div>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <a class="profile-pic" href="#"> <img src="./plugins/images/users/varun.jpg" alt="user-img"
                                width="36" class="img-circle"><b class="hidden-xs">Steave</b> </a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href="dashboard" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                    </li>
                    <li style="padding: 10px 0 0;">
                        <a href="employee" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Employee</span></a>
                    </li>
                    <li style="padding: 10px 0 0;">
                        <a href="TableController" class="waves-effect active"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Table</span></a>
                    </li>
                    <li style="padding: 10px 0 0;">
                        <a href="product" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Food Menu</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Table Management</h4>
                        <p class="text-subtitle text-muted">For employee and admin to check database status table</p>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li class="active"><a href="#">Dashboard</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                 <!-- /row -->
                 <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Table ID</th>
                                            <th>Name</th>
                                            <th>Status</th>
                                            <th>Options</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- start -->
                                        <c:forEach var="table" items="${listT}">
                                            <tr class="click-to-look">
                                                <td>${table.table_id}</td>
                                                <td>${table.name}</td>
                                                <td>
                                                    <c:if test="${table.status == 'AVAILABLE'}">
                                                        <span  class='badge bg-success'> ${table.status}</span>
                                                    </c:if>
                                                    <c:if test="${table.status== 'NOT AVAILABLE'}">
                                                        <span  class='badge bg-danger'> ${table.status}</span>
                                                    </c:if>
                                                    </td>
                                                <td>
                                                    <a href="OrderController?tid=${table.table_id}" class="btn btn-info btn-sm">
                                                        Order
                                                    </a>
                                                        
                                                    <a href="OrderDetailController?tid=${table.table_id}" class="btn btn-info btn-sm">
                                                        Detail
                                                    </a>
                                                    <a href="reset?tid=${table.table_id}" class="btn btn-info btn-sm">
                                                        Reset
                                                    </a>
                                                </td>
                                            </tr> 
                                        </c:forEach>
                                        <!-- end -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="../plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="pixel-html/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <!-- <script src="../plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script> -->
    <!--slimscroll JavaScript -->
    <script src="pixel-html/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="pixel-html/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="pixel-html/js/custom.js"></script>

    
</body>

</html>
