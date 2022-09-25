var checks = document.querySelectorAll(".btn-check");
var max = 5;
for (var i = 0; i < checks.length; i++)
    checks[i].onclick = selectiveCheck;
function selectiveCheck (event) {
    var checkedChecks = document.querySelectorAll(".btn-check:checked");
    if (checkedChecks.length >= max + 1)
        return false;
}