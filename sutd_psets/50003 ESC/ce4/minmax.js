function numbers(l) {
    var o = [];
    for (let i in l) {
        var n = parseInt(l[i], 10);
        if (!isNaN(n)) {
            o.push(n);
        }
    }
    return o;
}
// input: an array of numbers
// output: an object containing 'min', with the minimum of the array
//          and 'max' the maximum of the array.
function min_max(a) {
    var min = null;
    var max = null;
    // TODO: fixme
    a.sort()
    min = a[0];
    max = a[a.length - 1];
    return { min: min, max: max };
}

function handleButton1Click() {
    var textbox1 = document.getElementById("textbox1");
    var min = document.getElementById("min");
    var max = document.getElementById("max");
    var items = textbox1.value.split(",");
    var obj = min_max(numbers(items));
    min.innerHTML = obj["min"];
    max.innerHTML = obj["max"];
}

function run() {
    var button1 = document.getElementById("button1");
    // TODO: fixme
}