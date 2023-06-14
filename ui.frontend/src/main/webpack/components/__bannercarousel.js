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
            if (slider) {
                const swiper = new Swiper('.mySwiper', {
                    modules: [Navigation, Pagination],

                    pagination: {
                        el: '.swiper-pagination',
                        type: 'fraction',

                    },
                    navigation: {
                        nextEl: '.cmp-bannercarousel__container--button-next',
                        prevEl: '.cmp-bannercarousel__container--button-prev',
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
