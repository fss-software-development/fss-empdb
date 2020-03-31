pipeline {
    agent any
     tools {
            maven 'Maven 3.6.3'
        }
    stages {

        stage('Clone sources') {
            steps {
                    git url: 'https://github.com/fss-software-development/fss-empdb'
                }
         }
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Sonar') {
           steps {
               def scannerHome = tool 'sonar-scanner'
               withSonarQubeEnv('SonarQube') {
                   sh "${scannerHome}/bin/sonar-scanner"
               }
           }
        }
    }
}

