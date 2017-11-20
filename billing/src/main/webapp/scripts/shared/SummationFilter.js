app.filter('summation',function(){
  return function(input){
    var total = 0;
    for(var i=0;i<input.length;i++){
      total += parseFloat(input[i].amount);
    }
    return total;
  };
});
