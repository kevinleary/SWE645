https://github.com/rancher/rke/releases/tag/v1.3.11

https://rancher.com/docs/rke/latest/en/installation/#download-the-rke-binary

https://formulae.brew.sh/formula/openssh

then install kubectl 

https://kubernetes.io/docs/tasks/tools/install-kubectl-macos/#install-with-homebrew-on-macos

looks like we need to create a cluster.yml

starting RKE 

https://rancher.com/docs/rke/latest/en/installation/#creating-the-cluster-configuration-file

needed to create local ssh key 

`ssh-keygen -t rsa`

working to create a bare-metal node to interact with kubernetes locally

I also think that docker desktop allows for this to be done

https://github.com/rancher/quickstart

connect to ec2 for k8s

`ssh -i "hw2-k8s-key.pem" ec2-user@ec2-54-87-46-136.compute-1.amazonaws.com`

install docker 

https://docs.docker.com/engine/install/centos/

had to add `--privileged` flag to the docker run command for starting it without k8s

```bash
docker run -d --name=rancher --restart=unless-stopped \
  -p 80:80 -p 443:443 \
  --privileged \
  rancher/rancher:latest
  ```

  ```bash
docker run -d --name=rancher --restart=unless-stopped \
  -p 8080:80 -p 8443:443 \
  --privileged \
  rancher/rancher:latest
  ```

aws public 

https://ec2-52-87-185-54.compute-1.amazonaws.com


```bash
sudo docker run -d --privileged --restart=unless-stopped --net=host -v /etc/kubernetes:/etc/kubernetes -v /var/run:/var/run  rancher/rancher-agent:v2.6.5 --server https://ec2-52-87-185-54.compute-1.amazonaws.com --token 6gxkz2r7nqq54j5w49g9xxkk67jwnfcs8g5bqnzckxqmmmww7c6dmq --ca-checksum 91e787b89952dcd3199783ec062b95f39ddf404ca85ac1b9b4a4528339631978 --etcd --controlplane --worker
```

EC2 public IPv4 changes everytime it's restarted?

Tried to do this on a single node found this - didn't work 
https://rancher.com/docs/rancher/v2.6/en/installation/other-installation-methods/single-node-docker/


added my container from docker hub @ kleary5/hw2p1-tomcat:0.1.3

had a problem with the image built on my M1 chip mac 

--platform linux/x86_64 

http://ec2-54-221-147-148.compute-1.amazonaws.com:31966/hw1p2/

issue with channing ec2 instances

https://github.com/rancher/rancher/issues/21926#issuecomment-517620288
