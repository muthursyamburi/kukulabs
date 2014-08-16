kukulabs
========

This is a collection of all of my personal projects that I am working on or plan to start. KuKu stands for Kunjumani &amp; Kunjunni, names of my sweet little kids :).

Instructions for the Developers
1. One time activities:
    Open a command prompt and goto your base directory, say C:\bluemix

    # Initializes the git repo
    git init

    # Clone from the remote location
    git clone https://hub.jazz.net/git/dmuthuku/ItemLowestPrice_POC
    
2. Daily activities:
Everyday before you start, you first need to get all the changes there in the remote. Follow the below steps for the same:

    # Specify the credential store location
    git config --global credential.helper store

    # This will keep your credentials in memory for the next 3600 seconds(ie, 1 hour)
    # If want, you can increase the timeout or decrease it
    #
    git config --global credential.helper "cache --timeout=3600"

    # Check if there is already a remote called 'origin' existing there
    git remote -v

    # If there is nothing like that, add the 'origin' remote
    git remote add origin https://hub.jazz.net/git/dmuthuku/ItemLowestPrice_POC

    # Sets the remote URL
    git remote set-url origin https://hub.jazz.net/git/dmuthuku/ItemLowestPrice_POC

    # Goto the local directory where all the source code is there
    cd ItemLowestPrice_POC

    # Pull all the changes from remote to make the local and remote in sync
    git pull origin master
    
3. Usual Coding and Checking-In activities:
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

