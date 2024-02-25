// gsap.to(".img--Container", { top: "50%" ,  duration: 2 });
// gsap.to(".img--Container", { scale: "5" ,  opacity: 0 ,delay:2});
// gsap.to(".img--Container", { display:"none" ,delay:4, duration: 0.1});


updateBtn = document.querySelectorAll(".updateInputBtn")

updateBtn.forEach(function (btn) {

    btn.addEventListener("click", function (e) {

        let data = JSON.parse(e.target.dataset.form);



        document.getElementById("id").value= data.id;
        document.getElementById("title").value = data.title;
        document.getElementById("author").value = data.author;
        document.getElementById("year").value = data.year;
        document.getElementById("name").value = data.name;
        document.getElementById("genre").value = data.genre;


        document.getElementById("updateSubmitBtn").style.display = "initial";
        document.getElementById("cancelBtn").style.display = "initial";
        document.getElementById("registerSubmitBtn").style.display = "none";
        document.getElementById("registerForm").setAttribute("action","UpdateBookServlet");


    })

});




 cancelBtn = document.getElementById("cancelBtn");

    cancelBtn.addEventListener("click", function (e) {
        document.getElementById("updateSubmitBtn").style.display = "none";
        document.getElementById("registerSubmitBtn").style.display = "initial";
        document.getElementById("registerForm").reset();
        document.getElementById("cancelBtn").style.display = "none";
        document.getElementById("registerForm").setAttribute("action","registerForm");
    });






