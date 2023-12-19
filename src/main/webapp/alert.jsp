<%--
  Created by IntelliJ IDEA.
  User: tkrit
  Date: 12/13/2023
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/4b0836c960.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="button">
        <button onclick="showToast(SingUpSuccess)">Sign Up Success</button>
        <button onclick="showToast(SignUpFail)">Sign Up Fail</button>
        <button onclick="showToast(InvalidAccount)">Invalid Account</button>
        <button onclick="showToast(SignInSuccess)">Sign In Success</button>
    </div>

    <div id="toastBox"></div>
    <script>

        let toastBox=document.getElementById('toastBox');
        let SingUpSuccess='<i class="fa-solid fa-circle-check"></i>Sing Up Success';
        let SignUpFail='<i class="fa-solid fa-circle-xmark"></i>Sign Up Fail';
        let InvalidAccount='<i class="fa-solid fa-circle-xmark"></i>Invalid Account';
        let SignInSuccess='<i class="fa-solid fa-circle-check"></i>Sign In Success';


        function showToast(msg){
            let toast=document.createElement('div');
            toast.classList.add('toast');
            toast.innerHTML=msg;
            toastBox.appendChild(toast);

            if(msg.includes('Fail')){
                toast.classList.add('Fail');
                //toast.classList.add('invalid');
            }
            if(msg.includes('Invalid')){
                toast.classList.add('Invalid');
            }

            setTimeout(()=>{
                toast.remove();
            },6000);

        }
    </script>
</body>
</html>
