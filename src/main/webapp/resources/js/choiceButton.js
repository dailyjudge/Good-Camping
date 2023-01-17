$(function() {
	
	const st = {};

	st.flap = document.querySelector('#camping-choice-flap');
	st.toggle = document.querySelector('.camping-choice-toggle');

console.log($('#camping-choice-flap'));
console.log(document.querySelector('#camping-choice-flap'));
st.choice1 = document.querySelector('#choice1');
st.choice2 = document.querySelector('#choice2');

console.log("st.flap : " + st.flap);
console.log("st.toggle : " + st.toggle);
console.log("st.choice1 : " + st.choice1);
console.log("st.choice2 : " + st.choice2);


st.flap.addEventListener('transitionend', () => {

    if (st.choice1.checked) {
        st.toggle.style.transform = 'rotateY(-15deg)';
        setTimeout(() => st.toggle.style.transform = '', 400);
        console.log(1);
    } else {
        st.toggle.style.transform = 'rotateY(15deg)';
        setTimeout(() => st.toggle.style.transform = '', 400);
        console.log(2);
    }

})

st.clickHandler = (e) => {

    if (e.target.tagName === 'LABEL') {
        setTimeout(() => {
        	console.log(3);
        }, 250);
    }
}

document.addEventListener('DOMContentLoaded', () => {
	console.log(4);
    st.flap.children[0].textContent = st.choice2.nextElementSibling.textContent;
});

document.addEventListener('click', (e) => st.clickHandler(e));
});