pipeline {
    agent any

    parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build from')
        string(name: 'GIT_URL', defaultValue: 'https://github.com/optit-cloud-team/optit-lab-service.git', description: 'Git repository URL')
        string(name: 'DOCKER_IMAGE_NAME', defaultValue: 'optit-lab-service', description: 'Docker image name')
        string(name: 'DOCKER_REPO', defaultValue: 'bharathoptdocker', description: 'Docker repository')
    }

    stages {
        stage('Git Checkout') {
            steps {
                script {
                    gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
                }
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    buildWithGradle()
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    dockerBuild(params.DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Docker Publish') {
            steps {
                script {
                    dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                }
            }
        }
    }
}

def gitCheckout(String branch, String gitUrl, String credentialsId) {
    git branch: branch,
        credentialsId: credentialsId,
        url: gitUrl
}

def buildWithGradle() {
    sh './gradlew build' // Command to execute Gradle build
}

def dockerBuild(String imageName) {
    docker.build(imageName, ".") // Using parameter for Docker image name
}

def dockerPublish(String imageName, String dockerRepo, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        def buildId = env.BUILD_ID
        def imageNameWithTag = "${dockerRepo}/${imageName}:${buildId}"
        sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
        sh "docker tag ${imageName} ${imageNameWithTag}"
        sh "docker push ${imageNameWithTag}"
    }
}
