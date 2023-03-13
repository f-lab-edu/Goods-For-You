pipeline {
    agent any
    environment {
        PATH = "/opt/gradle/gradle-7.6/bin:$PATH"
    }

    stages {

        stage('Git Checkout') {
            steps {
                checkout scm
                echo 'Git Checkout Success'
            }
        }
        
        stage('Check Java Version'){
            steps {
                sh 'java --version'
            }
        }

        stage('Gradle Test') {
            steps {
                sh './gradlew test'
                echo 'test success'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build --exclude-task test'
                echo 'build success'
            }
        }
    }
}
