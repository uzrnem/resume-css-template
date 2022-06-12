ssh-keygen -t ed25519 -C "uzrnem@gmail.com"

git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:uzrnem/new-repo.git
git push -u origin main
git gui
git remote -v

sudo apt-get install git-gui
git config --global user.email "bhagyeshsunilpatel@gmail.com"
git config --global user.name "uzrnem"