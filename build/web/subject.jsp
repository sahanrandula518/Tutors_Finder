<%-- 
    Document   : subject
    Created on : May 4, 2020, 7:53:17 PM
    Author     : Roshan Withanage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Tutor Finder</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.html">
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <!-- Theme initialization -->
        <script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
                    {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            } else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>
    </head>
    <body onload="load()">
        <div class="main-wrapper">
            <div class="app" id="app">
                <header class="header">
                    <div class="header-block header-block-collapse d-lg-none d-xl-none">
                        <button class="collapse-btn" id="sidebar-collapse-btn">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <div class="header-block header-block-nav">
                        <ul class="nav-profile">
                            <li class="profile dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="img" style="background-image: url('https://avatars3.githubusercontent.com/u/3959008?v=3&amp;s=40')"> </div>
                                    <span class="name"> ${username} </span>
                                </a>
                                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <a class="dropdown-item" href="#">
                                        <i class="fa fa-user icon"></i> ${usertype} </a>
                                    <a class="dropdown-item" href="#">
                                        <a class="dropdown-item" href="login.jsp">
                                            <i class="fa fa-power-off icon"></i> Logout </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </header>
                <aside class="sidebar">
                    <div class="sidebar-container">
                        <div class="sidebar-header">
                            <div class="brand">
                                <div class="logo">
                                    <span class="l l1"></span>
                                    <span class="l l2"></span>
                                    <span class="l l3"></span>
                                    <span class="l l4"></span>
                                    <span class="l l5"></span>
                                </div> Tutor Finder </div>
                        </div>
                        <nav class="menu">
                            <ul class="sidebar-menu metismenu" id="sidebar-menu">
                                <li>
                                    <a href="student.jsp">
                                        <i class="fa fa-home"></i> Student </a>
                                </li>
                                <li class="active">
                                    <a href="subject.jsp">
                                        <i class="fa fa-pencil-square-o"></i> Subject </a>
                                </li>
                                <li>
                                    <a href="tutor.jsp">
                                        <i class="fa fa-pencil-square-o"></i> Tutor </a>
                                </li>
                                <li>
                                    <a href="user.jsp">
                                        <i class="fa fa-pencil-square-o"></i> User </a>
                                </li>


                            </ul>
                        </nav>
                    </div>
                </aside>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                <div class="sidebar-mobile-menu-handle" id="sidebar-mobile-menu-handle"></div>
                <div class="mobile-menu-handle"></div>
                <article class="content responsive-tables-page">
                    <section class="section">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h4 class="card-title"> Subject Table</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table" id="table">
                                                <thead class=" text-primary">
                                                <th>#</th>
                                                <th>Subject_id</th>
                                                <th>Name</th>
                                                <th>Category</th>
                                                <th>Grade</th>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="card card-user">
                                    <div class="card-header">
                                        <h5 class="card-title">Subject Management</h5>
                                    </div>
                                    <div class="card-body">
                                        <form id="form">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <input id="subject_id"  type="hidden" class="form-control" value="0" autocomplete="off">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <input id="name" type="text" onkeypress="validateName()" class="form-control" placeholder="Name" autocomplete="off">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Category</label>
                                                        <input id="category" type="text" class="form-control" placeholder="Category" autocomplete="off">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Grade</label>
                                                        <select class="form-control" id="grade">
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                            <option>6</option>
                                                            <option>7</option>
                                                            <option>8</option>
                                                            <option>9</option>
                                                            <option>10</option>
                                                            <option>11</option>
                                                            <option>12</option>
                                                            <option>13</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="update ml-auto mr-auto">
                                                    <button onclick="save()" type="button" class="btn btn-success btn-round">Save Subject</button>
                                                    <button onclick="update()" type="button" class="btn btn-success btn-round">Update Subject</button>
                                                    <button onclick="delet()" type="button" class="btn btn-success btn-round">Delete Subject</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                </article>
                <footer class="footer">
                    <div class="footer-block author">
                        <ul>
                            <li> created by
                                <a href="#">SLIIT</a>
                            </li>
                            <li>
                                <a href="#">get in touch</a>
                            </li>
                        </ul>
                    </div>
                </footer>

            </div>
        </div>
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
        <script src="js/ajax.js" type="text/javascript"></script>
        <script>
                                                        selectedRowToInput();
                                                        function selectedRowToInput() {
                                                            var table = document.getElementById('table'), rIndex;
                                                            for (var i = 1; i < table.rows.length; i++) {
                                                                table.rows[i].onclick = function () {
                                                                    rIndex = this.rowIndex;
                                                                    document.getElementById("subject_id").value = this.cells[1].textContent;
                                                                    document.getElementById("name").value = this.cells[2].textContent;
                                                                    document.getElementById("category").value = this.cells[3].textContent;
                                                                    document.getElementById("grade").value = this.cells[4].textContent;
                                                                };
                                                            }
                                                        }

                                                        function save() {
                                                            var subject_id = $('#subject_id').val();
                                                            var name = $('#name').val();
                                                            var category = $('#category').val();
                                                            var grade = $('#grade').val();
                                                            var action = "insert";
                                                            if (subject_id === "" || name === "" || category === "" || grade === "") {
                                                                alert("Please Enter All Details")
                                                            } else {
                                                                $.ajax({
                                                                    url: 'SubjectServlet',
                                                                    method: 'POST',
                                                                    data: {action: action, subject_id: subject_id, name: name, category: category, grade: grade},
                                                                    success: function (resultText) {
                                                                        alert(resultText);
                                                                        $("#table").find("tr:gt(0)").remove();
                                                                        load();
                                                                    },
                                                                    error: function (jqXHR, exception) {
                                                                        alert("Fail Ajax");
                                                                    }
                                                                });
                                                            }
                                                        }

                                                        function update() {
                                                            var subject_id = $('#subject_id').val();
                                                            var name = $('#name').val();
                                                            var category = $('#category').val();
                                                            var grade = $('#grade').val();
                                                            var action = "update";
                                                            subject_id = parseInt(subject_id);
                                                            if (subject_id === 0) {
                                                                alert("Please Select to Update")
                                                            } else if (subject_id === "" || name === "" || category === "" || grade === "") {
                                                                alert("Please Enter All Details")
                                                            } else {
                                                                $.ajax({
                                                                    url: 'SubjectServlet',
                                                                    method: 'POST',
                                                                    data: {action: action, subject_id: subject_id, name: name, category: category, grade: grade},
                                                                    success: function (resultText) {
                                                                        alert(resultText);
                                                                        $("#table").find("tr:gt(0)").remove();
                                                                        load();
                                                                    },
                                                                    error: function (jqXHR, exception) {
                                                                        alert("Fail Ajax");
                                                                    }
                                                                });
                                                            }
                                                        }

                                                        function delet() {
                                                            var subject_id = $('#subject_id').val();
                                                            var action = "delete";
                                                            subject_id = parseInt(subject_id);
                                                            if (subject_id === 0) {
                                                                alert("Please Select to Update")
                                                            } else {
                                                                var r = confirm("Are you Sure?");
                                                                if (r == true) {
                                                                    $.ajax({
                                                                        url: 'SubjectServlet',
                                                                        method: 'POST',
                                                                        data: {action: action, subject_id: subject_id},
                                                                        success: function (resultText) {
                                                                            $("#table").find("tr:gt(0)").remove();
                                                                            load();
                                                                            alert("Deleted")
                                                                        },
                                                                        error: function (jqXHR, exception) {
                                                                            alert("Fail Ajax");
                                                                        }
                                                                    });
                                                                } else {
                                                                    alert("Not Deleted")
                                                                }
                                                            }
                                                        }

                                                        function load() {
                                                            var table = document.getElementById('table');
                                                            var action = "serch";
                                                            $.ajax({
                                                                url: 'SubjectServlet',
                                                                method: 'POST',
                                                                data: {action: action},
                                                                success: function (resultText) {
                                                                    resultText = resultText.replace("[", "");
                                                                    resultText = resultText.replace("]", "");
                                                                    var c = [];
                                                                    c = resultText;
                                                                    if (c.length > 5) {
                                                                        var step1 = [];
                                                                        var step2 = [];
                                                                        step1 = resultText.split("~");
                                                                        for (i = 0; i < step1.length; ++i) {
                                                                            step2 = step1[i].split("_");
                                                                            var newRow = table.insertRow(table.length),
                                                                                    cell0 = newRow.insertCell(0),
                                                                                    cell1 = newRow.insertCell(1),
                                                                                    cell2 = newRow.insertCell(2),
                                                                                    cell3 = newRow.insertCell(3),
                                                                                    cell4 = newRow.insertCell(4),
                                                                                    cell5 = newRow.insertCell(5),
                                                                                    k = i + 1;
                                                                            cell0.innerHTML = k;
                                                                            cell1.innerHTML = step2[0];
                                                                            cell2.innerHTML = step2[1];
                                                                            cell3.innerHTML = step2[2];
                                                                            cell4.innerHTML = step2[3];
                                                                            cell5.innerHTML = step2[4];
                                                                            selectedRowToInput();
                                                                        }
                                                                    }
                                                                },
                                                                error: function (jqXHR, exception) {
                                                                    alert("Fail Ajax")
                                                                }
                                                            });
                                                            document.getElementById("form").reset();
                                                        }


                                                        function ValidateEmail() {

                                                            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val()))
                                                            {
                                                                return false;
                                                            }
                                                            alert("Invlid Email");
                                                            return true;

                                                        }
                                                        function onClickValidationContactNumber(evt) {
                                                            var theEvent = evt || window.event;
                                                            // Handle paste
                                                            if (theEvent.type === 'paste') {
                                                                key = event.clipboardData.getData('text/plain');
                                                            } else {
                                                                // Handle key press
                                                                var key = theEvent.keyCode || theEvent.which;
                                                                key = String.fromCharCode(key);
                                                            }
                                                            var regex = /[0-9]/;
                                                            if (!regex.test(key)) {
                                                                theEvent.returnValue = false;
                                                                if (theEvent.preventDefault)
                                                                    theEvent.preventDefault();
                                                            }

                                                        }
                                                        function contactValidation() {
                                                            var phone = $('#phone').val();
                                                            if (phone.length === 10) {
                                                                return false;
                                                            } else {
                                                                alert("Invalid contact Number");
                                                                return true;
                                                            }
                                                        }

                                                        function validateName(evt) {
                                                            var theEvent = evt || window.event;
                                                            // Handle paste
                                                            if (theEvent.type === 'paste') {
                                                                key = event.clipboardData.getData('text/plain');
                                                            } else {
                                                                // Handle key press
                                                                var key = theEvent.keyCode || theEvent.which;
                                                                key = String.fromCharCode(key);
                                                            }
                                                            var regex = /^[a-zA-Z\s]+$/;
                                                            if (!regex.test(key)) {
                                                                theEvent.returnValue = false;
                                                                if (theEvent.preventDefault)
                                                                    theEvent.preventDefault();
                                                            }

                                                        }
        </script>
    </body>

</html>

