linux scripts

vagrant status: check if box is running

connect ssh, connect linux: vagrant ssh

vagrant account/root account password: vagrant
start new vagrant configuration: vagrant reload


virtum machine:

	exit

	vagrant destroy

	vagrant up test2


 cat /vagrant/Vagrantfile
 ls /vagrant

vagrant halt



linux command:

ls -l
	display all file number in the directory

vim filename.sh
	create files and open, filename is not very important

cat filename
	open the file and display

chmod 755 filename
	add excute permission to all users
	r = 4
	w = 2
	x = 1

./filename
	excute the file
	. this directory
	/ directory seperator

mv filename filename2
	change filename

touch filename
	create empty file

type instruction
	if shellbuiltin

assign value
	WORD='script'
	//no space near the = sign
	//can start with chars and underscore

	"$WORD" select the variable
	//single quotes do not expand the variable

	//when reassigning, codes below will change
	USER_NAME=$(id -un)
			=`id -un`

check file type
	:set ff
	:set ff=unix


help file:
	man bash
	/UID for search UID

!'command'
	last command start with 'command'

date +%s
	seconds since unix time









edit .sh file:

i
	insert then you can type

esc
	finish editing

:wq
	save the file





linux script:

# = Sharp
//comment

! = Bang

#! = Shebang,
//it starts with it, it defines the type of commands

echo
	print on the screen


sudo//excute as root user
	super user do
