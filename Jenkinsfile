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
                    def gitCheckout = load 'pipeline-scripts/gitCheckout.groovy'
                    gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
                }
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    def buildWithGradle = load 'pipeline-scripts/buildWithGradle.groovy'
                    buildWithGradle()
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    def dockerBuild = load 'pipeline-scripts/dockerBuild.groovy'
                    dockerBuild(params.DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Docker Publish') {
            steps {
                script {
                    def dockerPublish = load 'pipeline-scripts/dockerPublish.groovy'
                    dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                }
            }
        }
    }
}