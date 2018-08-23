#if statement
if [[ "${UID}" -eq 0 ]]
#-eq = linux, has spaces; -ne !=
# == pattern match in linux
then
  echo 'You are root.'
else
  echo 'You are not root.'
  exit 1 #exit status, not successful will be not 0
fi


#another version of if statement
if [[ "${UID}" -eq 0 ]];then  echo 'You are root.';else  echo 'You are not root.';fi


#Test if cammand successful
#${?} stores last cammand's status
if [[ "${?}" -ne 0 ]]
then
  echo 'The id cammand did not excute successful!'
  exit 1
fi
