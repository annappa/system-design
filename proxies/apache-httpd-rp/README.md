## Info and Docs
[Documentation](https://httpd.apache.org/docs/current/)

[Configuration Overview](https://httpd.apache.org/docs/current/configuring.html)

[Directive Index](https://httpd.apache.org/docs/current/mod/directives.html)

[Log Files](https://httpd.apache.org/docs/current/logs.html)

[What is the difference between Apache Web Server and Apache HTTPD?
](https://superuser.com/questions/1434629/what-is-the-difference-between-apache-web-server-and-apache-httpd)

[Is there any difference between apache2 and httpd?](https://askubuntu.com/questions/248404/is-there-any-difference-between-apache2-and-httpd)

## Imp Commands
```shell script
apachectl status

apachectl start

apachectl stop

apachectl graceful-stop

apachectl restart

apachectl graceful

service apache2 status
sudo service apache2 graceful

sudo /etc/init.d/apache2 start

apachectl -V

apachectl -t  --> Tests the syntax of the config files

apachectl -t -D DUMP_VHOSTS   -> shows the VirtualHost configuration

apachectl -t -D DUMP_MODULES --> List the modules enabled

sudo a2dismod status --> disables the module "status"

grep -Ri ErrorLog /etc/apache2/
grep -Ri "export APACHE_LOG_DIR" /etc/apache2/

```

## General
Different distributions put the configuration file in different places and can have drastically different configuration structures. 

In **Fedora and CentOS**, the default location is `/etc/http/conf/httpd.conf`. The configuration is typically one monolithic file containing information about every site. 

In **Debian and Ubuntu**, the default location is `/etc/apache2/apache2.conf`.