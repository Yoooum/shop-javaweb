$(document).ready(function () {
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
        url: "http://127.0.0.1:8080/data?classify_list=all",
        type: "get",
        success: function (data){
            let bookAllList = JSON.parse(data)
            for(let book in bookAllList){
                console.log('第二次ajax')
                
            }
            
        }

    })


    //购物车物品ID列表
    let bookList = []
    $('.book-cart-add svg').click(function () {
        let bookID = $(this).prev('.goods-id').text()
        bookList.push(bookID)
        console.log(bookList)
    })



})