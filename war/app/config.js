;
(function() {

	_.templateSettings = {
		interpolate : /\<\@\=(.+?)\@\>/gim,
		evaluate : /\<\@([\s\S]+?)\@\>/gim,
		escape : /\<\@\-(.+?)\@\>/gim
	};
	
	BASE_URL = "";
	// BASE_URL = "http://mywoodmancup.appspot.com";

})();