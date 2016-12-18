# Third Assignment Delivery
#### Gabriele Scarton
This is the third assignment for [IntroSDE course] at [Unitn].
The goal of the assignment is to create a SOAP service composed by a server and a test client.
The server is deployed on Heroku at **isde3-scarton.herokuapp.com**
This repository contains the test client.
## Specifications
  - Dependency manager: [Ivy]
  - Build tool: [Ant]

##  Client
The client contains two packages:
  - The model imported from the server with _wsimport_
  - The main class which test all the functionalities of the server

## How to run the code

> In order to run the code as it's intended, you need to have installed [Ant]

#### The client
In order to compile the client, you can write in the console:
```
$ ant compile
```
or, since it's the default target:
```
$ ant
```
In order to execute the client and create the logs (an already-generated sample is included in the repository) you can use the console command:
```
$ ant execute.client
```

[Ant]: <http://ant.apache.org/>
[Ivy]: <http://ant.apache.org/ivy/>
[IntroSDE course]: <https://sites.google.com/a/unitn.it/introsde_2016-17/>
[Unitn]: <unitn.it>
