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
















