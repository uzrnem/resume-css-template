
docker save myusername/myproject:latest | gzip -c > myproject_img_bak20141103.tgz

gunzip -c myproject_img_bak20141103.tgz | docker load