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

### Copyright & Plagarism Notes

1. **General:** As shown in the attached license, I yield any rights that I posses related to this project in regards to copyright or anti-plagiarism law enforcement as long as my full name is attributed to somewhere in the code-base or credits screen and the terms of the license agreement are propagated in the resulting code. I am absolutely fine with businesses or students using this -- or part of this -- code under these conditions.

2. **BYU:** This project fulfills course requirements for one or more classes at BYU. After reviewing BYU's honor code thoroughly (an act prompted by a vindictive professor who apparently hasn't read the honor code himself), I have learned that the only restriction on sharing my code online is if I have the intention of providing "unfair advantage over other students" or if I intentionally plan to "commit acts of academic dishonesty". Because I do not have any such intentions (I am sharing this with the general public for the purpose of the open source community and it's ideals), any subsequent actions taken by others resembling cheating or gaining an unfair advantage in their school work would be coincidental and not related to me in any way. I will not knowingly assist other students with their coursework nor will I accept responsibility for their actions given that the terms of the attached license are correctly observed.

3. **Students:** If you are a student then please note that it appears that there is nothing wrong with including others' work as long as you adhere to the terms of their license or copyright. If this were not the case then students could not program in any language besides basic machine code - because any higher abstraction would arguably be using work completed by other people. You may want to check your university's academic policy, but I believe you should be free to use this repository in your work. Recall however, that I dissociate myself of any of your actions and will not knowingly assist (or litigate for that matter) anyone with such intentions given that the terms of this license are adhered to.

4. **Professors:** If you are a professor that takes issue with the public nature of this repository then I would like to hear from you. Please contact me at my public email address listed on github and be sure to include: (1) your contact information, (2) the clause in the honor code or university policy that I am breaking, and (3) any other information that shows that academic dishonesty has occurred such as unattributed source code. I respect all the professors that I have worked with in my academic career and would be fine with removing this repository from my public-facing account given a respectful request (please do not threaten me as other professors have done). I hope however, that you will learn something from these notes about how the software community works and what allegations you as a professor are allowed to make related to academic dishonesty. That said, I’m usually very cooperative.

### Contributors

1. Scott Leland Crossen  
<http://scottcrossen42.com>  
<scottcrossen42@gmail.com>
