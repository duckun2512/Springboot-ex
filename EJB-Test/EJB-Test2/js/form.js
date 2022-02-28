document.addEventListener("DOMContentLoaded", function () {
    var btnSubmit = document.getElementById("btn-submit");
    var loanAmount = document.forms['product-form']['loan'];
    var tenure = document.forms['product-form']['tenure'];
    var interestRate = document.forms['product-form']['interest'];

    btnSubmit.onclick = function () {
        var loan = loanAmount.value;
        var tenure1 = tenure.value;
        var interest = interestRate.value;

        var dataToSend = {
            "loan": loan,
            ""
        }
    }
})