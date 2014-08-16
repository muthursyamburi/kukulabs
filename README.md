kukulabs
========

This is a collection of all of my personal projects that I am working on or plan to start. KuKu stands for Kunjumani &amp; Kunjunni, names of my sweet little kids :).

Instructions for the Developers
#1. One time activities:
    Open a command prompt and goto your base directory, say C:\bluemix

    # Initializes the git repo
    git init

    # Clone from the remote location
    git clone https://github.com/muthursyamburi/kukulabs.git/
    
    # 
    cd kukulabs/pgms/android

#2. Daily activities:
Everyday before you start, you first need to get all the changes there in the remote. Follow the below steps for the same:

    # Pull all the changes from remote to make the local and remote in sync
    git pull origin master
    
#3. Usual Coding and Checking-In activities:
This happens through the day while you are working with the code.

    #---------------------------------------------------------------------------------
    # Now you do all your changes. You can add new files or modify/delete the existing 
    # ones. Basically all your code changes you can do here.
    #---------------------------------------------------------------------------------

    # Once you are ready to check in back your changes, first you need to add ALL your 
    # changes to your local Staging area (or Index area)
    git add *

    # Commit these changes to your local master
    git commit -m "<Your comments>"

    # Now you are pushing it to the remote master so that everybody can get the changes
    git push origin master


Thats all folks!!!

