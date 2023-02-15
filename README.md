# Jenkins Pipelines

## Local setup

* Spin up the controller:

`docker compose up -d`

## Notes

* In order to get the initial password requested after start the Jenkins UI

`docker exec jenkins-master cat /var/jenkins_home/secrets/initialAdminPassword`

* new war file from updates could be stored in: `/usr/share/jenkins/jenkins.war`
