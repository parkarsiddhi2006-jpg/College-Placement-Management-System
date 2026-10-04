document.addEventListener("DOMContentLoaded", function () {

    // ==========================================
    // STUDENT REGISTRATION
    // ==========================================

    const registerForm = document.getElementById("registerForm");

    if (registerForm) {

        registerForm.addEventListener("submit", async function (e) {

            e.preventDefault();

            const student = {
                name: document.getElementById("name").value.trim(),
                email: document.getElementById("email").value.trim(),
                branch: document.getElementById("branch").value,
                cgpa: parseFloat(document.getElementById("cgpa").value),
                skills: document.getElementById("skills").value.trim()
            };

            try {

                const response = await fetch(
                    "/api/register",
                    {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(student)
                    }
                );

                if (response.ok) {

                    // Save student in browser also
                    let students =
                        JSON.parse(
                            localStorage.getItem("cpmsStudents")
                        ) || [];

                    students.push(student);

                    localStorage.setItem(
                        "cpmsStudents",
                        JSON.stringify(students)
                    );

                    alert("Registration Successful! 🎉");

                    window.location.href = "login.html";

                } else {

                    alert("Registration Failed!");

                }

            } catch (error) {

                console.error(error);

                alert(
                    "Cannot connect to backend. Please make sure Spring Boot is running."
                );

            }

        });

    }


    // ==========================================
    // STUDENT LOGIN
    // ==========================================

    const loginForm =
        document.getElementById("loginForm");

    if (loginForm) {

        loginForm.addEventListener("submit", function (e) {

            e.preventDefault();

            const email =
                document
                    .getElementById("loginEmail")
                    .value
                    .trim();


            // Get registered students
            const students =
                JSON.parse(
                    localStorage.getItem("cpmsStudents")
                ) || [];


            // Check whether email exists
            const student =
                students.find(function (student) {

                    return student.email === email;

                });


            // If account does not exist
            if (!student) {

                alert(
                    "Account not found. Please create an account first."
                );

                return;

            }


            // Account exists → login successful
            localStorage.setItem(
                "currentStudentEmail",
                email
            );


            alert("Login Successful! 🎉");


            window.location.href =
                "dashboard.html";

        });

    }


    // ==========================================
    // ADMIN LOGIN
    // ==========================================

    const adminLoginForm =
        document.getElementById("adminLoginForm");

    if (adminLoginForm) {

        adminLoginForm.addEventListener("submit", function (e) {

            e.preventDefault();

            const username =
                document
                    .getElementById("adminUsername")
                    .value
                    .trim();

            const password =
                document
                    .getElementById("adminPassword")
                    .value;


            if (
                username === "admin" &&
                password === "admin123"
            ) {

                window.location.href =
                    "admin-dashboard.html";

            } else {

                alert(
                    "Invalid Admin Credentials!"
                );

            }

        });

    }

});