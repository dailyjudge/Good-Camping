	const autoHyphen = (target) => {
		target.value = target.value
		.replace(/[^0-9]/g, '')
		.replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
		}

function searchPw(){
  var form = document.getElementById("PwSearch");
  var name = document.getElementById("pwFind_name");
  var id = document.getElementById("pwFind_id");
  
  if (name.value == "" || id.value == "") {
    alert("값을 입력해주세요");
    name.focus();
    return false;
  }
}
function searchId(){
  var form = document.getElementById("IdSearch");
  var name = document.getElementById("sr_name");
  let nameVal = document.getElementById("sr_name").value;
  let phoneVal = document.getElementById("sr_phone").value;
  
  if (nameVal == "" || phoneVal == "") {
    alert("값을 입력해주세요");
    name.focus();
    return false;
  }
}