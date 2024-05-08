# Tech News Java API

My first Java API using Spring Boot for backend servicing and Thymeleaf to render the frontend
Here is a link to the deployed website: [Jburton-Java-API](https://jburton-java-api-1cf73a69112b.herokuapp.com/)

## Description

The social network api contains all the backend services to operate a full-stack blog-type app. 

This backend allows you to store users, "thoughts"(user posts), and "reactions"(user comments). The application is powered by Spring Boot, MySQL and Spring Data JPA (for Object Relational Mapping) and allows the user to interact with the database through the frontend via Thymeleaf's serverside rendering. 

## Table of Contents 
1. [Usage](#usage)
2. [Challenges](#challenges)

## <a id='usage'>Usage</a>

This application is deployed to Heroku, where you can access it via the this [link](https://jburton-java-api-1cf73a69112b.herokuapp.com).

## <a id='challenges'>Challenges</a>

During the development of this app, I went through various challenges and obstacles to end up with the deployed website I have now.

For starters, this was my FIRST time ever coding in Java. But thanks to my prior experience working on various projects, understanding Java actually came quite easily. I've had the most experience coding in Javascript and I did find Java to be MUCH more strict in data typing.

My second biggest issue was the fact that I was learning from an outdated tutorial. I had to look up A LOT of workarounds to various deprecated codebits, which was annoying. However, I am aware that almost all code in our modern day is deprecated to an extent and upkeeping today's products and projects is an impossible ask for current day programmers. I still find it funny that Javascript LEGIMATELY CANNOT BE REPLACED because of how much of the internet depends on it.

The biggest hurdle though was actually deploying my project. My tutorial made it seem like I just clicked a few options here and there on Heroku and bingo, it'll be deployed... no sir, that did not happen. This took several hours of just debugging, committing, pushing, debugging again. At first, my project wouldn't even build in Heroku. Once I got it to build correctly, I found that my website was crashing (I thought was done but nope. Back to debugging mode). One of the many things I found myself doing was rebuilding my project to make sure the version of Java it was using was compatible with Heroku, as well as manually setting the version for Heroku's environment.

However, despite all my trials my website stands tall as a functioning project!

## <a id='questions'>Questions</a>

If you have any additional questions, contact me through email:
- Email: [jordane.burton@gmail.com]
