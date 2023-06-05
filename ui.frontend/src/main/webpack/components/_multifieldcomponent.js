const element = document.querySelectorAll(".text")
const content = document.querySelectorAll(".active")
content[0].classList.add("show")
element.forEach((el, i) => {
    el.addEventListener("click", function () {
        content.forEach((el, index) => {
            el.classList.remove("show")
            element[index].classList.remove("show")
            if (index == i) {
                el.classList.add("show")
                element[index].classList.add("show")
            }
        })
    })
});
element.forEach((el, i) => {
    element[i].classList.remove("show");
})
element[0].classList.add("show");





