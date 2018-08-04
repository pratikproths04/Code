DOM: document object model
	the browser turns every HTML tag into Javascript object
	everything is stored inside of the document object
	the return is the Javascript object, not HTML


DOM select:
	var body = document.queryselector("body");

	document.getElementById()
	document.getElementByClassName()
	document.getElementByTagName()
	document.queryselector()
	document.queryselectorAll()



Open in the browser:
	document.URL: show the url of this page
	document.links: show all the link herf in this page
	document.body
	console.dir(object): show in object form

node list get:
	var tags = document.getElementByClassName("tags");
	node list as tags, not array but array like:
		cannot use forEach()

queryselector select using css way:
	only give the first match, not all of them, the return is an object;

	let tag1 = document.queryselector("h1");//find the item with tag "h1"
	let tag2 = document.queryselector("#highlight");//find the item with id of "#highlight", "." is used for class while "#" is used for id
	let tag3 = document.queryselector("li .good");//like in css, using multiple perspect to find the item
	let tag4 = document.queryselector("h1 + p");//the first p (paragraph) after the h1

queryselectorAll give all the match, the return is the node list;		



DOM manipulaiton, what we can do:
	changing an element style;
	adding/removing classes;
	changing the content of a tag;
	changing attributes(src, href, etc.);

changing an element style example:
	var tag = document.getElementById("highlight");
	tag.style.color = "blue";

	//in css file
	.someclass{
		color: blue;
		border: 10px solid red;
	}
	tag.classList.add("someclass");
	tag.classList.remove("someclass");
	tag.classList.toggle("someclass");//remove when it has, add when it does not have

example 1:
	<p> 
		This is an <strong>awesome</strong> paragraph
	</p>

	var tag = document.queryselector("p")
	tag.textContent//"This is an awesome paragraph"
					//return a string regard of the tags inside the part
	tag.textContent = "blah blah blah"//alter the text content

example 2:
	tag.innerHTML;//This is an <strong>awesome</strong> paragraph

example 3:
	`<a href="www.google.com>I am a link</a>"`
	`<img src="logo.png">`

	var link = document.queryselector("a")
	link.getAttribute("href");//www.google.com
	link.setAttribute("href", "www.dogs.com");//set the href to be the new one

example 4:
	let link = document.queryselector("a")
	link.setAttribute("href", "www.dogs.com");//lead to relative path
	link.setAttribute("href", "http://www.dogs.com");//tell the computer to this path

example 5:
	let link = document.getElementsByTagName("a");
	//a bunch of links
	for (let i = 0; i < link.length; i ++) {
		console.log(link[i].textContent);
	}
	//cannot use foreach, use for loop

DOM Event:
	event, select an element and then add an event listener

Syntax:
	element.addEventListener(type, functionToCall);

example 1:
	var button = document.queryselector("button");
	button.addEventListener("click", function() {
		console.log("good");// a callback function
	});
	//can have more than one event!
	button.addEventListener("click", function() {
		console.log("bad");
	});
	//show good first, then bad


example 2:
	var lis = document.queryselectorAll("li");
	//a bunch of li
	for (var i = 0; i < lis.length; i ++) {
		lis[i].addEventListener("click", function(){
			this.style.color = "pink";
			//use this instead of lis[i]
		});
	}

common events:
	"mouseover"//havor initially show
	"mouseout"//move out initially


jQuery:
	jQuery is the Javascript library

Adding jQuery://jQuery is a javascript file
	`<script type="text/javascript" src="jquery.js"></script>`
	//if you have download it, it is a bit faster

	`<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>`
	//use CDN

Adding in a lib dir:
	`<script type="text/javascript" src="lib\jquery.js"></script>`

$ is the short for jQuery, is a function(){}
how to found the CDN: google 'cdn jquery'


jQuery selctor:
	$("selectorGoesHere"), very similar to queryselectorAll
	provide a CSS style selector

example 1: //select
	$("img") //to select all img tags
	$(".sale") //to select all elements with class 'sale'
	$("#bonus") //to select elements with id "bonus"
	$("li a") //to select all a tags inside of li's

	it will return a list, even it has only one element

example 2: //manipulate style
	.css(property, value)

	$("#special").css("border", "2px solid red");

	var styles = {
		backgroundColor : "pink",
		fontWeight : "bold"
	};
	$("#special").css(styles);

	$("#special").css({
		backgroundColor : "pink",
		fontWeight : "bold"
	});

example 3:
	$("div:first-of-type").css("color", "pink")
	//select the first div, css choice, faster
	$("div:first").css("color", "pink")
	//select the first div, jQuery choice, slower
	$('div[data-myURL="url_id"]')
	//select the element based on attribute value
	$("img").last()//.first()
	//select the last one


jQuery methods:
	.css()
	.text() //like textContent, get and set
	.html() //like innerHTML, get and set
	.attr() //get the value of an attribute or set

	.val() //get the value of the first matched
			//set the value of all matched
	.addClass("myclass yourclass")
	.removeClass()
	.toggleClass()

jQuery event:
	.click()
	.keypress()
	.on()

example 1:
	$('#submit').click(function(){
		console.log("Another click");
	});
	//in jQuery, .click add to all elements, do not need a loop

example 2:
	$('button').click(function(){
		$(this).css('background', 'pink');
		//different than DOM selector
		//in jQuery, use $(this) instead of this
		//jQuery wrapper of this
	})


//keypress is fired between up and down
//keydown and keyup provide a code indicating which key is pressed
//keypress idicates which character was entered
	$('#target').keypress(function(event){
		console.log("press a key");
		if (event.which === 13) {
			alert("you hit enter!");
		}
	})
//event: charcode, keycode, which ---> code of key I pressed
//enter: keyCode 13

example 3:
	on() similar to addEventListener()

	$('#target').on('click', function(){
		console.log("good!");
	})

	in jQuery, use mouseenter and mouseleave in on()

difference between click() and on('click')
	click() add listener for existing elements;
	on() add for the future elements

jQuery effects:

	$('button').on('click', function(){
		$('div').fadeOut(1000, function(){
			//fade just hide it, set display to none
			$(this).remove();
		});
	});
	.fadeIn()
	.fadeToggle()


Backend:
	get:
		retrieve info, ask for
	post:
		post new info to database
	patch/put:
	delete:

	//webroser can only use get request in the search bar
	//https://www.reddit.com/search?q=corgis
	//after ? is the query string, key value pairs,
	//separate by &

Nodejs:
	post form
	`
	<form action='/createDog' method='POST'>//does not matter if post
		<input type="text" name="name" placeholder="name">
		<input type="text" name="breed" placeholder="breed">
		<input type='submit'>
	</form>
	`

basic command line tutorial

start node in command window: ctrl+c twice to end
//interact with Node Console

run a file with node: node <filename>
//run the file as a js file, end in .js

npm:
	package: 
		express
		mongoose

var something = require("cat-me");
//npm install to install a package
//require() to include a package


express framework
//framework and library
//all the control flow is already in the framework
//library you are in control
	heavy and light framework
	express is very light framework


HTTP response/request lifecycle
	routes, listening and dicide what to send back


npm install express --save
// --save flag
package.json dependency

make the package.json: npm init

rendering HTML and templates//from EJS file

ejs:
	treat as javascript <%= %>

ejs condition and loop:


API:
 ifttt.com for the API
 programmableWeb for seaching API

API do not respond with HTML,
it respond with data, xml and json



































































