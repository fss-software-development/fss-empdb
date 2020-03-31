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
            environment {
                scannerHome = tool 'sonar-qube-scanner'
            }
            steps {
                withSonarQubeEnv('sonarqube') {
                    bat "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}

