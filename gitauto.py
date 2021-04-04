import os
os.system("git pull")
os.system("cp -r /home/tbm/eclipse-workspace/UserChat/src /home/tbm/git/userchat")
a = input("Commit: ")
os.system("git status")
os.system("git add -A")
os.system("git commit " + "\"" + a + "\"")
os.system("git push")