document.getElementById("sliderTemperatura").oninput = function() {
  document.getElementById("valueTemperatura").innerHTML = this.value;
}

document.getElementById("sliderUmidade").oninput = function() {
  document.getElementById("valueUmidade").innerHTML = this.value;
}