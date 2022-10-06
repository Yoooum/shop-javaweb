<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.List,com.cdzhiyong.domain.Cart" %>

<html>
  <head>
    <title>我的商城</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jc.css">
	<script type="text/javascript" src="script/trim.js"></script>
    <script type="text/javascript">
    	function checkNum(num)
    	{
    		var reg = /^[1-9][0-9]*$/;
    		if(reg.test(num.trim()))
    		{
    			return true;
    		}
    		else
    		{
    			alert("商品数量只能为数字且不能为0！！！");
    			return false;
    		}
    	}
    </script>
  </head>
  <body>
    <jsp:useBean id="cart" class="com.cdzhiyong.domain.Cart" scope="session"/>
    <center>
	<div class="layout">
		<div
			class="line padding-big-top padding-big-bottom navbar bg-blue bg-inverse ">
			<div class="x2">
				<button class="button icon-navicon float-right" data-target="#header-demo3"></button>
				<img src="${pageContext.request.contextPath}/img/jclogo(2).png" width="150" class="padding" height="50" />
			</div>
		</div>
	</div>
    <table width="100%">

      <tr align="center">
        <td>
        <% 
    	if(cart.getCart().size()==0)
    	{
    		out.println("<b>你还没有购买商品</b>");
    	}
    	else
    	{
         %>
	        <table border="0" width="100%">
	         <tr>
	        	<th>商品名称</th>
	        	<th>商品价格</th>
	        	<th>商品数量</th>
	        	<th>删除</th>
	      	</tr>
			<% 
				List<String[]> vgoods = cart.getCartContent();
				int i = 0;
				for(String[] arr:vgoods)
				{
					i++;
					if(i%2==0)
					{
						out.println("<tr align='center'>");
					}
					else
					{
						out.println("<tr align='center' bgcolor='#F5F9FE'>");
					}
			%>
				  <td align="left"><%= arr[0] %></td>
				  <td>￥<%= arr[1] %></td>
				  <form action="${pageContext.request.contextPath}/ChangeNum" method="post"
				  		onsubmit="return checkNum(document.all.gnum<%= arr[3] %>.value);">
				  <td>
				    <input type="text" id="gnum<%= arr[3] %>" name="gnum" value="<%= arr[2] %>" size="10"/>
				    <input type="submit" value="修改"/>
				    <input type="hidden" name="gid" value="<%= arr[3]%>"/>
				  </td>
				  </form>
				  <td><a href="${pageContext.request.contextPath}/DeleteCart?gid=<%= arr[3]%>">删除</a></td>
				</tr>
			<%
				}
			 %>
			   <tr>
			     <td colspan="2"></td>
			     <td align="center"><b>商品价格总计:￥<%= cart.getAccount() %></b></td>
			     <td align="center">
			     <% 
			     	if(session.getAttribute("recMsg")==null)
			     	{
			      %>
			       <a href="${pageContext.request.contextPath}/Balance">
			         <img src="../../img/other/balance.gif" border="0"/>
			       </a>
			      <% 
			      	}
			      	else
			      	{
			       %>
			       <a href="order.jsp">
			         <img src="../../img/other/balance.gif" border="0"/>
			       </a>			       	
			       <% 
			       	}
			        %>
			     </td>
			   </tr>
	        </table>
        <% 
        	}
         %>     
        </td>
      </tr>
    </table>    
    </center>
  </body>
</html>