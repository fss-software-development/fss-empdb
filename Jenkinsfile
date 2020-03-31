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
           steps {
                  script {
                    // requires SonarQube Scanner 2.8+
                    scannerHome = tool 'sonar-scanner'
                  }
                  withSonarQubeEnv('FSS Sonar Qube') {
                    bat "${scannerHome}/bin/sonar-scanner"
                  }
                }
        }
    }
}

