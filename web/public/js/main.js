$(document).ready(function () {
 
    if(location.hash == "#goods"){
        $('.goodsUpdate').show();
    } else {
        $('.goodsUpdate').hide();
    }


    let showName = $('.site-name').children('a')
    if (localStorage.getItem('username') == null) {
        showName.text('登录').attr('href', '/login')
    } else {
        showName.text(localStorage.getItem('username'))
    }


    $.ajax({
        url: "http://127.0.0.1:8080/data/goods?goods_list=all",
        type: "get",
        success: function (data){
            let bookAllList = JSON.parse(data)
            for(let book in bookAllList){
                console.log(bookAllList[book])
                let book_li = $('.component-all .component-goods-li').clone(true)
                $('.book-list-ul').append(book_li)
            }
            $('.book-list-ul li').each(function (index, element) {
                $(element).children('a').text(bookAllList[index].name)
                $(element).find('.goods-id').text(bookAllList[index].gid)
                $(element).children('img').attr('src', bookAllList[index].img)
                $(element).children('.book-cart-add').children('a:eq(0)').text('¥'+bookAllList[index].price)
            })
        }

    })

    $.ajax({
        url: "http://127.0.0.1:8080/api/?data=classify",
        type: "get",
        success:function (data){
            var bookClassify = JSON.parse(data);
            for (let i in bookClassify){
                console.log(bookClassify[i]);
                $(".tagCloud-tags").append("<a>"+bookClassify[i]+"</a>");
            }
        }

    })


    //购物车物品ID列表
    let bookList = []
    $(document).on('click', '.book-cart-add svg', function () {
        let bookId = $(this).parent().parent().find('.goods-id').text()
        bookList.push(bookId)
        console.log(bookList)
        $('.cart-num').text('购物车('+bookList.length+')')
    })
    





})

$(document).ready(function () {
    


    let showName = $('.site-name').children('a')
    if (localStorage.getItem('username') == null) {
        showName.text('登录').attr('href', '/login.html')
    } else {
        showName.text(localStorage.getItem('username'))
    }
})



function goodsUpdate() {

    let widget = $('.widget-goodsUpdate');
    let goodsId = widget.attr('key');
    let goodsName = widget.find('input[name=goodsName]').val();
    let goodsPrice = widget.find('input[name=goodsPrice]').val();
    let goodsNum = widget.find('input[name=goodsNum]').val();
    let goodsImg = widget.find('input[name=goodsImg]').val();
    let goodsClassify = widget.find('input[name=goodsClassify]').val();
    let goodsIntro = widget.find('input[name=goodsIntro]').val();
    let goodsBrief = widget.find('input[name=goodsBrief]').val();
    let goods = {
        "gid":goodsId,
        "name": goodsName,
        "price": parseFloat(goodsPrice),
        "classify": goodsClassify,
        "amount": parseInt(goodsNum),
        "date": new Date(),
        "img": goodsImg,
        "brief": goodsBrief,
        "intro": goodsIntro
    };
    
    $.ajax({
        url: "http://localhost:8080/api/?param=goods_update",
        type: "post",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(goods),
        success: function (result) {
            console.log(result);
            if (result.status == "success") {
                alert("修改成功")
            } else {
                alert("修改失败")
            }
        },
        error: function (result) {
            console.log(result.status)
            alert("修改失败")
        }
    })
}  

function goodsAdd() {

    let widget = $('.widget-goodsUpdate');
    let goodsId = widget.attr('key');
    let goodsName = widget.find('input[name=goodsName]').val();
    let goodsPrice = widget.find('input[name=goodsPrice]').val();
    let goodsNum = widget.find('input[name=goodsNum]').val();
    let goodsImg = widget.find('input[name=goodsImg]').val();
    let goodsClassify = widget.find('input[name=goodsClassify]').val();
    let goodsIntro = widget.find('input[name=goodsIntro]').val();
    let goodsBrief = widget.find('input[name=goodsBrief]').val();
    let goods = {
        "name": goodsName,
        "price": parseFloat(goodsPrice),
        "classify": goodsClassify,
        "amount": parseInt(goodsNum),
        "date": new Date(),
        "img": goodsImg,
        "brief": goodsBrief,
        "intro": goodsIntro
    };
    
    $.ajax({
        url: "http://localhost:8080/api/?param=goods_add",
        type: "post",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(goods),
        success: function (result) {
            console.log(result);
            if (result.status == "success") {
                alert("添加成功")
            } else {
                alert("添加失败")
            }
        },
        error: function (result) {
            console.log(result.status)
            alert("添加失败")
        }
    })
}  

function goodsDelete() {

    let widget = $('.widget-goodsUpdate');
    let goodsId = widget.attr('key');
    
    $.ajax({
        url: "http://localhost:8080/api/?param=goods_delete&gid="+goodsId,
        type: "get",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (result) {
            console.log(result);
            if (result.status == "success") {
                alert("删除成功")
            } else {
                alert("删除失败")
            }
        },
        error: function (result) {
            console.log(result.status)
            alert("删除失败")
        }
    })
}  


function autoView() {
    $('#main-menu li').removeClass('current');
    if(location.hash == "#index"){
        $('#main-menu li:eq(0)').addClass('current');
    }
    if(location.hash == "#goods"){
        $('#main-menu li:eq(1)').addClass('current');
        $('.goodsUpdate').show();
    } else {
        $('.goodsUpdate').hide();
    }
    if(location.hash == "#orders"){
        $('#main-menu li:eq(2)').addClass('current');
    }
    if(location.hash == "#users"){
        $('#main-menu li:eq(3)').addClass('current');
    }
    if(location.hash == "#user"){
        $('#main-menu li:eq(4)').addClass('current');
    }
    if(location.hash == "#cart"){
        $('#main-menu li:eq(5)').addClass('current');
    }


    
}