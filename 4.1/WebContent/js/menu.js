$(document).ready(function () {
    var navTop = $('#navigation').position().top; // returns and assigns the offset top of the nav bar

    $(window).bind('scroll', function () {
        if ($(window).scrollTop() >= navTop)
            $('#navigation').addClass('fixed');
        else
            $('#navigation').removeClass('fixed');
    });

    document.querySelector('#nav-toggle').addEventListener('click', function () {
        this.classList.toggle('active');
    });
    $('#nav-toggle').click(function () {
        $('nav ul').slideToggle();
    });
});