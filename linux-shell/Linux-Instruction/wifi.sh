echo "blacklist ideapad_laptop" | sudo tee -a /etc/modprobe.d/blacklist-ideapad.conf
sudo modprobe -r ideapad-laptop
sudo rfkill unblock all
rfkill list all
