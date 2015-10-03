#An In-Depth Resource for Docker
- This readme is a combination of notes taken on the three Docker training videos and my personal experience with using Docker to deploy Labelcraft as well as other parts of our GridIron DevOps pipeline.
- https://training.docker.com/

- Hypervisor - virtual machine monitor (VMM) creates and runs virtual machines. A computer which has a hypervisor on it is a host machine.
- VM's require their own guest operating system (huge waste of resources)
- Also require their own storage, CPU and RAM

###Docker Terms
####Images
- Read only
- Have instructions about which programs to install as well as various settings and environment variables

####Containers
- Similar to a VM in concept, but do not require a separate operating system
- Created based on the instructions set out in the images given to it
- From the outside, looks and operates like a VM
![Alt text](https://i.gyazo.com/8822ffd6c99d6d544e33b78f3d39f752.png?raw=true "Container Explanation")
- The reason for containers is to enable environmental configurations specifically required by different applications
- Isolates the run-time environments
- When your container process stops, the container stops.
- Running in the background is also called running as a daemon or running in "detached mode"
- -P maps ports from the container to the physical machine
example: docker run -d -P tomcat:7
run docker ps to see what ports get mapped where
Docker containers are stacks of images
Parent images are read only
Copy on write system (copies the read-only version to the writeable container)

##Dockerfile Syntax and Best Practices
FROM specifies what the base image should be

RUN specifies a command to execute
	-can aggregate commands by using && as well as the newline "/"
	each RUN instruction will execute the command and then commit that new image
	The less RUN commands you have, the less times it will need to commit images (it will do all the work up front, then commit a single image)

VOLUME creates a mount point
	This can be used to store logs on the host machine so that if the container dies, the logs are maintained.

Docker HUB can detect and autobuild whenever a change occurs in Git (this just creates a new image, doesn't necessarily deploy it)

##Commands to Know

To start, stop or restart docker if installed as a service
```shell
	service docker start / stop / restart
```

To add a user to the docker group so that you don't need to include sudo in front of "docker" commands
```shell
	sudo usermod -aG docker username
```

To get a list of images (these are the things used to create containers)
```shell
	docker images (-a flag will show all images)
```

To get a list of containers and their associated information (port mappings, name, container ID, etc.)
```shell
docker ps (flag -a will show everything)
```
To build an image from a Dockerfile (must be inside a directory with a Dockerfile)
```shell
docker build -t image_name
```


```shell
docker run -d image_to_build
The -d flag allows the container to run as a daemon and will not take over your terminal
When using the -p (lowercase p) command to map a port, it applies to a single argument via the format HOST_PORT:CONTAINER_PORT
	e.g. -p 8080:8080
	You can use the -P (uppercase P) command to allow the host to automatically map these ports
```

To kill a daemon (if you ran docker with sudo ./docker -d and did not start as a service)
```shell
sudo kill $(pidof program_name) 
```

To remove all untagged images (both of these should work):
```shell
docker rmi $(docker images | grep "^<none>" | awk '{print $3}')
docker rmi $(docker images -q --filter "dangling=true")
```

To grab the stdout from the main CMD process running on your container
```shell
docker logs container_name
```

Starts a terminal within the running container
```shell
docker exec -it container_name bash
-i flag specifies STDIN
-t specifies creating a pseudo-terminal (treat this like a normal bash shell that exists within the container)
```

Huge information dump about your container
```shell
docker inspect gjvoit_nginx
```

##Security
- Resources
- https://github.com/docker/distribution
- https://docs.docker.com/registry/overview/
- Isolation via containerization means processes operating in one container means they cannot see and affect processes in another
- Isolates resources as well as namespaces
- E.g. DDoS would only take down one container
- One potential risk - docker daemon needs to run as root, so only very trusted users should be given access to this group
- Can enable TLS

##Scaling and Orchestration
###Docker Machine
- Provisions docker hosts and installs Docker on them
- Creates the server on the chosen environment (AWS in our case)
- Installs Docker Engine
- Configures the Docker Client

####Installing Docker Machine
- Download the binary for your OS
- wget binary
- Rename file to docker-machine
- chmod 775
- Add the folder to your system environment PATH

####Commands
- Create a new machine
- This varies with cloud providers
- For AWS Install
```shell
docker-machine create --driver amazonec2 --amazonec2-vpc-id VPC_ID_HERE --amazonec2-access-key AWS_ACCESS_KEY --amazonec2-secret-key AWS_SECRET_KEY machine-name
```

docker-machine create --driver amazonec2 --amazonec2-vpc-id $AWS_VPS_ID --amazonec2-access-key $AWS_ACCESS_KEY_ID --amazonec2-secret-key $AWS_SECRET_ACCESS_KEY testMachine4 


docker-machine create \
    --
    --driver amazonec2 \
    --amazonec2-access-key $AWS_ACCESS_KEY_ID \
    --amazonec2-secret-key $AWS_SECRET_ACCESS_KEY \
    --amazonec2-vpc-id $AWS_VPS_ID
    test-instance1

- This was failing due to inability to create Security Groups (Docker-Machine tries to make its own security group if none is specified)
- Attempted to use --config and specify a preexisting security config but without success.

```shell
docker-machine create --driver amazonec2 --amazonec2-vpc-id $AWS_DEFAULT_VPC --amazonec2-security-group Docker --amazonec2-access-key $AWS_ACCESS_KEY --amazonec2-secret-key $AWS_SECRET_KEY testMachineWithSecGroups2
```
- Update, SSH rights is not the problem - seems to be a problem with creating / assigning the server to a security group.
Error creating machine: Error making API call to authorize security group ingress: Non-200 API response: code=403 message=You are not authorized to perform this operation.

List out machines
```shell
docker-machine ls
```

SSH
```shell
docker-machine ssh hostname_of_machine
```

###Docker Swarm
- Clusters many Engines and schedules containers
- https://docs.docker.com/swarm/discovery/
![Alt text](https://i.gyazo.com/12cf67add75d74400e7988f120faa59a.png?raw=true "How Swarm Works")

####Installation
Run the docker image on Docker Hub


- Docker Compose - Creates and manages multi-container applications
- Finished training videos, but need to review some things like volumes and how to use Docker Hub

#Docker Private Registry Guide

##Pulling and Pushing to private registry

###In order to start pulling/pushing, we need to setup some files

Edit config file to bypass required certificates
```shell
sudo vim /etc/sysconfig/docker
```

Mirror your config file to look like this
```shell
# Additional startup options for the Docker daemon, for example:
# OPTIONS="--ip-forward=true --iptables=true" 
OPTIONS= 
 
 
other_args="--insecure-registry PRIVATE_IP_OF_HOST_SERVER:HOSTPORT"
```

Restart your docker service
```shell 
sudo service docker restart
```
##Docker Commands

After you build a docker image, tag it
```shell
docker tag PRIVATE_IP_OF_HOST_SERVER:HOSTPORT/IMAGE_NAME
```

To push the image to our private docker registry
```shell
docker push PRIVATE_IP_OF_HOST_SERVER:HOSTPORT/IMAGE_NAME
```

To pull an image from private docker registry
```shell
docker pull PRIVATE_IP_OF_HOST_SERVER:HOSTPORT/IMAGE_NAME
```

##Setting up the private registry

Pull and run the docker registry
```shell
docker run -d -p HOSTPORT:5000 --restart=always --name registry \
  -v `pwd`/data:/var/lib/registry \
  registry:2
  ```

To stop and remove the registry
```shell
docker stop registry && docker rm -v registry
```


