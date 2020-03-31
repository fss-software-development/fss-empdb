pipeline {
    agent any
     tools {
            maven 'Maven 3.6.3'
        }
    stages {

       /* stage('Clone sources') {
            steps {
                    git url: 'https://github.com/fss-software-development/fss-empdb'
                }
         }
         */

        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Quality Analysis') {
            def sonarqubeScannerHome = tool name: 'sonar-scanner'
            sh "${sonarqubeScannerHome}/bin/sonar-scanner"
        }
    }
}

