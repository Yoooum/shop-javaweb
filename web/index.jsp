<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn" dir="ltr">

<head>
    <meta name="generator" content="Hugo 0.101.0"/>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <meta name='description' content='Prprprprprprprpr---!'>
    <title>未確認の庭師</title>

    <link rel='canonical' href='https://prprv.com/'>

    <link rel="stylesheet" href="css/style.base.css">
    <meta property='og:title' content='未確認の庭師'>
    <meta property='og:description' content='Prprprprprprprpr---!'>
    <meta property='og:url' content='https://prprv.com/'>
    <meta property='og:site_name' content='未確認の庭師'>
    <meta property='og:type' content='website'>
    <meta property='og:updated_time' content=' 2022-08-16T13:02:20&#43;08:00 '/>
    <meta name="referrer" content="no-referrer"/>
    <meta name="twitter:title" content="未確認の庭師">
    <meta name="twitter:description" content="Prprprprprprprpr---!">
    <link rel="alternate" type="application/rss&#43;xml" href="https://prprv.com/index.xml">
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <style>
        .book-list div ul{
            list-style: none;
            display: flex;
            flex-wrap: wrap;
            padding: 0;
        }
        .book-list div ul li {
            list-style: none;
            width: 130px;
            margin: 20px;
            overflow: hidden;
            text-overflow: ellipsis;
            /*height: 300px;*/
            /*border-radius: 10px;*/
            /*background-color: #fff;*/
            /*box-shadow: 0 0 10px #ccc;*/
        }
        .book-list div ul li img {
            width: 100%;
            height: 200px;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px #ccc;
            margin-bottom: 10px;
        }
        .book-list div ul li > a {
            display: block;
            font-size: 16px;
            font-weight: bold;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .book-cart-add a{
            font-size: 18px;
            font-weight: bold;
        }
        .book-cart-add{
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            height: 50px;
        }
    </style>
</head>

<body class="">
<script src="js/jquery-3.6.1.min.js"></script>
<script>
    (function () {

        // const colorSchemeKey = 'StackColorScheme';
        // const colorSchemeItem = localStorage.getItem(colorSchemeKey);
        // const supportDarkMode = window.matchMedia('(prefers-color-scheme: dark)').matches === true;
        //
        // if (colorSchemeItem === 'dark' || colorSchemeItem === 'auto' && supportDarkMode) {
        //     document.documentElement.dataset.scheme = 'dark';
        // } else {
        //     document.documentElement.dataset.scheme = 'light';
        // }
    })();
</script>
<script>
    $(document).ready(function () {
        let showName = $('.site-name').children('a')
        if (localStorage.getItem('username') == null) {
            showName.text('登录').attr('href', '/login')
        } else {
            showName.text(localStorage.getItem('username'))
        }

        let bookAllList = []
        $.ajax({
            url: "/data/goods?goods_list=all",
            type: "get",
            success: function (data){
                bookAllList = JSON.parse(data)
                for(let book in bookAllList){
                    console.log(bookAllList[book])
                    let book_li = $('.book-list-ul li:eq(0)').clone(true)
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

        // $('.book-list-ul li').each(function (index, element) {
        //     $(element).children('a').text('书名' + index)
        //     $(element).find('.goods-id').text(index)
        //     $(element).children('img').attr('src', 'https://img1.doubanio.com/view/subject/l/public/s33956867.jpg')
        // })

        //购物车物品ID列表
        let bookList = []
        $('.book-cart-add svg').click(function () {
            let bookID = $(this).prev('.goods-id').text()
            bookList.push(bookID)
            console.log(bookList)
        })



    })
</script>

<div class="container main-container flex on-phone--column extended">

    <aside class="sidebar left-sidebar sticky ">
        <button class="hamburger hamburger--spin" type="button" id="toggle-menu" aria-label="切换菜单">
                <span class="hamburger-box">
                    <span class="hamburger-inner"></span>
                </span>
        </button>

        <header>
            <figure class="site-avatar">
                <a href="/">
                    <img src="/img/avatar__hu3eeb2aea04ca2baa6616bbe15d9a07da_38267_300x0_resize_box_3.png"
                         width="300" height="300" class="site-logo" loading="lazy" alt="Avatar">
                </a>
                <span class="emoji">🧊</span>
            </figure>
            <div class="site-meta">
                <h1 class="site-name">
                    <a>登录</a>
                </h1>
                <h2 class="site-description">Shop Demo</h2>
            </div>
        </header>

        <ol class="social-menu"></ol>

        <ol class="menu" id="main-menu">

            <li class='current'>
                <a href='/'>
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-home" width="24"
                         height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                         stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"/>
                        <polyline points="5 12 3 12 12 3 21 12 19 12"/>
                        <path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7"/>
                        <path d="M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6"/>
                    </svg>
                    <span>主页预览</span>
                </a>
            </li>

            <li>
                <a href='/admin/goods/'>
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-archive" width="24"
                         height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                         stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"/>
                        <rect x="3" y="4" width="18" height="4" rx="2"/>
                        <path d="M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10"/>
                        <line x1="10" y1="12" x2="14" y2="12"/>
                    </svg>
                    <span>商品管理</span>
                </a>
            </li>

            <li>
                <a href='/admin/orders'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-clipboard">
                        <path d="M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2"></path>
                        <rect x="8" y="2" width="8" height="4" rx="1" ry="1"></rect>
                    </svg>
                    <span>订单管理</span>
                </a>
            </li>

            <li>
                <a href='/admin/users/'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-users">
                        <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                        <circle cx="9" cy="7" r="4"></circle>
                        <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                        <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                    </svg>
                    <span>用户管理</span>
                </a>
            </li>

            <li>
                <a href='/user/'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-user">
                        <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                        <circle cx="12" cy="7" r="4"></circle>
                    </svg>
                    <span>个人中心</span>
                </a>
            </li>

            <li>
                <a href="/shop/cart/">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-shopping-cart">
                        <circle cx="9" cy="21" r="1"></circle>
                        <circle cx="20" cy="21" r="1"></circle>
                        <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                    </svg>
                    <span>购物车(0)</span></a>
            </li>

            <div class="menu-bottom-section">


                <li id="dark-mode-toggle">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                         class="feather feather-power">
                        <path d="M18.36 6.64a9 9 0 1 1-12.73 0"></path>
                        <line x1="12" y1="2" x2="12" y2="12"></line>
                    </svg>
                    <span>退出登录</span>
                </li>

            </div>
        </ol>
    </aside>


    <main class="main full-width">
        <section class="book-list">
            <div>
                <ul class="book-list-ul">
                    <li>
                        <img src="img/book/s33956867.jpg" alt="">
                        <a>置身事内</a>
                        <div class="book-cart-add">
                            <a>¥20.00</a>
                            <a>
                                <span class="goods-id" style="display: none">23</span>
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
        <nav class='pagination'>
            <span class='page-link current'>1</span>
            <a class='page-link' href='/page/2/'>2</a>
            <a class='page-link' href='/page/3/'>3</a>
        </nav>

        <footer class="site-footer">
            <section class="copyright">&copy;2022 未確認の庭師</section>
            <section class="powerby">
                <!-- <a href="https://icp.gov.moe/?keyword=20220570" target="_blank">萌ICP备20220570号</a> <br /> -->
            </section>
        </footer>

    </main>


    <aside class="sidebar right-sidebar sticky">


        <form action="/search/" class="search-form widget">
            <p>
                <label>搜索</label>
                <input name="keyword" required placeholder="输入关键词..."/>

                <button title="搜索">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-search" width="24"
                         height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                         stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"/>
                        <circle cx="10" cy="10" r="7"/>
                        <line x1="21" y1="21" x2="15" y2="15"/>
                    </svg>
                </button>

            </p>
        </form>

        <section class="widget tagCloud">
            <div class="widget-icon">
                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-hash" width="24"
                     height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                     stroke-linecap="round" stroke-linejoin="round">
                    <path stroke="none" d="M0 0h24v24H0z"/>
                    <line x1="5" y1="9" x2="19" y2="9"/>
                    <line x1="5" y1="15" x2="19" y2="15"/>
                    <line x1="11" y1="4" x2="7" y2="20"/>
                    <line x1="17" y1="4" x2="13" y2="20"/>
                </svg>
            </div>
            <h2 class="widget-title section-title">分类</h2>
            <div class="tagCloud-tags">
                <a href="#">手机</a>
                <a href="#">电视</a>
                <a href="#">图书</a>
                <a href="#">DVD</a>
            </div>
        </section>
    </aside>


</div>

</body>

</html>