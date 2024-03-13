pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'C:\\apache-maven-3.9.6\\bin\\mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'C:\\apache-maven-3.9.6\\bin\\mvn test'
            }
        }
        stage('Deploy Docker image') {
            steps {
                bat 'docker build -t thiakanejean/jenkinsautomation .'
            }
        }
        stage('Push image to hub') {
            steps {
                script{
                    withCredentials([string(credentialsId: 'thiakanejean', variable: 'dockerhubpwd')]) {
                    bat 'docker login -u thiakanejean -p ${dockerhubpwd}'
                    }
                    bat 'docker push thiakanejean/jenkinsautomation '
            }
        }
    }
    }
}
