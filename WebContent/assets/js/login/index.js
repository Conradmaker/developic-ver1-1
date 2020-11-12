const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");


document.querySelector('#signIn').addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

document.querySelector('#signUp').addEventListener("click", () => {
  container.classList.add("right-panel-active");
});



//아이디 중복 확인 & 유효성 검사 

//알파벳 숫자만 입력 가능, 4~12자리 
var idJ = /^[a-z0-9]{4,12}$/;
  
document.querySelector('#userId').addEventListener('input', async (e)=>{

  try {
    const response = await axios.get('/dia/idCheck.us?checkId='+e.target.value)
    //  console.log(response.data)
      if(response.data==='fail'){// 1 : 아이디가 중복되는 문구
          document.querySelector("#checkText").innerText="사용중인 아이디입니다.";
          document.querySelector("#checkText").style.color = "red";
          document.querySelector("#formSubmit").setAttribute("disabled", true);

			} else {

          if(idJ.test(e.target.value)){
                    // success : 아이디 길이 / 문자열 검사
                    document.querySelector("#checkText").innerText="";
                    document.querySelector("#formSubmit").disabled=false;
                   // console.log(document.querySelector("#formSubmit").disabled);
                  }else if(e.target.value===""){ //
                    document.querySelector("#checkText").innerText="아이디를 입력해주세요.";
                    document.querySelector("#checkText").style.color = "red";
                    document.querySelector("#formSubmit").disabled=true;
                   // console.log(document.querySelector("#formSubmit").disabled);
                  } else {
                    document.querySelector("#checkText").innerText="아이디는 소문자와 숫자 4~12자리만 가능합니다.";
                    document.querySelector("#checkText").style.color = "red";
                    document.querySelector("#formSubmit").disabled=true;
                  // console.log(document.querySelector("#formSubmit").disabled);
                  }
                }
  } catch (e) {
    console.error(e)
  }



              }
            ); 
	// 비밀번호 유효성 검사 
  document.querySelector('#password-check').addEventListener('input',(e)=>{
    if(document.querySelector('#password-input').value!==e.target.value){
      document.querySelector('#password-error').innerText= '비밀번호를 다시 확인해주세요.'
      document.querySelector('#password-error').style.color='red';
    }else{
      document.querySelector('#password-error').innerText= ''
    }
  })

