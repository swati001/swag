# Docker + Kubernetes

## Docker

Here we can use docker for creating an image of our application which we have built in Node.js. For creating image we should create a Dockerfile which is simple text file and based on an image, something like:

```
 FROM node8
 MKDIR /var/app
 COPY . /var/app
 CMD ["npm","install"]

```

## Kubernetes or k8s

Kubernetes is basically a container orchestration, - a tool that takes care of the deployment, management, scaling, networking of container-based applications.:

A sample k8s pod.yaml file looks like this:

```
apiVersion: v1
kind: Pod
metadata:
  name: my-web-pod
  labels:
    app: web
```



