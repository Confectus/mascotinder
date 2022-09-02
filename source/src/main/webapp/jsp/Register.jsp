<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Pet</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<!-- CSS style sheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
		<%@include file="../templates/banner.html"%>
    <!--Div principal de la mascota-->
    <div class="principal-card">
        <div>
            <h1 class="my-pets-text">New Pet</h1>
        </div>
        <form action="post" action="../RegisterController">
            <fieldset>
                <!--Name's pet-->
                <p class="color-titles-form">Name</p>
                <input type="text" name="pet_name" class="form-content border-conf" style="width: 30%;">
                <!--Field of selection of age and type-->
                <div class="row" style="margin-top: 20px;">
                    <!--Field age-->
                    <div class="col-6 size-select-new-pet">
                        <p class="color-titles-form ">Age</p>
                        <select name="pet_age" id="age" class="select-selected form-content border-conf">
                            <!--Insert all ages of the pets-->
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <!--Field type-->
                    <div class="col-6 size-select-new-pet">
                        <p class="color-titles-form">Type</p>
                        <select name="pet_type" id="type" class="select-selected form-content border-conf">
                            <option>dog</option>
                            <option>cat</option>
                            <option>horse</option>
                            <option>pig</option>
                        </select>
                    </div>
                </div>
                <!--Field sex-->
                <div>
                    <p class="color-titles-form">Sex</p>
                    <select name="pet_sex" id="sex" class="select-selected form-content border-conf"
                        style="width: 10%;">
                        <option value="female">Female</option>
                        <option value="male">Male</option>
                    </select>
                </div>
                <!--Field pictures-->
                <div>
                    <p class="color-titles-form">Pictures</p>
                    <div>
                        <!--Upload photo-->
                        <div>
                            <div>
                                <input type="file" class="pet-margin" name="pet_image" accept="image/png, image/jpeg">
                            </div>

                            <div>
                                <input type="file" class="pet-margin" name="pet_image" accept="image/png, image/jpeg">
                            </div>

                            <div>
                                <input type="file" class="pet-margin" name="pet_image" accept="image/png, image/jpeg">
                            </div>
                        </div>
                    </div>
                </div>
                
                <div>
                    <input type="submit" value="Save" id="submit-btn">
                </div>

            </fieldset>

        </form>

    </div>
</body>
</html>