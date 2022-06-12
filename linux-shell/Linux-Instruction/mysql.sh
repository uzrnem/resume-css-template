mkdir /var/run/mysqld
touch /var/run/mysqld/mysqld.sock
chown -R mysql /var/run/mysqld
ls -lart /var/run/mysqld
/etc/init.d/mysql restart
