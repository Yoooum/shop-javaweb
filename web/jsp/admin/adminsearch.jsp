<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jc.css">
<script type="text/javascript" src="script/trim.js"></script>
<script type="text/javascript">
  function txtclear()
  {
    document.mfsearch.tsearch.value="";
  }
  function check()
  {
    var key = document.mfsearch.tsearch.value;
    if(key.trim()=="")
    {
      alert("关键字不能为空");
      return;
    }
    document.mfsearch.submit();
  }
 </script>
<form action="${pageContext.request.contextPath}/Search" method="post" name="mfsearch">
      <div>
       <input name="tsearch" value="请输入要搜索的关键字" onfocus="txtclear()"/>
       <input type="button" id="bsearch" name="bsearch" value="搜索" onclick="check()"/>
      </div>	        
</form>