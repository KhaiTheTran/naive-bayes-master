# CSE 312: Naive Bayes


**DEADLINES**

**Due: Friday, February 8th 10:00 PM**

**IMPORTANT**: Try to get started on Naive Bayes early so that you can come to the Office Hours in case you face problems with any of the parts.

## 0\. Outline
1. [Git](README.md#1-getting-started) **(not necessary for this assignment and you can skip this part, but it's good for learning about Git)**
2. [Submitting your assignment](README.md#2-submitting-your-assignment)
    * [Simple turn-in instructions](README.md#simple-turn-in-instructions) **(does not require knowledge of git)**
    * [Using Git for turn-in](README.md#using-git-for-turn-in) (requires having set up Git in part 1)

## 1\. Git

The following instructions are written for a Unix-based platform (e.g., Linux, MacOS, etc.) Because the code is written in Java, it should work under Windows as well, though the directions in this document may not apply.

### 1.1\. Working with Git

We will be using `git`, a source code control tool. This will allow you to download the code for the assignment, and also submit it in a standardized format that will streamline grading.

You will also be able to use `git` to commit your progress on the labs
as you go. This is **important**: Use `git` to back up your work. Back
up regulary by both committing and pushing your code as we describe below.

Course git repositories will be hosted as a repository in [GitLab](https://gitlab.cs.washington.edu). Your code will be in a private repository that is visible only to you and the course staff.

#### 1.1.1\. Getting started with Git

There are numerous guides on using `git` that are available. They range from being interactive to just text-based. Find one that works and experiment -- making mistakes and fixing them is a great way to learn. Here is a [link to resources](https://help.github.com/articles/what-are-other-good-resources-for-learning-git-and-github) that GitHub suggests starting with. If you have no experience with `git`, you may find this [web-based tutorial helpful](https://try.github.io/levels/1/challenges/1).

Git may already be installed in your environment; if it's not, you'll need to install it first. For `bash`/Linux environments, git should be a simple `apt-get` / `yum` / etc. install. More detailed instructions may be [found here](http://git-scm.com/book/en/Getting-Started-Installing-Git).

If you are using Eclipse or IntelliJ, many versions come with git already configured. The instructions will be slightly different than the command line instructions listed but will work for any OS. For Eclipse, detailed instructions can be found at [EGit User Guide](http://wiki.eclipse.org/EGit/User_Guide) or [EGit Tutorial](http://eclipsesource.com/blogs/tutorials/egit-tutorial).

#### 1.1.2\. Cloning your Naive Bayes repository

We've created a GitLab repository that you will use to implement Naive Bayes. This repository is hosted on the [CSE GitLab](https://gitlab.cs.washington.edu) site, and you can view it by visiting the GitLab website at `https://gitlab.cs.washington.edu/cse312-19wi/naive-bayes-[your GitLab username]`. If you don't see this repository or are unable to access it, let us know immediately!

The first thing you'll need to do is set up a SSH key to allow communication with GitLab:

1.  If you don't already have one, generate a new SSH key. See [these instructions](http://doc.gitlab.com/ce/ssh/README.html) for details on how to do this.
2.  Visit the [GitLab SSH key management page](https://gitlab.cs.washington.edu/profile/keys). You'll need to log in using your CSE account.
3.  Click "Add SSH Key" and paste in your **public** key into the text area.

While you're logged into the GitLab website, browse around to see which projects you have access to. You should have access to `naive-bayes-[your username]`.

We next want to move the code from the GitLab repository onto your local file system. To do this, you'll need to clone the lab repository by issuing the following commands on the command line:

```sh
$ git clone git@gitlab.cs.washington.edu:cse312-19wi/naive-bayes-MY_GITLAB_USERNAME.git
$ cd naive-bayes-MY_GITLAB_USERNAME
```

This will make a complete replica of the assignment repository locally. If you get an error that looks like:

```sh
Cloning into 'naive-bayes-myusername'...
Permission denied (publickey).
fatal: Could not read from remote repository.
```

... then there is a problem with your GitLab configuration. Check to make sure that your GitLab username matches the repository suffix, that your private key is in your SSH directory (`~/.ssh`) and has the correct permissions, and that you can view the repository through the website.

Cloning will make a complete replica of the lab repository locally. Any time you `commit` and `push` your local changes, they will appear in the GitLab repository.  Since we'll be grading the copy in the GitLab repository, it's important that you remember to push all of your changes!

Let's test out the repository by doing a push of your master branch to GitLab. Do this by issuing the following commands:

```sh
$ touch empty_file
$ git add empty_file
$ git commit -a -m 'Testing git'
$ git push # ... to origin by default
```

The `git push` tells git to push all of your **committed** changes to Gitlab.

After executing these commands, you should see something like the following:

```sh
Counting objects: 4, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 286 bytes | 0 bytes/s, done.
Total 3 (delta 1), reused 0 (delta 0)
To git@gitlab.cs.washington.edu:cse312-19wi/naive-bayes-username.git
   cb5be61..9bbce8d  master -> master
```

We pushed a blank file to our directory, which isn't very interesting. Let's clean up after ourselves:

```sh
$ # Tell git we want to remove this file from our repository
$ git rm empty_file
$ # Now commit all pending changes (-a) with the specified message (-m)
$ git commit -a -m 'Removed test file'
$ # Now, push this change to GitLab
$ git push
```

If you don't know Git that well, this probably seemed very arcane. Just keep using Git and you'll understand more and more. We'll provide explicit instructions below on how to use these commands to actually indicate your final lab solution.

## 2\. Submitting your assignment

You may submit your code any number of times before the deadline; but we will use the latest version you submit that arrives before the deadline. 

## Simple turn-in instructions
1. Click NaiveBayes.java in the file list at the top of the Repository
2. Click Replace

![Alt](/imgs/Replace.PNG)

3. Click "click to upload"
4. Find your file and upload it
5. Click "Replace file"
6. **Confirm that the submitted file is correct on the page now showing.**  
    If it is, you have successfully submitted your program and you don't need to do anything else.
7. **If you make any changes on GitLab after the deadline you will get the late penalty.**

Please make sure that the file you uploaded above is your final solution, as we will be dowloading it at 10 PM on February 8 (unless you are taking a late penalty).

## Using Git for turn-in


Make sure that you are in the same directory as NaiveBayes.java

```sh
$ # Now commit all pending changes (-a) with the specified message (-m)
$ git commit -a -m '[insert commit message here, it can be anything]'
$ # Now, push this change to GitLab
$ git push
```

Just because your code has been committed on your local machine does not mean that it has been submitted -- it needs to be on GitLab! 

**Confirm that you see the correct file on GitLab.**
**If you make any changes on GitLab after the deadline you will get the late penalty.**

#### Final Word of Caution for Git!

Git is a distributed version control system. This means everything operates offline until you run `git pull` or `git push`. This is a great feature.

The bad thing is that you may **forget to `git push` your changes**. This is why we strongly, strongly suggest that you **check GitLab to be sure that what you want us to see matches up with what you expect**.  As a second sanity check, you can re-clone your repository in a different directory to confirm the changes:

```sh
$ git clone git@gitlab.cs.washington.edu:cse312-19wi/naive-bayes-username.git confirmation_directory
$ cd confirmation_directory
$ # ... make sure everything is as you expect ...
```

We've had a lot of fun designing this assignment, and we hope you enjoy hacking on it!