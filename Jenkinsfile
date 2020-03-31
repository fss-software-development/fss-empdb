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
                bat 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install'
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

        stage("Quality Gate") {
            steps {
                sleep(60)
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}

