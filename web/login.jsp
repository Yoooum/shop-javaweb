<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>登录</title>
  <style>
    * {
      margin: 0;
      padding: 0;
    }

    body {
      background-color: #F8F8F8;
    }

    .container {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .login-wrapper {
      background-color: #fff;
      width: 300px;
      height: 400px;
      border-radius: 10px;
      box-shadow: #e3d3d3 0px 0px 15px;
      padding: 20px;
    }

    /* .form-group {
      height: 32px;
      border: #e3d3d3 1px solid;
      border-radius: 5px;
      box-shadow: #e3d3d3 0px 0px 1px;
      display: flex;
      align-items: center;
      margin-bottom: 10px;
    }

    .form-group label {
      height: 32px;
      width: 100%;
      display: flex;
      align-items: center;
    }

    .form-group label img {
      width: 16px;
      height: 16px;
      margin-left: 10px;
      margin-right: 10px;
    }

    .form-group label input {
      height: 96%;
      width: 100%;
      border: none;
      border-top-right-radius: 5px;
      border-bottom-right-radius: 5px;
      border-left: #e3d3d3 1px solid;
      outline: none;
      padding-left: 10px;
  
      padding-right: 10px;
    }

    .forget-div {
      display: flex;
      justify-content: space-between;
    }

    .login-form a,
    .forget-div a {
      display: block;
      font-size: 12px;
      text-decoration: none;
      color: #000;
      margin-bottom: 5px;
  
    }

    .form-label,
    h2 {
      cursor: default;
    }

    .forget {
      font-size: 12px;
      color: rgb(32, 31, 31);
      cursor: pointer;
    }

    .form-group-submit button[type=submit] {
      width: 100%;
      height: 36px;
      border: #e3d3d3 1px solid;
      border-radius: 5px;
      box-shadow: #e3d3d3 0px 0px 1px;
      background-color: #414141;
      color: #fff;
      margin-top: 5px;
      cursor: pointer;
    }

    .no-account {
      display: flex;
      margin-top: 10px;
      font-size: 12px;
      color: rgb(32, 31, 31);
      cursor: default;
    }

    .no-account a {
      color: #000;
      font-size: 13px;
      text-align: center;
      cursor: pointer;
    }

    .login-title {
      color: #000;
      font-weight: bold;
      margin-bottom: 20px;
    } */
    .login-header {
      margin-bottom: 20px;
    }

    .form-label,
    .submit-wrap {
      width: (100%-2px);
      height: 36px;
      border: #e3d3d3 1px solid;
      border-radius: 5px;
      box-shadow: #e3d3d3 0px 0px 1px;
      display: flex;
      align-items: center;
      margin: 5px 0 10px 0;
    }

    .submit-wrap {
      width: 100%;
      height: 38px;
      border: none;
      box-shadow: none;
    }

    .form-submit {
      width: 100%;
      height: 100%;
      border: #e3d3d3 1px solid;
      border-radius: 5px;
      box-shadow: #e3d3d3 0px 0px 1px;
      background-color: #414141;
      color: #fff;
      cursor: pointer;
    }

    .form-text-little {
      font-size: 12px;
      color: #201f1f;
      cursor: default;
    }

    .form-svg {
      width: 16px;
      height: 16px;
      margin-left: 10px;
      margin-right: 10px;
    }

    .form-input {
      height: 100%;
      width: 100%;
      border: none;
      border-top-right-radius: 5px;
      border-bottom-right-radius: 5px;
      border-left: #e3d3d3 1px solid;
      outline: none;
      padding-left: 10px;
      padding-right: 10px;
      vertical-align: middle;
      line-height: 20px;
    }

    .pwd-forget {
      float: right;
      text-decoration: none;
      font-weight: bold;
      color: #000;
      cursor: pointer;
    }

    .form-style {
      text-decoration: none;
      font-weight: bold;
      color: #000;
      cursor: pointer;
    }

    .switch-div {
      display: flex;
    }

    .div-between {
      justify-content: space-between;
    }
  </style>
  <script src="js/jquery-3.6.1.min.js"></script>
  <script>
    $(document).ready(function () {
      
      $("input").focus(function () {
        $(this).attr("placeholder", "");
        // $(this).parent().css({"border":"#000 1px solid"});
      });
      $("input[type=text]").blur(function () {
        $(this).attr("placeholder", "用户");
        // $(this).parent().css({"border":"#e3d3d3 1px solid"});
      });
      $("input[type=email]").blur(function () {
        $(this).attr("placeholder", "邮箱");
        // $(this).parent().css({"border":"#e3d3d3 1px solid"});
      });
      $("input[type=password]").blur(function () {
        $(this).attr("placeholder", "密码");
        // $(this).parent().css({"border":"#e3d3d3 1px solid"});
      });

      $(".pwd-forget").click(function () {
        $(".input-password .form-label").slideToggle("fast");
        $(".reg-show").toggle();
        if ($(this).hasClass("now-forget")) {
          $(".login-form form").attr("action", "/login");
          $(this).removeClass("now-forget");
          $(this).text("忘记密码？");
          $(".forget-text").text("密码");
          $(".form-submit,.login-title").text("登录");
        } else {
          $(this).addClass("now-forget");
          $(".login-form form").attr("action", "/forget");
          $(this).text("返回登录？");
          $(".forget-text").text("重置链接将发送到邮箱");
          $(".form-submit").text("发送");
          $(".login-title").text("重置密码");
        }
      });

      $(".form-style").click(function () {
        $(".input-username").slideToggle("fast");
        $(".pwd-forget").toggle();
        if ($(this).hasClass("form-login")) {
          $(this).removeClass("form-login");
          $(".login-form form").attr("action", "/register");
          $(".login-title,.form-submit").text("注册");
          $(".no-account").text("已有账号？");
          $(this).text("登录");
        } else {
          $(this).addClass("form-login");
          $(".login-form form").attr("action", "/login");
          $(".login-title,.form-submit").text("登录");
          $(".no-account").text("没有账号？");
          $(this).text("注册");
        }
      });

    })

    function form_check_(){
        var email = $("input[name='email']").val();
        var password = $("input[name='password']").val();
        if(email == ""){
          alert("邮箱不能为空");
          return false;
        }
        if(password == ""){
          alert("密码不能为空");
          return false;
        }
        if(password.length < 6){
          alert("密码长度不能小于6位");
          return false;
        }
        if(email.indexOf("@") == -1){
          alert("邮箱格式不正确，需包含 @");
          return false;
        }
        if(email.indexOf(".") == -1){
          alert("邮箱格式不正确，需包含 .");
          return false;
        }
        return true;

      }
  </script>
</head>

<body>
  <div class="container">
    <div class="login-wrapper">
      <div class="login-header">
        <img src="" alt="">
        <h2 class="login-title">登录</h2>
      </div>
      <div class="login-form">
        <form action="login" method="post" onsubmit="return form_check()">

          <div class="form-group input-username" style="display:none">
            <div class="form-text-little">用户</div>
            <label class="form-label" for="username">
              <img class="form-svg" src="img/icons/user.svg" alt="">
              <input class="form-input" type="text" name="username" placeholder="用户" id="username">
            </label>
          </div>

          <div class="form-group input-email">
            <div class="form-text-little">邮箱</div>
            <label class="form-label" for="email">
              <img class="form-svg" src="img/icons/mail.svg" alt="">
              <input class="form-input" type="email" name="email" placeholder="邮箱" id="email">
            </label>
          </div>

          <div class="form-group input-password">
            <div class="switch-div div-between">
              <div class="form-text-little forget-text">密码</div>
              <a class="form-text-little pwd-forget" href="#">忘记密码？</a>
            </div>
            <label class="form-label" for="password">
              <img class="form-svg" src="img/icons/lock.svg" alt="">
              <input class="form-input" type="password" name="password" placeholder="密码" id="password">
            </label>
          </div>

          <div class="form-group submit-wrap"><button class="form-submit" type="submit">登录</button></div>

          <div class="switch-div reg-show">
            <div class="form-text-little no-account">没有账号？</div><a class="form-text-little form-style form-login">注册</a>
          </div>

        </form>
      </div>
    </div>
  </div>
</body>

</html>