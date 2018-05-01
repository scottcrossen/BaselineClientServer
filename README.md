# String Commands Server

A simple docker client/server setup

### Description

This repository is maintained in Java and designed as a simple demonstration of client/server communication. It's purpose is
to handle string processing on the server instead of on the client (where it is normally put).
There are two main classes that this project focuses on: One of the name StringProcessorProxyNormal and the other of
the name StringProcessorProxyCommand. Both defer normal string processing to the server. The former demonstrates classical
controller methods and the latter demonstrates the command-pattern method.

This project has docker containers for both the client and the backend in addition to a maven container. Both the client and
server containers are composed of a generic java platform. Major services are containerized using
docker's \'docker-compose\' cluster management.

Many of the files contained in this repository also fullfill some of the requirements for the BYU course titled CS 340. It is written and maintained by Scott Leland Crossen.

### Getting Started

#### Development Instructions

To start your *String Processor* server:
1. Make sure that the program 'docker-compose' is installed on your machine.
2. Clone this repository
3. Navigate to the 'docker' Folder
4. Use the command ```docker-compose up``` to start the cluster
5. Additionally, you can attach to individual containers with the command ```docker-compose exec [container_name] bash```

### Helpful Links

[Project Assignment](https://students.cs.byu.edu/~cs340ta/fall2017/group_project/Phase0.5Spec.pdf)
[Class Schematic](https://students.cs.byu.edu/~cs340ta/fall2017/group_project/Phase0.5-Class-Diagram.pdf)

### Contributors

1. Scott Leland Crossen  
<http://scottcrossen.com>  
<scottcrossen42@gmail.com>
