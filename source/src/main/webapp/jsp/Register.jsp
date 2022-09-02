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
                    <div class="col-6 size-select-new-pet custom-select">
                        <p class="color-titles-form ">Age</p>
                        <select name="pet_age" id="age">
                            <!--Insert all ages of the pets-->
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                        
                    </div>
                    <!--Field type-->
                    <div class="col-6 size-select-new-pet custom-select">
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
    <script>
		/* Attributes */
		var x, i, j, l, ll, selElmnt, a, b, c;
		
		/* Look for any elements with the class "custom-select": */
		x = document.getElementsByClassName("custom-select");
		l = x.length;
		
		for (i = 0; i < l; i++) {
			selElmnt = x[i].getElementsByTagName("select")[0];
		  	ll = selElmnt.length;
		  	
		  	/* For each element, create a new DIV that will act as the selected item: */
		  	a = document.createElement("DIV");
		  	a.setAttribute("class", "select-selected");
		  	a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
		  	x[i].appendChild(a);
		  	
		  	/* For each element, create a new DIV that will contain the option list: */
		  	b = document.createElement("DIV");
		  	b.setAttribute("class", "select-items select-hide");
		
			for (j = 1; j < ll; j++) {
			    /* For each option in the original select element, create a new DIV that will act as an option item: */
			    c = document.createElement("DIV");
			    c.innerHTML = selElmnt.options[j].innerHTML;
			    
			    c.addEventListener("click", function(e) {
			    	/* When an item is clicked, update the original select box, and the selected item: */
			        var y, i, k, s, h, sl, yl;
			        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
			        sl = s.length;
			        h = this.parentNode.previousSibling;
			        for (i = 0; i < sl; i++) {
			        	if (s.options[i].innerHTML == this.innerHTML) {
			        		s.selectedIndex = i;
			            	h.innerHTML = this.innerHTML;
			            	y = this.parentNode.getElementsByClassName("same-as-selected");
			            	yl = y.length;
				            for (k = 0; k < yl; k++) {
				            	y[k].removeAttribute("class");
				            }
				            this.setAttribute("class", "same-as-selected");
				            break;
			          }
			        }
			        h.click();
			    });
			    b.appendChild(c);
			  }
			  x[i].appendChild(b);
			  a.addEventListener("click", function(e) {
				  	/* Close any other select boxes, and open/close the current select box: */
				  	e.stopPropagation();
			    	closeAllSelect(this);
			    	this.nextSibling.classList.toggle("select-hide");
			    	this.classList.toggle("select-arrow-active");
			  });
		}
		
		/* Close all selected boxes except the current one*/
		function closeAllSelect(elmnt) {
			var x, y, i, xl, yl, arrNo = [];
		  	x = document.getElementsByClassName("select-items");
		  	y = document.getElementsByClassName("select-selected");
		  	xl = x.length;
		  	yl = y.length;
		  	
		  	for (i = 0; i < yl; i++) {
		  		if (elmnt == y[i]) {
		  			arrNo.push(i)
		    	} else {
		      		y[i].classList.remove("select-arrow-active");
		    	}
		  	}
		  	
		  	for (i = 0; i < xl; i++) {
		    	if (arrNo.indexOf(i)) {
		      		x[i].classList.add("select-hide");
		    	}
		  	}
		}
	
		/* Close all the boxes whenever the user clicks outside the select box items */
		document.addEventListener("click", closeAllSelect);
		
	</script>
</body>
</html>