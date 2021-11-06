<%-- 
    Document   : index
    Created on : Oct 26, 2021, 8:23:16 PM
    Author     : xuanc
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 4 admin, bootstrap 4, css3 dashboard, bootstrap 4 dashboard, severny admin bootstrap 4 dashboard, frontend, responsive bootstrap 4 admin template, pixel  design, pixel  dashboard bootstrap 4 dashboard template">
    <meta name="description"
        content="Pixel Admin is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>Restaurant Management | Dashboard</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/pixel-admin-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16"
        href="https://wrappixel.com/demos/free-admin-templates/all-lite-landing-pages/assets/images/logos/pixel-favicon.png">
    <!-- Bootstrap Core CSS -->
    <link href="pixel-html/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- toast CSS -->
    <link href="plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
    <!-- morris CSS -->
    <link href="plugins/bower_components/morrisjs/morris.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="pixel-html/css/animate.css" rel="stylesheet">
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
</head>

<body>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg "
                    href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i
                        class="fa fa-bars"></i></a>
                <div class="top-left-part"><a class="logo" href="index.html"><b><img
                                src="plugins/images/pixeladmin-logo.png" alt="home" /></b><span
                            class="hidden-xs"><img src="plugins/images/pixeladmin-text.png" alt="home" /></span></a>
                </div>
                <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                    <li>
                        <form role="search" class="app-search hidden-xs">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i
                                    class="fa fa-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <a class="profile-pic" href="#"> <img src="plugins/images/users/varun.jpg" alt="user-img"
                                width="36" class="img-circle"><b class="hidden-xs">Gao Do</b> </a>
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
                        <a href="TableController" class="waves-effect"><i class="fa fa-clock-o fa-fw"
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
                        <h4 class="page-title">Dashboard</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="dashboard">Dashboard</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- row -->
                <div class="row">
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
                                        class="linea-icon linea-basic"></i>
                                    <h5 class="text-muted vb">MY NEW CLIENTS</h5>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    
                                    <h3 class="counter text-right m-t-15 text-danger">${newClients}</h3>
 
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar"
                                            aria-valuenow="${newClients}" aria-valuemin="0" aria-valuemax="100" style="width: ${newClients}%">
                                            <span class="sr-only">${newClients}% Complete</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                        data-icon="&#xe01b;"></i>
                                    <h5 class="text-muted vb">EMPTY TABLE</h5>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    
                                    
                                    <h3 class="counter text-right m-t-15 text-megna">${emptyTables}</h3>
                                
                            
                            </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-megna" role="progressbar"
                                            aria-valuenow="${emptyTables}" aria-valuemin="0" aria-valuemax="10" style="width: ${emptyTables*10}%">
                                            <span class="sr-only">${emptyTables*10}% Empty table</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                        data-icon="&#xe00b;"></i>
                                    <h5 class="text-muted vb">NEW INVOICES</h5>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    
                                    
                                    
                                    <h3 class="counter text-right m-t-15 text-primary">${invoices}</h3>
                                
                            
                            
                            </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-primary" role="progressbar"
                                            aria-valuenow="${invoices}" aria-valuemin="0" aria-valuemax="100" style="width: ${invoices}%">
                                            <span class="sr-only">40% Complete</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
                <!--row -->
                <!-- <div class="row">
                    <div class="col-md-12">
                        <div class="white-box">
                            <h3 class="box-title">Sales Difference</h3>
                            <ul class="list-inline text-right">
                                <li>
                                    <h5><i class="fa fa-circle m-r-5" style="color: #dadada;"></i>New clients</h5>
                                </li>
                                <li>
                                    <h5><i class="fa fa-circle m-r-5" style="color: #aec9cb;"></i>Returning Clients</h5>
                                </li>
                            </ul>
                            <div id="morris-area-chart2" style="height: 370px;"></div>
                        </div>
                    </div>
                </div> -->
                <!--row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">Recent Bill
                                <div class="col-md-2 col-sm-4 col-xs-12 pull-right">
                                    <select class="form-control pull-right row b-none">
                                        <option>October 1st 2021</option>
                                        <option>October 2nd 2021</option>
                                        <option>October 3rd 2021</option>
                                        <option>October 4th 2021</option>
                                        <option>October 5th 2021</option>
                                    </select>
                                </div>
                            </h3>
                            <div class="table-responsive">
                                <table class="table ">
                                    <thead>
                                        <tr>
                                            <th>NAME</th>
                                            <th>STATUS</th>
                                            <th>DATE</th>
                                            <th>PRICE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                    <c:forEach var="item" items="${listOfOrderWithPrice}">
                                        <tr>
                                            <td class="txt-oflo">${item.getTableName()}</td>
                                            <td> 
                                                <span class="badge ${item.getStatus()=="COMPLETE" ? 'bg-success' : 'bg-danger'}">
                                                    ${item.getStatus()}
                                                </span>
                                            </td>
                                            <td class="txt-oflo">${item.getDate()}</td>
                                            <td>$${item.getTotal()}</td>
                                        </tr>
                                    </c:forEach>
                                        
                                        
                                    </tbody>
                                </table> <a href="#">Check all the sales</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <!-- row -->
                <div class="row">
                    <div class="col-md-12 col-lg-6 col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">Recent Discusstion</h3>
                            <div class="comment-center">
                                <div class="comment-body">
                                    <div class="user-img"> <img src="plugins/images/users/pawandeep.jpg" alt="user"
                                            class="img-circle"></div>
                                    <div class="mail-contnet">
                                        <h5>Gao Vàng</h5> <span class="mail-desc">Món ăn rất ngon</span><a href="javacript:void(0)"
                                            class="action"><i class="ti-close text-danger"></i></a> <a
                                            href="javacript:void(0)" class="action"><i
                                                class="ti-check text-success"></i></a><span
                                            class="time pull-right">April 14, 2016</span>
                                    </div>
                                </div>
                                <div class="comment-body">
                                    <div class="user-img"> <img src="plugins/images/users/sonu.jpg" alt="user"
                                            class="img-circle"> </div>
                                    <div class="mail-contnet">
                                        <h5>Gao Hồng</h5> <span class="mail-desc">Trứng cút chị ăn chưa ngon lắm, chưa chín nha em</span><a href="javacript:void(0)"
                                            class="action"><i class="ti-close text-danger"></i></a> <a
                                            href="javacript:void(0)" class="action"><i
                                                class="ti-check text-success"></i></a><span
                                            class="time pull-right">April 14, 2016</span>
                                    </div>
                                </div>
                                <div class="comment-body b-none">
                                    <div class="user-img"> <img src="plugins/images/users/arijit.jpg" alt="user"
                                            class="img-circle"> </div>
                                    <div class="mail-contnet">
                                        <h5>Gao đen</h5> <span class="mail-desc">Thịt bò hơi bở, Tuy nhiên không thể chê các món kia đuọc, rất là ngon nha</span><a
                                            href="javacript:void(0)" class="action"><i
                                                class="ti-close text-danger"></i></a> <a href="javacript:void(0)"
                                            class="action"><i class="ti-check text-success"></i></a><span
                                            class="time pull-right">April 14, 2016</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="pixel-html/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="pixel-html/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="pixel-html/js/waves.js"></script>
    <!--Counter js -->
    <script src="plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
    <script src="plugins/bower_components/counterup/jquery.counterup.min.js"></script>
    <!--Morris JavaScript -->
    <script src="plugins/bower_components/raphael/raphael-min.js"></script>
    <script src="plugins/bower_components/morrisjs/morris.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="pixel-html/js/custom.min.js"></script>
    <script src="pixel-html/js/dashboard1.js"></script>
    <script src="plugins/bower_components/toast-master/js/jquery.toast.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $.toast({
                heading: 'Welcome to Gao Do',
                text: 'Bây giờ bạn có thể thao tác trên dashboard',
                position: 'top-right',
                loaderBg: '#ff6849',
                icon: 'info',
                hideAfter: 3500,
                stack: 6
            })
        });
    </script>
</body>

</html>