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

aws public 

ec2-54-87-46-136.compute-1.amazonaws.com
