pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/main']],
                          doGenerateSubmoduleConfigurations: false,
                          extensions: [],
                          gitTool: 'Default',
                          submoduleCfg: [],
                          userRemoteConfigs: [[url: 'https://github.com/optit-cloud-team/optit-lab-service.git']]])
            }
        }

        stage('Build with Gradle') {
            steps {
                script {
                    // Your build with Gradle steps here
                    // Example:
                    sh 'gradle build'
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    // Your Docker build steps here
                    // Example:
                    sh 'docker build -t my-image .'
                }
            }
        }

        stage('Docker Publish') {
            steps {
                script {
                    // Your Docker publish steps here
                    // Example:
                    sh 'docker push my-image'
                }
            }
        }
    }
}
