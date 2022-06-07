# README - Assignment 1

## Part 1

### Description

Part 1 assignment is the static website homepage. It can be accessed at http://hw1p1.s3-website-us-east-1.amazonaws.com/

It will list all future assignments as well as part 2. 

As Part 1 is pretty basic and a homepage, I will not include installation instructions.

## Part 2 

### Description

For Part 2 I created a Dynamic Web Project in Eclipse EE. It contains two HTML files and a single CSS stylesheet. I exported this project as a WAR and threw it up on my running EC2 instance. This can be accessed either from the part 1 link and clicking on "Assignment 1" or it can be accessed at https://ec2-54-84-46-94.compute-1.amazonaws.com/hw1p2 

### Installation

#### From Source

To install and run locally from source, I would suggest using Eclipse EE and download the source files in folder `part 2`. Once you have done that you can simply right click on the project titled `hw1p2` in Eclipse and Select `Run As -> Run as Server`. Then after setting up configuration for Tomcat 8.5 to match our Bitnami AWS version you should be able to view the website at localhost:8080/hw1p2 .

#### From WAR

To deploy the WAR file included in the package you must have a running instance of tomcat 8.5 and be able to copy or move the WAR titled `hw1p2.WAR` to the `$CATALINA_HOME/webapps` directory. This will allow tomcat to unpack and serve it at `<tomcat-url>/hw1p2`