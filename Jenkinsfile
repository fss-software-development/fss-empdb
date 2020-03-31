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
                        bat 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install'
                        bat 'StartSonar.bat'
                        bat 'c:/Soft/sonar-scanner/bin/sonar-scanner.bat'
                    }
        }
    }
}

