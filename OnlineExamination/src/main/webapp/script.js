/**
 * 
 */
let time = 60;
let timer = setInterval(() => {
    document.getElementById("timer").innerHTML = "Time Left: " + time;
    time--;
    if (time < 0) {
        clearInterval(timer);
        document.getElementById("examForm").submit();
    }
}, 1000);
