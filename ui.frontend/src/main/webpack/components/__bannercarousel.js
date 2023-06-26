import Swiper, { Navigation, Pagination } from 'swiper';

(function () {
    "use strict";
    var selectors = {
        self: '[data-cmp-is="carousel"]',
    };

    function BannerCarousel(config) {

        function init(config) {

            config.removeAttribute("data-cmp-is");
            const slider = config.querySelector('.cmp-bannercarousel__container');
            const btn = config.querySelector('.cmp-bannercarousel__container__bottom__container__items');
            var btns = btn.querySelectorAll('.cmp-bannercarousel__container__bottom__container__items--list');
            let slides = config.querySelectorAll(".swiper-slide");
            if (slides && window.innerWidth > 786) {
                slides.forEach(slide => {
                    slide.style.display = "none";
                })
                slides[0].style.display = "block";

            }
            config.querySelectorAll('.cmp-bannercarousel__container__bottom__container__items').forEach(el => {
                let btns = el.querySelectorAll('.cmp-bannercarousel__container__bottom__container__items--list');

                for (let i = 0; i < btns.length; i++) {
                    btns[i].addEventListener("click", function () {
                        slides.forEach(slide => {
                            slide.style.display = "none";
                            slide.classList.remove("show")
                        })
                        btns.forEach(btn => {
                            btn.classList.remove("show")
                        })

                        slides[i].style.display = "block";
                        btns[i].classList.add("show")
                    });


                }

            })



            if (slider && window.innerWidth < 786) {
                const swiper = new Swiper('.mySwiper', {
                    modules: [Navigation, Pagination],


                    pagination: {
                        el: '.swiper-pagination',
                        type: 'fraction',

                    },
                    navigation: {
                        nextEl: '.swiper-button-next',
                        prevEl: '.swiper-button-prev',
                    },
                });
            }
        }

        if (config && config.element) {
            init(config.element);
        }
    }
    function onDocumentReady() {
        var elements = document.querySelectorAll(selectors.self);
        for (var i = 0; i < elements.length; i++) {
            new BannerCarousel({ element: elements[i] });
        }

        var MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
        var body = document.querySelector("body");
        var observer = new MutationObserver(function (mutations) {
            mutations.forEach(function (mutation) {
                var nodesArray = [].slice.call(mutation.addedNodes);
                if (nodesArray.length > 0) {
                    nodesArray.forEach(function (addedNode) {
                        if (addedNode.querySelectorAll) {
                            var elementsArray = [].slice.call(addedNode.querySelectorAll(selectors.self));
                            elementsArray.forEach(function (element) {
                                new BannerCarousel({ element: element });
                            });
                        }
                    });
                }
            });
        });

        observer.observe(body, {
            subtree: true,
            childList: true,
            characterData: true
        });
    }

    if (document.readyState !== "loading") {
        onDocumentReady();
    } else {
        document.addEventListener("DOMContentLoaded", onDocumentReady);
    }

}());
