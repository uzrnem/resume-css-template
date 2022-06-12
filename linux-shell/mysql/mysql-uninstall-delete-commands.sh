sudo apt-get remove --purge mysql-server mysql-client mysql-common mysql-server-core-* mysql-client-core-*

sudo rm -rf /etc/mysql /var/lib/mysql /var/lib/mysql-*

sudo apt autoremove

#System commands
systemctl is-enabled mysql
systemctl is-active mysql
sudo service mysql status
sudo service mysql stop
sudo systemctl disable mysql

#Remove MySQL
cd /var/lib/mysql
sudo su
sudo apt-get remove --purge mysql-server mysql-client mysql-common mysql-server-core-* mysql-client-core-*
sudo rm -rf /etc/mysql /var/lib/mysql
sudo apt autoremove
sudo apt-get update